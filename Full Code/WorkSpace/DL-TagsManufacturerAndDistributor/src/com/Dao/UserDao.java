package com.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.Service.MethodInterface;
import com.dis.modul.DisPojo;
import com.dis.modul.DistributorPojo;
import com.dis.modul.ManPojo;

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

	public String distributorLogin(String email, String password) {
		String status = "no";
		try {
			Connection con = UserDao.getConnection();
			String query = "select * from distributor where email=? and password=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				status = rs.getString("name") + "@" + rs.getString("did");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public boolean saveDistributor(DistributorPojo distributorPojo) {
		boolean status = false;
		try {
			Connection con = UserDao.getConnection();
			String query = "insert into distributor(name,email,password,mobile, did)values(?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, distributorPojo.getName());
			ps.setString(2, distributorPojo.getEmail());
			ps.setString(3, distributorPojo.getPassword());
			ps.setString(4, distributorPojo.getMobile());
			ps.setString(5, distributorPojo.getDistributroId());
			int i = ps.executeUpdate();
			if (i > 0) {
				status = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public List<ManPojo> loadinventory() {
		List<ManPojo> list = new ArrayList<ManPojo>();
		try {
			Connection con = UserDao.getConnection();
			String query = "select * from manu_product";
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ManPojo manPojo = new ManPojo(rs.getString("Productid"), rs
						.getString("Manufacturename"), rs
						.getString("Productname"), rs.getString("Price"), rs
						.getString("Imagepath"), rs.getString("Description"),
						rs.getString("numberofproduct"), rs
								.getString("assembledate"));
				list.add(manPojo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean sendDistributorRequests(DisPojo disPojo) {
		boolean status = false;
		try {
			Connection con = UserDao.getConnection();
			String query = "insert into distributor_requests(manufacturer,distributor,product_id,product_name,date,image,status,price,dprice,quantity,qrcode,adate)values(?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, disPojo.getManufacturer());
			ps.setString(2, disPojo.getDistributor());
			ps.setString(3, disPojo.getProductId());
			ps.setString(4, disPojo.getProductName());
			ps.setString(5, disPojo.getDateTime());
			ps.setString(6, disPojo.getImage());
			ps.setString(7, disPojo.getStatus());
			ps.setString(8, disPojo.getPrice());
			ps.setString(9, disPojo.getDistributorPrice());
			ps.setString(10, disPojo.getQuanity());
			ps.setString(11, disPojo.getQrcode());
			ps.setString(12, disPojo.getAssembledate());
			int i = ps.executeUpdate();
			if (i > 0) {
				status = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public List<DisPojo> loadDistributorRequests(String did) {
		ArrayList<DisPojo> list = new ArrayList<DisPojo>();
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

	public List<DisPojo> loadDistributorRequestsId(String manufacturer) {
		ArrayList<DisPojo> list = new ArrayList<DisPojo>();
		try {
			Connection con = UserDao.getConnection();
			String query = "select * from distributor_requests where manufacturer=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, manufacturer);
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

	public String approveDistributor(String pid, String date, String quantity,
			String manufacturer) {
		String result = "no";
		try {
			Connection con = UserDao.getConnection();
			String query2 = "update distributor_requests set status=? where product_id=? and date=?";
			PreparedStatement ps2 = con.prepareStatement(query2);
			ps2.setString(1, "Approved");
			ps2.setString(2, pid);
			ps2.setString(3, date);
			int k = ps2.executeUpdate();
			if (k > 0) {
				result = "yes";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public boolean declineDistributor(String pid, String date) {
		boolean result = false;
		try {
			Connection con = UserDao.getConnection();
			String query = "update distributor_requests set status=? where product_id=? and date=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, "Declined");
			ps.setString(2, pid);
			ps.setString(3, date);
			int status = ps.executeUpdate();
			if (status > 0) {
				result = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public boolean updateDistributorProducts(String distributor, String pid,
			String dprice) {
		boolean result = false;
		try {
			Connection con = UserDao.getConnection();
			String query = "update distributor_requests set dprice=? where product_id=? and distributor=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, dprice);
			ps.setString(2, pid);
			ps.setString(3, distributor);
			int i = ps.executeUpdate();
			if (i > 0) {
				result = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
