package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ShopPojo;
import service.UserDao;

import com.http.servlet.HttpsServlet;

public class ProductRequest extends HttpsServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String distributorPros[] = request.getParameterValues("pros");
		String wholesale = "";
		UserDao userDao = new UserDao();
		for (String string : distributorPros) {
			wholesale += string + ",";
		}
		System.out.println("======================>" + wholesale);
		String temp[] = wholesale.split(",");
		for (String string : temp) {
			String temps[] = string.split("#");
			ShopPojo shopPojo = new ShopPojo(temps[0], temps[1], temps[2],
					temps[3], temps[4], temps[5], temps[6], "pending",temps[7],temps[8],temps[9]);
			boolean result = userDao.saveStoreRequests(shopPojo);
		}
		// System.out.println("Requesting for Products..." + distributor);
		// UserDao userDao = new UserDao();
		// boolean result = userDao.requestForProducts(distributor);
		// String msg = "";
		// if (result) {
		// msg = "Product Request sent Successfully";
		// } else {
		// msg = "You are already requested for Product Information";
		// }
		request.setAttribute("msg",
				"Product Request sent Successfully to Distrtibutor");
		RequestDispatcher rd = request.getRequestDispatcher("admin_menu.jsp");
		rd.forward(request, response);

		out.close();
	}
}
