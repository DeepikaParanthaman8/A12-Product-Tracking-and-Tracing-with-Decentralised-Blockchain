package com.Modul;

import java.io.Serializable;

public class SupplierRegPojo implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private String protype;
	private String email;
	private String phone;
	private String address;
	private String pass;
	private String supplier_id;

	/**
	 * @param name
	 * @param protype
	 * @param email
	 * @param phone
	 * @param address
	 * @param pass
	 */
	public SupplierRegPojo(String name, String protype, String email,
			String phone, String address, String pass, String supplier_id) {
		super();
		this.name = name;
		this.protype = protype;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.pass = pass;
		this.supplier_id = supplier_id;
	}

	@Override
	public String toString() {
		return "SupplierRegPojo [address=" + address + ", email=" + email
				+ ", name=" + name + ", pass=" + pass + ", phone=" + phone
				+ ", protype=" + protype + ", supplier_id=" + supplier_id + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProtype() {
		return protype;
	}

	public void setProtype(String protype) {
		this.protype = protype;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public void setSupplier_id(String supplier_id) {
		this.supplier_id = supplier_id;
	}

	public String getSupplier_id() {
		return supplier_id;
	}

}
