package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.UserDao;

import model.BuyPojo;
import model.ShopPojo;

import com.http.servlet.HttpsServlet;

public class Payment extends HttpsServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try {

			HttpSession session = request.getSession(true);
			String email = (String) session.getAttribute("email");
			String name = (String) session.getAttribute("name");
			String aid = request.getParameter("aid");
			String pname = request.getParameter("pname");
			String pprice = request.getParameter("pprice");
			String amount = request.getParameter("amount");
			String image = request.getParameter("image");
			String quantity = request.getParameter("quantity");
			String distributor = request.getParameter("d");
			Date d = new Date();
			Calendar calendar = Calendar.getInstance();
			String date = DateFormat.getDateInstance().format(d);
			System.out.println(date);
			Date date1 = calendar.getTime();
			DateFormat format1 = new SimpleDateFormat("HH:mm");
			String time = format1.format(date1);
			// ------------------------------------
			BuyPojo buyPojo = new BuyPojo(email, distributor, aid, pname,
					quantity, pprice, image, date + " " + time, "pending");
			ArrayList<BuyPojo> al = new ArrayList<BuyPojo>();
			al.add(buyPojo);

			UserDao dao = new UserDao();
			List<ShopPojo> list = dao.loadShopProducts();
			int toatlquanity =0;
			for (ShopPojo shopPojo : list) {
				if (shopPojo.getProductId().equals(aid)) {
					toatlquanity = Integer.parseInt(shopPojo.getQuanity())-Integer.parseInt(quantity);
				}
			}
			System.out.println("pppppppppppppppppppppppp----------p"+toatlquanity);
			
			

			session.setAttribute("buypojo", al);
			session.setAttribute("toatlquanity", toatlquanity);
			session.setAttribute("pid", aid);

			AccessBankService abs = new AccessBankService();
			String url = "";
			String sessionid = request.getSession().getId();
			url = abs.requestBank(email, amount);
			System.out.println("-------------------------->>>");
			url = url + "?sessionId=" + sessionid;
			response.sendRedirect(url);

			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
