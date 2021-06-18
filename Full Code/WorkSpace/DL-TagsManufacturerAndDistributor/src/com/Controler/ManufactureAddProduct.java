package com.Controler;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.json.simple.JSONObject;

import blockchaincall.BlockChain;
import blockchaincall.BlockChainUrl;
import blockchaincall.ObjectConversion;

import com.Modul.ContractModel;
import com.Modul.SupplierModel;
import com.http.servlet.HttpsServlet;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

public class ManufactureAddProduct extends HttpsServlet {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Date d = new Date();
		System.out.println(d);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String sdate = sdf.format(d);
		System.out.println("=========date is" + sdate);

		String name = null, proid = null, descrip = null, price = null, Quanity = null;
		HttpSession httpSession = request.getSession(false);
		String manu_name = (String) httpSession.getAttribute("name");
		List<SupplierModel> list = (List<SupplierModel>) httpSession
				.getAttribute("info");

		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			String filepath = "", cantractpath = "", proImage = null;
			List<FileItem> items = upload.parseRequest(request);
			File f1 = null;

			for (FileItem locFileItem : items) {
				if (locFileItem.isFormField()) {
					System.out.println("---" + locFileItem.getFieldName());

					if (locFileItem.getFieldName().equals("proid")) {
						proid = locFileItem.getString();
					}
					if (locFileItem.getFieldName().equals("name")) {
						name = locFileItem.getString();
					}
					if (locFileItem.getFieldName().equals("description")) {
						descrip = locFileItem.getString();
					}

					if (locFileItem.getFieldName().equals("price")) {
						price = locFileItem.getString();
					}

					if (locFileItem.getFieldName().equals("Quanity")) {
						Quanity = locFileItem.getString();
					}

				} else {
					filepath = "webapps/DL-TagsManufacturerAndDistributor/photo/";
					cantractpath = "webapps/DL-TagsManufacturerAndDistributor/dL-TagsManufacturerAndDistributor";
					String path = filepath;

					File f = new File(path);
					f1 = new File(cantractpath);
					if (!f.exists()) {
						f.mkdirs();

					}
					if (!f1.exists()) {
						f1.mkdirs();
					}
					String filename = locFileItem.getName();
					System.out.println("Filename is " + filename);
					File tosave = new File(path, proid + ".jpg");
					proImage = tosave.getPath();
					locFileItem.write(tosave);

				}

			}
			ContractModel contractModel = new ContractModel();
			contractModel.setManuName(name);
			contractModel.setPrice(price);
			contractModel.setProId(proid);
			contractModel.setImagePath(proImage);
			contractModel.setHashMap(list);

			Connection connection = (Connection) getServletContext()
					.getAttribute("connection");

			Statement st = connection.createStatement();

			for (SupplierModel model : list) {
				SupplierModel supplierModel = (SupplierModel) model;

				ResultSet rs1;
				rs1 = st
						.executeQuery("select * from manufac_inven where supilerid='"
								+ supplierModel.getName()
								+ "' AND product_id='"
								+ supplierModel.getProduceid() + "'");
				if (rs1.next()) {
					// update
					String sel_quan = rs1.getString("quanity");
					sel_quan = String.valueOf(Integer.parseInt(sel_quan)
							- Integer.parseInt(supplierModel.getDesc()));
					int j = st
							.executeUpdate("update manufac_inven set quanity='"
									+ sel_quan + "'" + "where supilerid='"
									+ supplierModel.getName()
									+ "' AND product_id='"
									+ supplierModel.getProduceid() + "'");
				} else {

				}

			}

			/*
			 * String path = commonMet(request) + "\\Manufacture"; File file =
			 * new File(path); if (!file.exists()) { file.mkdirs(); } File file2
			 * = new File(path + File.separator + proid + ".ser"); if
			 * (!file2.exists()) { file2.createNewFile(); } ObjectOutputStream
			 * oos = new ObjectOutputStream( new FileOutputStream(file2));
			 * oos.writeObject(contractModel); oos.close();
			 */

			JSONObject jsonObject = new JSONObject();
			jsonObject.put("productid", proid);
			jsonObject.put("filename", name);

			jsonObject.put("filepath", Base64.encode(new ObjectConversion()
					.objToByte(contractModel)));
			jsonObject.put("sender", "12");
			jsonObject.put("recipient", "12");
			jsonObject.put("amount", "12");

			String resp = BlockChain.addTransaction(jsonObject.toJSONString(),
					BlockChainUrl.MANUFACTURE_TRANS);
			BlockChain.mineChain(BlockChainUrl.MANUFACTURE_MINE);

			String query = "insert into manu_product(Productid,Manufacturename,Productname,Price,Imagepath,Description) values(?,?,?,?,?,?,?,?,?)";

			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, proid);
			ps.setString(2, manu_name);
			ps.setString(3, name);
			ps.setString(4, price);
			ps.setString(5, proImage);
			ps.setString(6, descrip);
			int i = ps.executeUpdate();

			String query_ship = "insert into shipment(Productid,Supplier) values(?,?)";

			PreparedStatement ps1 = connection.prepareStatement(query_ship);

			ps1.setString(1, proid);
			ps1.setInt(2, 1);
			int i1 = ps1.executeUpdate();

			System.out.println(i1);
			String msg = "product manufacturing process";
			request.setAttribute("msg", msg);
			RequestDispatcher rd = request
					.getRequestDispatcher("manufacture.jsp");
			rd.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			List<SupplierModel> supplierModels = new ArrayList<SupplierModel>();

			String id[] = request.getParameterValues("sele");
			String in[] = request.getParameterValues("optio");
			List<String> list = new LinkedList<String>(Arrays.asList(id));
			for (int j = 0; j < list.size(); j++) {
				if (list.get(j).equals("0")) {
					list.remove(j);
				}
			}

			for (int i = 0; i < in.length; i++) {
				String info[] = in[i].split("@");
				SupplierModel model = new SupplierModel();
				model.setName(info[0]);
				model.setProduceid(info[1]);
				model.setProductname(info[2]);
				model.setDesc(list.get(i));

				supplierModels.add(model);
			}

			request.setAttribute("info", supplierModels);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("ManufactureAddProduct.jsp");
			dispatcher.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@SuppressWarnings("deprecation")
	public String commonMet(HttpServletRequest request) {
		String accmail = "";
		try {
			Properties prop = new Properties();
			String s1 = request.getRealPath("/");
			FileInputStream fis = new FileInputStream((new StringBuilder())
					.append(s1).append("ip.properties").toString());
			prop.load(fis);
			accmail = prop.getProperty("location").trim();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return accmail;
	}

}
