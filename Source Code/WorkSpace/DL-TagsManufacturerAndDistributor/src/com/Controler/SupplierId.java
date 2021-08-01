package com.Controler;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.Dao;
import com.Modul.AddProduct;
import com.http.servlet.HttpsServlet;

public class SupplierId extends HttpsServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Dao dao = new Dao();
		response.setContentType("text/html");
		HttpSession session = request.getSession();

		try {
			String id = request.getParameter("supid");
			System.out.println("id------------>>" + id);
			List<AddProduct> result = dao.getProductDetails(id);
			if (result != null) {
				session.setAttribute("uname", id);
				System.out.println("00000000000000000000");
				RequestDispatcher rd = request
						.getRequestDispatcher("SupplierProduct.jsp");
				rd.forward(request, response);
			} else {
				System.out.println("sorry---------------------");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
