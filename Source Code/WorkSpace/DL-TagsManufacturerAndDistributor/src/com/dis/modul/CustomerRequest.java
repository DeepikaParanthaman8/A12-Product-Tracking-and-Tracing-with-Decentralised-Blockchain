package com.dis.modul;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRequest {

	public List<ShopPojo> getRequest(String id) {
		List<ShopPojo> list = new ArrayList<ShopPojo>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(
					"jdbc:mysql://localhost/dltaguser", "root", "root");
			System.out.println("-------connection opened successfully------");

			String query = "select * from store where distributor='" + id
					+ "' AND " + "status='pending'";
			System.out.println(query);
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ShopPojo pojo = new ShopPojo(rs.getString("manufacturer"), rs
						.getString("distributor"), rs.getString("productId"),
						rs.getString("productName"), rs.getString("image"), rs
								.getString("price"), rs
								.getString("distributorPrice"), rs
								.getString("status"), rs.getString("adate"), rs
								.getString("qrcode"), rs.getString("quanity"));
				list.add(pojo);

			}
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public String update(String pid, String disid, String info)
			throws SQLException {
		String result = "";
		// "Approved"
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost/dltaguser", "root", "root");

			String query2 = "update store set status=? where productId=? and distributor=?";

			System.out.println(query2);

			System.out.println(pid + "****" + disid + "****" + info);

			PreparedStatement ps2 = connection.prepareStatement(query2);
			ps2.setString(1, info);
			ps2.setString(2, pid);
			ps2.setString(3, disid);

			System.out.println(ps2.toString());

			int k = ps2.executeUpdate();

			System.out.println(k);

			if (k > 0) {
				result = "yes";
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}

		return result;

	}

}
