package com.distributor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.UserDao;
import com.dis.modul.DistributorPojo;
import com.http.servlet.HttpsServlet;

public class Register extends HttpsServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String mobile = request.getParameter("mobile");
		Random random = new Random();
		String distributorId = "DSBTR"
				+ String.format("%04d", random.nextInt(10000));
		DistributorPojo distributorPojo = new DistributorPojo(name, email,
				password, mobile, distributorId);
		UserDao userDao = new UserDao();
		boolean result = userDao.saveDistributor(distributorPojo);
		if (result) {
			request.setAttribute("msg", "Registered successfully");
			RequestDispatcher rd = request
					.getRequestDispatcher("Dregister.jsp");
			rd.forward(request, response);

		} else {
			request.setAttribute("msg", "Failed to register");
			RequestDispatcher rd = request.getRequestDispatcher("Dgister.jsp");
			rd.forward(request, response);
		}

		out.close();
	}

}
