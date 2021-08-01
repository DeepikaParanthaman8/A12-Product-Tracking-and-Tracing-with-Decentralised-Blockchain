package com.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.Model.AddProduct;
import com.Model.ManufactureInven;
import com.Model.RequestQuanity;
import com.Model.SupplierRegPojo;
import com.Service.ServiceCall;
import com.Service.sample;

public class Dao implements ServiceCall, sample {
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

	public boolean userRegister(SupplierRegPojo supplierRegPojo) {
		boolean status = false;
		try {
			Connection con = Dao.getConnection();
			List<SupplierRegPojo> emplypojo = getUserDetails();
			String dbEmail = "";
			for (SupplierRegPojo supplierRegPojo2 : emplypojo) {
				dbEmail = supplierRegPojo2.getEmail();
				System.out.println(dbEmail);
			}
			if (supplierRegPojo.getEmail().equalsIgnoreCase(dbEmail)) {
				status = false;
			} else {
				String query = "insert into suppilerreg(name,producttype,email,phone,address,pass,sup_id)values(?,?,?,?,?,?,?)";
				PreparedStatement pr = con.prepareStatement(query);
				pr.setString(1, supplierRegPojo.getName());
				pr.setString(2, supplierRegPojo.getProtype());
				pr.setString(3, supplierRegPojo.getEmail());
				pr.setString(4, supplierRegPojo.getPhone());
				pr.setString(5, supplierRegPojo.getAddress());
				pr.setString(6, supplierRegPojo.getPass());
				pr.setString(7, supplierRegPojo.getSupplier_id());
				int i = pr.executeUpdate();
				if (i >= 0) {
					status = true;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public List<SupplierRegPojo> getUserDetails() {
		List<SupplierRegPojo> list = new ArrayList<SupplierRegPojo>();
		try {
			String query = "Select * from suppilerreg";
			Connection con = Dao.getConnection();
			PreparedStatement pr = con.prepareStatement(query);
			// System.out.println(query);
			ResultSet rs = pr.executeQuery();
			while (rs.next()) {
				SupplierRegPojo emplypojo = new SupplierRegPojo(rs
						.getString("name"), rs.getString("producttype"), rs
						.getString("email"), rs.getString("phone"), rs
						.getString("address"), rs.getString("pass"), rs
						.getString("sup_id"));

				list.add(emplypojo);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public String getLogin(String email, String Pass) {
		String result = "no";
		try {
			Connection con = Dao.getConnection();
			String query = "Select * from suppilerreg where email=? and pass=?";
			PreparedStatement pr = con.prepareStatement(query);
			pr.setString(1, email);
			pr.setString(2, Pass);
			ResultSet rd = pr.executeQuery();
			if (rd.next()) {
				result = rd.getString("sup_id");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public boolean setAddproduct(AddProduct addProduct) {
		boolean status = false;
		try {
			List<AddProduct> list = getAllProduct();
			String productId = "";
			for (AddProduct addProduct1 : list) {
				productId = addProduct1.getProid();
				System.out.println(productId);
			}
			if (addProduct.getProid().equals(productId)) {
				status = false;
			} else {
				Connection con = Dao.getConnection();
				String query = "insert into addproduct(image,suplier_id,productid,name,deseription,price,quanit)values(?,?,?,?,?,?,?)";
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1, addProduct.getImage());
				ps.setString(2, addProduct.getSuplierid());
				ps.setString(3, addProduct.getProid());
				ps.setString(4, addProduct.getProductname());
				ps.setString(5, addProduct.getDescription());
				ps.setString(6, addProduct.getPrice());
				ps.setString(7, addProduct.getQuanity());

				int i = ps.executeUpdate();
				if (i > 0) {
					status = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public List<SupplierRegPojo> getSupplierDetails(String supId) {
		List<SupplierRegPojo> list1 = new ArrayList<SupplierRegPojo>();
		try {
			String query = "Select * from suppilerreg where sup_id=?";
			Connection con = Dao.getConnection();
			PreparedStatement pr = con.prepareStatement(query);
			pr.setString(1, supId);
			// System.out.println(query);
			ResultSet rs = pr.executeQuery();
			while (rs.next()) {
				SupplierRegPojo emplypojo = new SupplierRegPojo(rs
						.getString("name"), rs.getString("producttype"), rs
						.getString("email"), rs.getString("phone"), rs
						.getString("address"), rs.getString("pass"), rs
						.getString("sup_id"));

				list1.add(emplypojo);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list1;
	}

	public List<AddProduct> getAllProduct() {
		List<AddProduct> list = new ArrayList<AddProduct>();
		try {
			String query = "Select * from addproduct";
			Connection con = Dao.getConnection();
			PreparedStatement pr = con.prepareStatement(query);
			ResultSet rs = pr.executeQuery();
			while (rs.next()) {
				AddProduct emplypojo = new AddProduct(rs.getString("image"), rs
						.getString("productid"), rs.getString("name"), rs
						.getString("deseription"), rs.getString("quanit"), rs
						.getString("price"), rs.getString("suplier_id"));

				list.add(emplypojo);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<RequestQuanity> getProductDetails(String supId) {
		List<RequestQuanity> list = new ArrayList<RequestQuanity>();

		try {
			String query = "select * from requestquanity where supilerid=? and status='pending'";
			Connection con = Dao.getConnection();
			PreparedStatement pr = con.prepareStatement(query);
			pr.setString(1, supId);
			ResultSet rs = pr.executeQuery();
			while (rs.next()) {
				RequestQuanity emplypojo = new RequestQuanity(rs
						.getString("s_no"), rs.getString("manufacture_name"),
						rs.getString("supilerid"), rs.getString("product_id"),
						rs.getString("quanity"), rs.getString("status"), rs
								.getString("reqdate"), rs.getString("pname"));

				list.add(emplypojo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean acceptedSupplier(String supid) {
		boolean status = false;
		try {
			Connection con = Dao.getConnection();
			String query = "update requestquanity set status=? where s_no=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, "Accept");
			ps.setString(2, supid);
			int i = ps.executeUpdate();
			if (i > 0) {
				status = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public boolean DeclineSupplier(String sno) {
		boolean status = false;
		try {
			Connection con = Dao.getConnection();
			String query = "update requestquanity set status=? where s_no=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, "Cancel");
			ps.setString(2, sno);

			int i = ps.executeUpdate();
			if (i > 0) {
				status = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public List<ManufactureInven> getManifactureDetails(String supId,
			String productId) {
		List<ManufactureInven> list = new ArrayList<ManufactureInven>();
		try {
			String query = "select * from manufac_inven where supilerid=? and product_id=?";
			Connection con = Dao.getConnection();
			PreparedStatement pr = con.prepareStatement(query);
			pr.setString(1, supId);
			pr.setString(2, productId);
			ResultSet rs = pr.executeQuery();
			while (rs.next()) {
				ManufactureInven emplypojo = new ManufactureInven();

				emplypojo.setSno(rs.getString("s_no"));
				emplypojo.setManufacturename(rs.getString("manufacture_name"));
				emplypojo.setSupplierid(rs.getString("supilerid"));
				emplypojo.setProductid(rs.getString("product_id"));
				emplypojo.setQuanity(rs.getString("quanity"));
				list.add(emplypojo);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<RequestQuanity> getRequestQuanityDetails(String sNo) {
		List<RequestQuanity> list = new ArrayList<RequestQuanity>();

		try {
			String query = "select * from requestquanity where s_no=?";
			Connection con = Dao.getConnection();
			PreparedStatement pr = con.prepareStatement(query);
			pr.setString(1, sNo);
			ResultSet rs = pr.executeQuery();
			while (rs.next()) {
				RequestQuanity emplypojo = new RequestQuanity(rs
						.getString("s_no"), rs.getString("manufacture_name"),
						rs.getString("supilerid"), rs.getString("product_id"),
						rs.getString("quanity"), rs.getString("status"), rs
								.getString("reqdate"), rs.getString("pname"));

				list.add(emplypojo);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean insertManifacture_inventry(ManufactureInven manufactureInven) {
		boolean status = false;
		try {
			Connection con = Dao.getConnection();
			String query = "insert into manufac_inven(manufacture_name,supilerid,product_id,quanity) values(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, manufactureInven.getManufacturename());
			ps.setString(2, manufactureInven.getSupplierid());
			ps.setString(3, manufactureInven.getProductid());
			ps.setString(4, manufactureInven.getQuanity());

			int i = ps.executeUpdate();
			if (i > 0) {
				status = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public boolean DeclineSupplierQuanity(String quanity, String supplierid,
			String productId) {
		boolean status = false;
		try {
			Connection con = Dao.getConnection();
			String query = "update manufac_inven set quanity=? where supilerid=? AND product_id=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, quanity);
			ps.setString(2, supplierid);
			ps.setString(3, productId);

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
