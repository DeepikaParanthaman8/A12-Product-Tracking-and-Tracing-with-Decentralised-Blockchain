package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.Dao;
import com.Model.SupplierRegPojo;
import com.http.servlet.HttpsServlet;

public class SupplierRegister extends HttpsServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Dao dao = new Dao();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Random rand = new Random();
		try {

			String name = request.getParameter("name");
			String producttype = request.getParameter("producttype");
			String email = request.getParameter("email");
			String mobile = request.getParameter("mobile");
			String address = request.getParameter("address");
			String pass = request.getParameter("password");

			String SId = "Supiller_" + rand.nextInt(99999);

			SupplierRegPojo supplier = new SupplierRegPojo(name, producttype,
					email, mobile, address, pass, SId);
			System.out.println(supplier);

			boolean result = dao.userRegister(supplier);
			if (result) {
				out.println("WELCOME");
				request.setAttribute("msg", "Register Successful");
				RequestDispatcher rd = request
						.getRequestDispatcher("login.jsp");
				rd.forward(request, response);

			} else {

				request.setAttribute("msg", "you're Already Registered  ");
				RequestDispatcher rd = request
						.getRequestDispatcher("signup.jsp");
				rd.forward(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
