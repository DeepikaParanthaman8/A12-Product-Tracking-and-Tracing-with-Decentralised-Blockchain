package com.distributor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.UserDao;
import com.dis.modul.ManPojo;
import com.http.servlet.HttpsServlet;

public class ProductDetails extends HttpsServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String man = request.getParameter("man");
		String type = request.getParameter("type");
		System.out.println("Manufacturer================>" + man);
		UserDao userDao = new UserDao();
		List<ManPojo> list = userDao.loadinventory();
		if (type.equalsIgnoreCase("main")) {
			String pid = "";
			String pname = "";
			for (ManPojo manPojo : list) {
				if (manPojo.getManufacturerName().equalsIgnoreCase(man)) {
					pid += manPojo.getProductId() + ",";
					pname += manPojo.getProductName() + ",";
				}
			}
			String op = pid + "@" + pname;
			out.print(op);
		}
		out.close();
	}

}
