package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.http.servlet.HttpsServlet;

public class Admin extends HttpsServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		if (email.equalsIgnoreCase("admin@gmail.com")
				&& password.equalsIgnoreCase("admin")) {
			RequestDispatcher rd = request.getRequestDispatcher("admin_menu.jsp");
			rd.forward(request, response);

		} else {
			request.setAttribute("msg", "Invalid email or password");
			RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
			rd.forward(request, response);

		}
		out.close();
	}

}
