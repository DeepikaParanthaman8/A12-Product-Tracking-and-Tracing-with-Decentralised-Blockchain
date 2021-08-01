package blockchain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements MethodInterface {
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/dltag",
					"root", "root");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	@Override
	public List<ProductsBean> getAllProducts() {
		ArrayList<ProductsBean> al = new ArrayList<ProductsBean>();
		try {
			Connection con = UserDao.getConnection();
			String query = "select * from distributorproducts";
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ProductsBean bean = new ProductsBean(rs.getString("brandname"),
						rs.getString("productname"), rs.getString("productid"),
						rs.getString("productprice"), rs
								.getString("productassembledserial"), rs
								.getString("distributorserial"), rs
								.getString("distributorproductprice"), rs
								.getString("distributorproductname"), rs
								.getString("imagename"));
				al.add(bean);

			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return al;
	}

	@Override
	public List<ProductsBean> getAllProducts(String aid) {
		ArrayList<ProductsBean> al = new ArrayList<ProductsBean>();
		try {
			Connection con = UserDao.getConnection();
			String query = "select * from distributorproducts where productassembledserial='"
					+ aid + "'";
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ProductsBean bean = new ProductsBean(rs.getString("brandname"),
						rs.getString("productname"), rs.getString("productid"),
						rs.getString("productprice"), rs
								.getString("productassembledserial"), rs
								.getString("distributorserial"), rs
								.getString("distributorproductprice"), rs
								.getString("distributorproductname"), rs
								.getString("imagename"));
				al.add(bean);

			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return al;
	}

	@Override
	public boolean requestForProducts(String email) {
		boolean status = false;
		try {
			Connection con = UserDao.getConnection();
			String query = "select * from product_requests where email=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				status = false;
			} else {
				String query1 = "insert into product_requests(email,status)values(?,?)";
				PreparedStatement ps1 = con.prepareStatement(query1);
				ps1.setString(1, email);
				ps1.setString(2, "requested");
				int i = ps1.executeUpdate();
				if (i > 0) {
					status = true;
				}
			}
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public String getDistributorsList() {
		String result = "";
		try {
			Connection con = UserDao.getConnection();
			String query = "select * from distributor";
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			String dname = "";
			String demail = "";
			String did = "";
			while (rs.next()) {
				demail += rs.getString("email") + ",";
				dname += rs.getString("name") + ",";
				did += rs.getString("did") + ",";
			}
			result = demail + "#" + dname + "#" + did;
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<DisPojo> loadDistributorsData(String did) {
		List<DisPojo> list = new ArrayList<DisPojo>();
		try {
			Connection con = UserDao.getConnection();
			String query = "select * from distributor_requests where distributor=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, did);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				DisPojo disPojo = new DisPojo(rs.getString("manufacturer"), rs
						.getString("distributor"), rs.getString("product_id"),
						rs.getString("product_name"), rs.getString("date"), rs
								.getString("image"), rs.getString("status"), rs
								.getString("price"), rs.getString("dprice"), rs
								.getString("quantity"), rs.getString("qrcode"),
						rs.getString("adate"));
				list.add(disPojo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean updateShipment(String id) {
		boolean status = false;
		try {
			Connection con = UserDao.getConnection();
			String query = "update shipment set Customer=? where Productid=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, "1");
			ps.setString(2, id);
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
