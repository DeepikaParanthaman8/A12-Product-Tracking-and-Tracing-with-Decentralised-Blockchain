package com.Model;

public class ManufactureInven {
	private String sno;
	private String manufacturename;
	private String supplierid;
	private String productid;
	private String quanity;

	/**
	 * @param sno
	 * @param manufacturename
	 * @param supplierid
	 * @param productid
	 * @param quanity
	 */
	/*public ManufactureInven(String sno, String manufacturename,
			String supplierid, String productid, String quanity) {
		super();
		this.sno = sno;
		this.manufacturename = manufacturename;
		this.supplierid = supplierid;
		this.productid = productid;
		this.quanity = quanity;
	}*/

	@Override
	public String toString() {
		return "ManufactureInven [manufacturename=" + manufacturename
				+ ", productid=" + productid + ", quanity=" + quanity
				+ ", sno=" + sno + ", supplierid=" + supplierid + "]";
	}

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getManufacturename() {
		return manufacturename;
	}

	public void setManufacturename(String manufacturename) {
		this.manufacturename = manufacturename;
	}

	public String getSupplierid() {
		return supplierid;
	}

	public void setSupplierid(String supplierid) {
		this.supplierid = supplierid;
	}

	public String getProductid() {
		return productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}

	public String getQuanity() {
		return quanity;
	}

	public void setQuanity(String quanity) {
		this.quanity = quanity;
	}

}
