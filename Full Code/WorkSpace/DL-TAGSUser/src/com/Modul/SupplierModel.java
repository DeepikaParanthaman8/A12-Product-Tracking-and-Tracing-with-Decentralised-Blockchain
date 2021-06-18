package com.Modul;

import java.io.Serializable;

public class SupplierModel implements Serializable {

	private static final long serialVersionUID = 6529685098267757691L;
	private String name;
	private String produceid;
	private String desc;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getProduceid() {
		return produceid;
	}

	public void setProduceid(String produceid) {
		this.produceid = produceid;
	}

}
