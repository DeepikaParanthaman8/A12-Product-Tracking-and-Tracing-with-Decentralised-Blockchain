package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserPojo;
import service.UserDao;

import com.http.servlet.HttpsServlet;

public class Register extends HttpsServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String mobile = request.getParameter("mobile");
		String address = request.getParameter("address");
		UserDao userDao = new UserDao();
		UserPojo userPojo = new UserPojo(name, email, password, mobile, address);
		boolean result = userDao.saveUser(userPojo);
		String msg = "";
		if (result) {
			msg = "Registered Successfully";
		} else {
			msg = "Email already exsits";
		}
		request.setAttribute("msg", msg);
		RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
		rd.forward(request, response);
		out.close();
	}
}
