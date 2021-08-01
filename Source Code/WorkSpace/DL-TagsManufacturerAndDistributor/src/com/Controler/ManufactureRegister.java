package com.Controler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.Dao;
import com.Modul.M_RegisterPojo;
import com.http.servlet.HttpsServlet;

public class ManufactureRegister extends HttpsServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Dao dao = new Dao();

		try {
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			String pass = request.getParameter("pass");
			System.out.println();

			M_RegisterPojo mRegisterPojo = new M_RegisterPojo(name, email,
					phone, pass);
			boolean result = dao.userRegister(mRegisterPojo);
			if (result) {
				System.out.println("-----------------");
				request.setAttribute("msg", "Register Ruccessfull");
				RequestDispatcher rd = request
						.getRequestDispatcher("Register.jsp");
				rd.forward(request, response);
			} else {
				System.out.println("--------------ppppppppppp--------");
				request.setAttribute("msg", "You Are Already Registered");
				RequestDispatcher rd = request
						.getRequestDispatcher("Register.jsp");
				rd.forward(request, response);

			}

		} catch (Exception e) {

		}
	}

}
