package com.Controler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.Dao;
import com.http.servlet.HttpsServlet;

public class ManifactureLogin extends HttpsServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		Dao dao = new Dao();
		try {
			String email = request.getParameter("email");
			String pass = request.getParameter("pass");
			System.out.println(email + "&&" + pass);

			String result = dao.M_Login(email, pass);

			String msg = "Invalied Email Or Password";

			if (!result.equalsIgnoreCase("no")) {

				System.out.println("ok");
				// hs.setAttribute("supid", result);
				// hs.setAttribute("result", result);
				session.setAttribute("name", result);
				RequestDispatcher requestDispatcher = request
						.getRequestDispatcher("Manu.jsp");
				requestDispatcher.forward(request, response);

			} else {
				System.out.println("no");
				request.setAttribute("msg", msg);
				RequestDispatcher requestDispatcher = request
						.getRequestDispatcher("Register.jsp");
				requestDispatcher.include(request, response);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
