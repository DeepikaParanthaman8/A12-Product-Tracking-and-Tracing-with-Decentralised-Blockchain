package com.distributor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.UserDao;
import com.http.servlet.HttpsServlet;

public class Login extends HttpsServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String email = request.getParameter("email");
		String password = request.getParameter("pass");
		UserDao userDao = new UserDao();
		String name = userDao.distributorLogin(email, password);
		if (!name.equals("no")) {
			String temp[] = name.split("@");
			HttpSession session = request.getSession(true);
			session.setAttribute("name", temp[0]);
			session.setAttribute("did", temp[1]);
			session.setAttribute("email", email);
			RequestDispatcher rd = request.getRequestDispatcher("dmenu.jsp");
			rd.forward(request, response);
		} else {
			request.setAttribute("msg", "Invalied Email Are Password");
			RequestDispatcher rd = request
					.getRequestDispatcher("Dregister.jsp");
			rd.include(request, response);

		}
	}
}
