package com.Controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.Dao;
import com.Modul.RequestQuanityPojo;
import com.http.servlet.HttpsServlet;

public class ManufactureRequest extends HttpsServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Dao dao = new Dao();
		try {
			String manufacturename = request.getParameter("name");
			String supid = request.getParameter("supid");
			String productid = request.getParameter("proid");
			String quanity = request.getParameter("quanity");
			String pname = request.getParameter("pname");
			String status = "pending";

			RequestQuanityPojo request1 = new RequestQuanityPojo();
			request1.setProductname(pname);
			request1.setManifactureName(manufacturename);
			request1.setSupplierid(supid);
			request1.setProductid(productid);
			request1.setQuantity(quanity);
			request1.setStatus(status);

			boolean result = dao.quantityRequest(request1);

			if (result) {
				boolean res = dao.quantityRequestupdate(quanity, productid);

				RequestDispatcher rd = request
						.getRequestDispatcher("SupplierProduct.jsp");
				rd.forward(request, response);

			}

		} catch (Exception e) {
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			HttpSession httpSession = request.getSession();
			String name = (String) httpSession.getAttribute("name");

			Connection connection = (Connection) getServletContext()
					.getAttribute("connection");

			Statement st = connection.createStatement();
			ResultSet rs1;
			rs1 = st
					.executeQuery("select * from manu_product where Manufacturename='"
							+ name + "'");
			List<ManufacturePro> pros = new ArrayList<ManufacturePro>();
			while (rs1.next()) {
				ManufacturePro pro = new ManufacturePro();
				pro.setName(rs1.getString("Manufacturename"));
				pro.setProid(rs1.getString("Productid"));
				pro.setPrice(rs1.getString("Price"));
				pro.setPackect(rs1.getString("packets"));
				pro.setPackdate(rs1.getString("sdate"));
				pro.setImage(rs1.getString("Imagepath"));
				pro.setDesci(rs1.getString("Description"));
				pro.setProname(rs1.getString("Productname"));

				pros.add(pro);
			}

			request.setAttribute("product", pros);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("manu_purchased.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}
