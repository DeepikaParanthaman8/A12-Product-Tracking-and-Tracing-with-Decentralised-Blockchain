package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserDao;

import com.http.servlet.HttpsServlet;

public class Dispatch extends HttpsServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String email = request.getParameter("email");
		String date = request.getParameter("date");
		String pid = request.getParameter("pid");
		UserDao userDao = new UserDao();
		blockchain.UserDao dao = new blockchain.UserDao();
		boolean result = userDao.updateSavedProducts(email, date);
		String msg = "";
		if (result) {
			msg = "Product dispatched";
			dao.updateShipment(pid);
			userDao.updateStore(pid);

		} else {
			msg = "Failed to dispatch a product";
		}
		request.setAttribute("msg", msg);
		RequestDispatcher rd = request.getRequestDispatcher("admin_menu.jsp");
		rd.forward(request, response);

		out.close();
	}

}
