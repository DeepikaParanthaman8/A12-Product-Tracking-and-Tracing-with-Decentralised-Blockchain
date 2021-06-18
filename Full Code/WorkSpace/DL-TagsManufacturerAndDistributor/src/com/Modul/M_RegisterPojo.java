package com.Modul;

import java.io.Serializable;

public class M_RegisterPojo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String email;
	private String phone;
	private String password;

	/**
	 * @param name
	 * @param email
	 * @param phone
	 * @param password
	 */

	public M_RegisterPojo(String name, String email, String phone, String password) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}

	@Override
	public String toString() {
		return "M_Register [email=" + email + ", name=" + name + ", password="
				+ password + ", phone=" + phone + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
