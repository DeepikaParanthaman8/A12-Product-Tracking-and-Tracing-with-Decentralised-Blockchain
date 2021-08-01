package com.distributor;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.Dao.Dao;
import com.dis.modul.FakeProductPojo;

public class FackProduct extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try {

			Dao dao = new Dao();
			String mName = null, productid = null, productName = null, price = null;
			HttpSession httpSession = request.getSession(false);
			String manu_name = (String) httpSession.getAttribute("name");
			/*
			 * List<AddProduct> list = (List<SupplierRegPojo>) httpSession
			 * .getAttribute("info");
			 */
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

						if (locFileItem.getFieldName().equals("mName")) {
							mName = locFileItem.getString();
						}

						if (locFileItem.getFieldName().equals("productid")) {
							productid = locFileItem.getString();
						}

						if (locFileItem.getFieldName().equals("productName")) {
							productName = locFileItem.getString();
						}

						if (locFileItem.getFieldName().equals("price")) {
							price = locFileItem.getString();
						}

					} else {
						filepath = "webapps/DL-TagsManufacturerAndDistributor/photo/";
						cantractpath = "webapps/DL-TagsManufacturerAndDistributor/DL-tagsSupplyChain";
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
						File tosave = new File(path, productid + ".jpg");
						proImage = tosave.getPath();
						locFileItem.write(tosave);

					}

				}
				System.out.println(proImage + "----" + productid + "----"
						+ mName + "----" + productName + "-------" + proImage
						+ "---------" + price);
				/*
				 * AddProduct product = new AddProduct(proImage, proid,
				 * productname, des, quanity, price, suplierid);
				 */
				FakeProductPojo fack = new FakeProductPojo(mName, productid,
						productName, price, proImage);
				boolean result = dao.fackeproduct(fack);
				if (result) {
					RequestDispatcher rd = request
							.getRequestDispatcher("dmenu.jsp");
					rd.forward(request, response);
				} else {
					RequestDispatcher rd = request
							.getRequestDispatcher("dmenu.jsp");
					rd.forward(request, response);
				}

				// request.setAttribute("msg", msg);
				RequestDispatcher rd = request
						.getRequestDispatcher("AddProductmanu.jsp");
				rd.forward(request, response);

			} catch (Exception e) {
				System.out.println("ok" + e);

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
