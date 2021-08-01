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

public class ManActions extends HttpsServlet {
	UserDao userDao = new UserDao();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession hs = request.getSession();
		String manufacturer = (String) hs.getAttribute("name");
		String type = request.getParameter("type");
		String pid = request.getParameter("pid");
		String date = request.getParameter("date");
		String quantity = request.getParameter("quantity");
		String msg = "";
		if (type.equalsIgnoreCase("approve")) {
			String status = userDao.approveDistributor(pid, date, quantity,
					manufacturer);
			System.out.println("=================" + status);
			if (status.equalsIgnoreCase("yes")) {
				msg = "Distrubutor request is accepted";
			} else {
				msg = status;
			}
		} else {
			boolean result = userDao.declineDistributor(pid, date);
			msg = "Distributor request declined";
		}
		request.setAttribute("msg", msg);
		RequestDispatcher rd = request.getRequestDispatcher("Disreq.jsp");
		rd.forward(request, response);
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.close();
	}

}
