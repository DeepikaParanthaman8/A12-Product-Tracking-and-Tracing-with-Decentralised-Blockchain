package com.dis.modul;

import java.io.Serializable;

public class DistributorPojo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name, email, password, mobile, distributroId;

	public DistributorPojo(String name, String email, String password,
			String mobile, String distributorId) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
		this.distributroId = distributorId;
	}

	public DistributorPojo() {
		// TODO Auto-generated constructor stub
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getDistributroId() {
		return distributroId;
	}

	public void setDistributroId(String distributroId) {
		this.distributroId = distributroId;
	}
}
