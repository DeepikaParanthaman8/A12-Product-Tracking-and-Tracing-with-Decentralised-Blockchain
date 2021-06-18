package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.Dao;
import com.Model.ManufactureInven;
import com.Model.RequestQuanity;
import com.http.servlet.HttpsServlet;

public class AcceptAndDecline extends HttpsServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ---------------------Decline Method--------------------//
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		try {
			Dao doa = new Dao();
			String Status = request.getParameter("accept");
			System.out.println("Status88888888" + Status);
			// -------------requestquanity----------------//
			String supplierid = "";
			String productid = "";
			String rquanity = "";
			// ----------------------manufac_inven---------------//
			String quanity = "";
			List<RequestQuanity> list = doa.getRequestQuanityDetails(Status);
			for (RequestQuanity requestQuanity : list) {
				supplierid = requestQuanity.getSupplierid();
				productid = requestQuanity.getProductid();
				rquanity = requestQuanity.getQyanity();
			}
			System.out.println("-------------->>" + Status);
			System.out.println(supplierid + "-------------" + productid
					+ "-------" + rquanity);
			List<ManufactureInven> result1 = doa.getManifactureDetails(
					supplierid, productid);
			for (ManufactureInven manufactureInven : result1) {
				quanity = manufactureInven.getQuanity();
			}
			System.out.println("==============>" + quanity);

			quanity = String.valueOf(Integer.parseInt(quanity)
					+ Integer.parseInt(rquanity));
			System.out.println(quanity);
			boolean result = doa.acceptedSupplier(Status);

			// if (result) {
			// boolean resultA = doa.DeclineSupplierQuanity(quanity,
			// supplierid, productid);
			// if (resultA) {
			// ManufactureInven Manufacture = new ManufactureInven();
			//
			// boolean vslueset = doa
			// .insertManifacture_inventry(Manufacture);
			//
			// RequestDispatcher rd = request
			// .getRequestDispatcher("manufactureRequest.jsp");
			// rd.include(request, response);
			//
			// }
			// System.out.println("oooooooooooooo");
			// }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ---------------------Decline Method--------------------//
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			Dao doa = new Dao();
			String status = request.getParameter("decline");

			boolean result = doa.DeclineSupplier(status);
			if (result) {
				RequestDispatcher rd = request
						.getRequestDispatcher("manufactureRequest.jsp");
				rd.include(request, response);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
