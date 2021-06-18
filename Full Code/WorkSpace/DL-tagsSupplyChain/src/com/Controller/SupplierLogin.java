package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.Dao;
import com.http.servlet.HttpsServlet;

public class SupplierLogin extends HttpsServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession hs = request.getSession();

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Dao dao = new Dao();
		try {
			String email = request.getParameter("email");
			String pass = request.getParameter("pass");
			System.out.println(email + "&&" + pass);
			String result = dao.getLogin(email, pass);

			if (!result.equalsIgnoreCase("no")) {
				String msg = "Welcome";
				hs.setAttribute("supid", result);
				request.setAttribute("msg", msg);
				System.out.println("ok" + "------------?>>" + result);
				RequestDispatcher requestDispatcher = request
						.getRequestDispatcher("AddProductmanu.jsp");
				requestDispatcher.forward(request, response);

			} else {
				String msg = "Invalied Email Or Password";
				System.out.println("no");
				request.setAttribute("msg", msg);
				RequestDispatcher requestDispatcher = request
						.getRequestDispatcher("login.jsp");
				requestDispatcher.include(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
