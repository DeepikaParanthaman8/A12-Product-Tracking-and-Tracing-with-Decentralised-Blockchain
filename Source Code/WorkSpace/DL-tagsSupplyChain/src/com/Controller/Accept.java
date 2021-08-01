package com.Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.http.servlet.HttpsServlet;

public class Accept extends HttpsServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String supid = request.getParameter("accept");

		System.out.println("SupId---->" + supid);

		try {
			Connection connection = (Connection) getServletContext()
					.getAttribute("connection");

			System.out.println("connection success");
			String a = "Accept";

			Statement st = connection.createStatement();
			int i = st.executeUpdate("update requestquanity set status='" + a
					+ "'where s_no='" + supid + "'");

			ResultSet rs;
			rs = st.executeQuery("select * from requestquanity where s_no='"
					+ supid + "'");
			if (rs.next()) {
				// manufac_inven
				String req_quan = rs.getString("quanity");
				String manufacName = rs.getString("manufacture_name");
				String sup_id = rs.getString("supilerid");
				String pro_id = rs.getString("product_id");
				String productname = rs.getString("pname");

				System.out.println(req_quan + "****" + manufacName + "***"
						+ sup_id + "***" + pro_id);

				ResultSet rs1;
				rs1 = st
						.executeQuery("select * from manufac_inven where supilerid='"
								+ sup_id + "' AND product_id='" + pro_id + "'");
				if (rs1.next()) {
					// update
					String sel_quan = rs1.getString("quanity");
					sel_quan = String.valueOf(Integer.parseInt(sel_quan)
							+ Integer.parseInt(req_quan));
					int j = st
							.executeUpdate("update manufac_inven set quanity='"
									+ sel_quan + "'" + "where supilerid='"
									+ sup_id + "' AND product_id='" + pro_id
									+ "'");
				} else {
					String query = "insert into manufac_inven(manufacture_name,supilerid,product_id,quanity,pname) values(?,?,?,?,?)";

					PreparedStatement ps = connection.prepareStatement(query);

					ps.setString(1, manufacName);
					ps.setString(2, sup_id);
					ps.setString(3, pro_id);
					ps.setString(4, req_quan);
					ps.setString(5, productname);

					int k = ps.executeUpdate();
				}

			}

			RequestDispatcher rd = request
					.getRequestDispatcher("manufactureRequest.jsp");
			rd.include(request, response);
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

}
