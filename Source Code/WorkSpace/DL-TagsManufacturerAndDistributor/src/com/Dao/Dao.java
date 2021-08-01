package com.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.Modul.AddProduct;
import com.Modul.ContractModel;
import com.Modul.M_RegisterPojo;
import com.Modul.ManifactureMakingProductPojo;
import com.Modul.ManufactureInven;
import com.Modul.RequestQuanityPojo;
import com.Modul.SupplierRegPojo;
import com.Service.ManServiceCall;
import com.dis.modul.FakeProductPojo;

public class Dao implements ManServiceCall {
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

	public List<M_RegisterPojo> getUserDetails() {
		List<M_RegisterPojo> list = new ArrayList<M_RegisterPojo>();
		try {
			String query = "select * from manufacture";
			Connection con = Dao.getConnection();
			PreparedStatement pr = con.prepareStatement(query);
			ResultSet rs = pr.executeQuery();
			while (rs.next()) {
				M_RegisterPojo emplypojo = new M_RegisterPojo(rs
						.getString("name"), rs.getString("email"), rs
						.getString("mobile"), rs.getString("pass"));

				list.add(emplypojo);
				System.out.println("--------->" + list);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean userRegister(M_RegisterPojo mRegisterPojo) {
		boolean status = false;
		try {
			Connection con = Dao.getConnection();
			List<M_RegisterPojo> emplypojo = getUserDetails();
			String dbEmail = "";
			for (M_RegisterPojo mRegisterPojo2 : emplypojo) {
				dbEmail = mRegisterPojo2.getEmail();
				System.out.println(dbEmail);
			}
			if (mRegisterPojo.getEmail().equalsIgnoreCase(dbEmail)) {
				status = false;
			} else {
				String query = "insert into manufacture(name,email,pass,mobile) values(?,?,?,?)";
				PreparedStatement pr = con.prepareStatement(query);
				pr.setString(1, mRegisterPojo.getName());
				pr.setString(2, mRegisterPojo.getEmail());
				pr.setString(3, mRegisterPojo.getPassword());
				pr.setString(4, mRegisterPojo.getPhone());

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

	public String M_Login(String email, String Pass) {
		String result = "no";
		try {
			Connection con = Dao.getConnection();
			String query = "Select * from manufacture where email=? and pass=?";
			PreparedStatement pr = con.prepareStatement(query);
			pr.setString(1, email);
			pr.setString(2, Pass);
			ResultSet rd = pr.executeQuery();
			if (rd.next()) {
				result = rd.getString("name");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public List<AddProduct> getSubid(String supid) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<SupplierRegPojo> getSupplierDetails() {
		List<SupplierRegPojo> list = new ArrayList<SupplierRegPojo>();
		try {
			String query = "select * from suppilerreg";
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
				System.out.println("--------->" + list);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<AddProduct> getProductDetails(String supid) {
		List<AddProduct> list = new ArrayList<AddProduct>();
		try {
			Connection con = Dao.getConnection();
			String query = "select * from addproduct where suplier_id=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, supid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				AddProduct disPojo = new AddProduct(rs.getString("image"), rs
						.getString("suplier_id"), rs.getString("productid"), rs
						.getString("name"), rs.getString("deseription"), rs
						.getString("quanit"), rs.getString("price"));
				list.add(disPojo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean quantityRequest(RequestQuanityPojo requestQuanityPojo) {
		boolean status = false;
		try {
			Connection con = Dao.getConnection();
			String query = "insert into requestquanity(pname,manufacture_name,supilerid,product_id,quanity,status) values(?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, requestQuanityPojo.getProductname());
			ps.setString(2, requestQuanityPojo.getManifactureName());
			ps.setString(3, requestQuanityPojo.getSupplierid());
			ps.setString(4, requestQuanityPojo.getProductid());
			ps.setString(5, requestQuanityPojo.getQuantity());
			ps.setString(6, requestQuanityPojo.getStatus());

			int i = ps.executeUpdate();
			if (i > 0) {
				status = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public boolean quantityRequestupdate(String quanity, String productId) {
		boolean status = false;
		try {
			Connection con = Dao.getConnection();
			String query1 = "update addproduct set quanit=quanit-? where productid=?";
			PreparedStatement ps1 = con.prepareStatement(query1);
			ps1.setString(1, quanity);
			ps1.setString(2, productId);
			int i = ps1.executeUpdate();
			if (i > 0) {
				status = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public List<ManufactureInven> getManifactureDetils(String name) {

		List<ManufactureInven> list = new ArrayList<ManufactureInven>();
		try {
			Connection con = Dao.getConnection();
			String query = "select * from manufac_inven  where manufacture_name=?";
			PreparedStatement pr = con.prepareStatement(query);
			pr.setString(1, name);
			ResultSet rs = pr.executeQuery();
			while (rs.next()) {
				ManufactureInven emplypojo = new ManufactureInven();
				emplypojo.setManufacturename(rs.getString("manufacture_name"));
				emplypojo.setProductid(rs.getString("product_id"));
				emplypojo.setQuanity(rs.getString("quanity"));
				emplypojo.setSupplierid(rs.getString("supilerid"));
				emplypojo.setProductname(rs.getString("pname"));
				list.add(emplypojo);
				System.out.println("--------->" + list);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<ManifactureMakingProductPojo> getMakingProduct(
			String manifactureName) {
		List<ManifactureMakingProductPojo> list = new ArrayList<ManifactureMakingProductPojo>();
		try {
			Connection con = Dao.getConnection();
			String query = "select * from manu_product where Manufacturename=?";
			PreparedStatement pr = con.prepareStatement(query);
			pr.setString(1, manifactureName);
			ResultSet rs = pr.executeQuery();
			while (rs.next()) {
				ManifactureMakingProductPojo makingpro = new ManifactureMakingProductPojo();
				makingpro.setProductName(rs.getString("Productname"));
				makingpro.setId(rs.getString("Id"));
				makingpro.setPrice(rs.getString("Price"));
				makingpro.setProductid(rs.getString("Productid"));
				makingpro.setImagepath(rs.getString("Imagepath"));
				makingpro.setDesacription(rs.getString("Description"));
				makingpro.setManifactureName("Manufacturename");

				list.add(makingpro);
				System.out.println("--------->" + list);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<ContractModel> getDetails() {
		List<ContractModel> list = new ArrayList<ContractModel>();

		try {
			Connection con = Dao.getConnection();
			String query = "select * from manu_product where Manufacturename=?";
			PreparedStatement pr = con.prepareStatement(query);
			// pr.setString(1, manifactureName);
			ResultSet rs = pr.executeQuery();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return list;
	}

	public boolean fackeproduct(FakeProductPojo fakeProduct) {
		boolean status = false;
		try {
			Connection con = Dao.getConnection();
			List<FakeProductPojo> emplypojo = getfakeproductDetails();
			String proid = "";
			for (FakeProductPojo fake : emplypojo) {
				proid = fake.getProductid();
				System.out.println(proid);
			}
			if (fakeProduct.getProductid().equalsIgnoreCase(proid)) {
				status = false;
			} else {
				String query = "insert into fakeproduct(mname,productid,productname,price,image) values(?,?,?,?,?)";
				PreparedStatement pr = con.prepareStatement(query);
				pr.setString(1, fakeProduct.getmName());
				pr.setString(2, fakeProduct.getProductid());
				pr.setString(3, fakeProduct.getProductName());
				pr.setString(4, fakeProduct.getPrice());
				pr.setString(5, fakeProduct.getImage());

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

	public List<FakeProductPojo> getfakeproductDetails() {
		List<FakeProductPojo> list = new ArrayList<FakeProductPojo>();
		try {
			String query = "select * from fakeproduct";
			Connection con = Dao.getConnection();
			PreparedStatement pr = con.prepareStatement(query);
			ResultSet rs = pr.executeQuery();
			while (rs.next()) {
				FakeProductPojo fake = new FakeProductPojo(rs
						.getString("mname"), rs.getString("productid"), rs
						.getString("productname"), rs.getString("price"), rs
						.getString("images"));

				list.add(fake);
				System.out.println("--------->" + list);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
