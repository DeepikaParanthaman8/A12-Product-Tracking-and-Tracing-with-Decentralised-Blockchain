package com.distributor;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import blockchaincall.BlockChain;
import blockchaincall.BlockChainUrl;
import blockchaincall.ObjectConversion;

import com.Dao.UserDao;
import com.Modul.ContractModel;
import com.Modul.DistributorModel;
import com.http.servlet.HttpsServlet;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

public class DisPrice extends HttpsServlet {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession hs = request.getSession(false);
		String distributor = (String) hs.getAttribute("did");
		String dname = (String) hs.getAttribute("name");
		String pid = request.getParameter("pid");
		String dprice = request.getParameter("dprice");
		String man = request.getParameter("man");
		String price = request.getParameter("price");
		String pname = request.getParameter("panme");
		String image = request.getParameter("image");
		String date = request.getParameter("date");
		String pack = request.getParameter("pack");
		String edate = request.getParameter("edate");
		String qrcodeimg = request.getParameter("qrcodeimg");

		System.out.println("distributor" + distributor);
		System.out.println("dname" + dname);
		System.out.println("dname" + dname);
		System.out.println("pid" + pid);
		System.out.println("dprice" + dprice);
		System.out.println("man" + man);
		System.out.println("price" + price);
		System.out.println("pname" + pname);
		System.out.println("image" + image);
		System.out.println("qr--------code" + qrcodeimg);

		Date d = new Date();
		System.out.println(d);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String sdate = sdf.format(d);
		System.out.println("=========date is" + sdate);

		UserDao userDao = new UserDao();
		boolean result = userDao.updateDistributorProducts(distributor, pid,
				dprice);
		String msg = "";
		if (result) {
			msg = "Distributor contract created successfully";
			try {
				String chainre = BlockChain
						.retriveChain(BlockChainUrl.MANUFACTURE_CHAIN);
				System.out.println(chainre);
				JSONObject jsonObject1 = (JSONObject) new JSONParser()
						.parse(chainre);
				JSONArray array = (JSONArray) jsonObject1.get("chain");
				JSONObject json = null;
				JSONArray array2 = null;
				String path = null;
				for (int i = 1; i < array.size(); i++) {
					json = (JSONObject) array.get(i);
					array2 = (JSONArray) json.get("transactions");
					json = (JSONObject) array2.get(0);
					String pro_id = (String) json.get("productid");
					if (pro_id.equals(pid)) {
						path = (String) json.get("filepath");

						byte[] object = (byte[]) Base64.decode(path);
						Object findbyid = (Object) new ObjectConversion()
								.byteToObj(object);
						if (findbyid instanceof ContractModel) {
							ContractModel sample = (ContractModel) findbyid;

							System.out.println(pname);
							System.out.println(sample.getManuName());

							DistributorModel distributorModel = new DistributorModel();
							distributorModel.setContractModel(sample);
							distributorModel.setDisId(distributor);
							distributorModel.setProname(pname);
							distributorModel.setDisPrice(dprice);
							distributorModel.setImages(image);
							distributorModel.setProid(pid);
							distributorModel.setQrcode(qrcodeimg);

							JSONObject jsonObject = new JSONObject();
							jsonObject.put("productid", pid);
							jsonObject.put("filename", sample.getManuName());
							jsonObject.put("filepath", Base64
									.encode(new ObjectConversion()
											.objToByte(distributorModel)));
							jsonObject.put("sender", "12");
							jsonObject.put("recipient", "12");
							jsonObject.put("amount", "12");

							System.out.println("********" + jsonObject);

							String resp = BlockChain.addTransaction(jsonObject
									.toJSONString(),
									BlockChainUrl.DISTRIBUTOR_TRANS);
							BlockChain
									.mineChain(BlockChainUrl.DISTRIBUTOR_MINE);

						} else {
							System.out.println();
						}

					} else {
						System.out.println("========================");
					}
				}

			} catch (Exception e) {
				// TODO: handle exception
				// e.printStackTrace();
			}

		} else {
			msg = "Failed to create a contract";
		}
		request.setAttribute("msg", msg);
		RequestDispatcher rd = request.getRequestDispatcher("dpros.jsp");
		rd.forward(request, response);
		out.close();
	}

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
