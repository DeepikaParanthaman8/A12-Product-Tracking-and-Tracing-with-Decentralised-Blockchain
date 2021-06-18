package com.distributor;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dis.modul.CustomerRequest;
import com.http.servlet.HttpsServlet;

public class DisActions extends HttpsServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession hs = request.getSession();
		String info = (String) hs.getAttribute("did");
		String type = request.getParameter("type");
		String pid = request.getParameter("pid");
		CustomerRequest customerRequest = new CustomerRequest();
		try {
			customerRequest.update(pid, info, type);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher("cus_requests.jsp");
		rd.forward(request, response);

	}

	

}
