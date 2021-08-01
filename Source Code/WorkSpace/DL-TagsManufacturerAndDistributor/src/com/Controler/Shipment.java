package com.Controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.http.servlet.HttpsServlet;

public class Shipment extends HttpsServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try {
			String from = request.getParameter("from");
			String pro_id = request.getParameter("proid");

			Connection connection = (Connection) getServletContext()
					.getAttribute("connection");
			if (from.equals("Manufacture")) {

				Statement st = connection.createStatement();
				int i = st.executeUpdate("update shipment set " + from + "='"
						+ 1 + "'where Productid='" + pro_id + "'");

				RequestDispatcher rd = request
						.getRequestDispatcher("shipment.jsp");
				rd.include(request, response);
			} else {
				Statement st = connection.createStatement();
				int i = st.executeUpdate("update shipment set " + from + "='"
						+ 1 + "'where Productid='" + pro_id + "'");

				RequestDispatcher rd = request
						.getRequestDispatcher("dshipment.jsp");
				rd.include(request, response);

			}
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}
