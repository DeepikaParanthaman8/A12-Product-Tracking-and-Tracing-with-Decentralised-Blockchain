package com.distributor;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import QrCode.QRCode;

import com.Dao.UserDao;
import com.dis.modul.DisPojo;
import com.dis.modul.ManPojo;
import com.google.zxing.WriterException;
import com.http.servlet.HttpsServlet;

public class DistributorRequest extends HttpsServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			HttpSession session = request.getSession(false);
			String manufacturer = request.getParameter("man");
			String distributor = (String) session.getAttribute("did");
			String productId = request.getParameter("pid");
			String productName = request.getParameter("pname");
			String image = "";
			Date d = new Date();
			Calendar calendar = Calendar.getInstance();
			String date = DateFormat.getDateInstance().format(d);
			Date date1 = calendar.getTime();
			DateFormat format1 = new SimpleDateFormat("HH:mm");
			String time = format1.format(date1);
			String dateTime = date + " " + time;
			System.out.println(dateTime);
			UserDao userDao = new UserDao();
			List<ManPojo> list = userDao.loadinventory();
			String amount = "", quantity = null, adate = null;
			String dprice = "0";
			String ss = productId;
			String qrCodeText = ss;
			String filePath = "webapps/DL-TagsManufacturerAndDistributor/photo/"
					+ ss;
			int size = 250;
			String fileType = "png";

			File qrFile = new File(filePath);

			QRCode.createQRImage(qrFile, qrCodeText, size, fileType);

			for (ManPojo manPojo : list) {
				if (manPojo.getProductId().equalsIgnoreCase(productId)) {
					image = manPojo.getImagePath();
					amount = manPojo.getPrice();
					quantity = manPojo.getQuantity();
					adate = manPojo.getAssembledate();

				}
			}
			DisPojo disPojo = new DisPojo(manufacturer, distributor, productId,
					productName, dateTime, image, "pending", amount, dprice,
					quantity, filePath, adate);
			boolean result = userDao.sendDistributorRequests(disPojo);
			String msg = "";
			if (result) {
				msg = "Product request sent to the Manufacturer";
			} else {
				msg = "Failed to sent product request";
			}
			request.setAttribute("msg", msg);
			RequestDispatcher rd = request.getRequestDispatcher("dmenu.jsp");
			rd.forward(request, response);
			out.close();
		} catch (WriterException e) {
			e.printStackTrace();
		}

	}
}
