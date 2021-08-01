package com.Controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.Dao.Dao;
import com.Model.AddProduct;
import com.http.servlet.HttpsServlet;

public class SupplierAddProduct extends HttpsServlet {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Dao dao = new Dao();
			String productname = null, proid = null, des = null, price = null, quanity = null, producttype = null, suplierid = null;
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

						if (locFileItem.getFieldName().equals("proid")) {
							proid = locFileItem.getString();
						}

						if (locFileItem.getFieldName().equals("des")) {
							des = locFileItem.getString();
						}

						if (locFileItem.getFieldName().equals("price")) {
							price = locFileItem.getString();
						}

						if (locFileItem.getFieldName().equals("quanity")) {
							quanity = locFileItem.getString();
						}
						if (locFileItem.getFieldName().equals("productname")) {
							productname = locFileItem.getString();
						}
						if (locFileItem.getFieldName().equals("suplierid")) {
							suplierid = locFileItem.getString();
						}

					} else {
						filepath = "webapps/DL-tagsSupplyChain/photo/";
						cantractpath = "webapps/DL-tagsSupplyChain/DL-tagsSupplyChain";
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
				System.out.println(proImage + "----" + proid + "----"
						+ productname + "----" + des + "-------" + quanity
						+ "---------" + price + "==" + suplierid);
				AddProduct product = new AddProduct(proImage, proid,
						productname, des, quanity, price, suplierid);
				boolean result = dao.setAddproduct(product);
				String msg = "";
				if (result) {
					msg = "Product Add ";
				} else {
					msg = "Product Id Allready Register";
				}
				request.setAttribute("msg", msg);
				RequestDispatcher rd = request
						.getRequestDispatcher("AddProductmanu.jsp");
				rd.forward(request, response);

			} catch (Exception e) {
				System.out.println("ok");

			}

		} catch (Exception e) {
			System.out.println("okkk");

		}
	}
}