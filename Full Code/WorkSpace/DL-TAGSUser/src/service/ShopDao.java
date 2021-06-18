package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ShopDao {
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost/dltaguser", "root", "root");
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}

	public List<ShopPojoall> loadShopProducts() {
		ArrayList<ShopPojoall> al = new ArrayList<ShopPojoall>();
		try {
			Connection con = ShopDao.getConnection();
			String query = "select * from store";
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ShopPojoall bean = new ShopPojoall(rs.getString("distributor"),
						rs.getString("distributorPrice"),
						rs.getString("image"), rs.getString("manufacturer"), rs
								.getString("price"), rs.getString("productId"),
						rs.getString("productName"), rs.getString("status"), rs
								.getString("adate"), rs.getString("quanity"),
						rs.getString("qrcode"));
				al.add(bean);

			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return al;
	}

	public boolean updateStore(String productid, String quanity) {
		boolean status = false;
		try {
			Connection con = ShopDao.getConnection();
			String query = "update store set quanity=? where productId=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, quanity);
			ps.setString(2, productid);
			int i = ps.executeUpdate();
			if (i > 0) {
				status = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

}
