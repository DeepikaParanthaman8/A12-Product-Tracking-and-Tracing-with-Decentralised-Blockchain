package com.Model;

public class RequestQuanity {
	private String sno;
	private String manufacturename;
	private String supplierid;
	private String productid;
	private String qyanity;
	private String status;
	private String reqdate;
	private String productname;

	/**
	 * @param manufacturename
	 * @param supplierid
	 * @param productid
	 * @param qyanity
	 * @param status
	 * @param reqdate
	 */
	public RequestQuanity(String sno, String manufacturename,
			String supplierid, String productid, String qyanity, String status,
			String reqdate, String productname) {
		super();
		this.sno = sno;
		this.manufacturename = manufacturename;
		this.supplierid = supplierid;
		this.productid = productid;
		this.qyanity = qyanity;
		this.status = status;
		this.reqdate = reqdate;
		this.productname = productname;

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

	public String getQyanity() {
		return qyanity;
	}

	public void setQyanity(String qyanity) {
		this.qyanity = qyanity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getReqdate() {
		return reqdate;
	}

	public void setReqdate(String reqdate) {
		this.reqdate = reqdate;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getSno() {
		return sno;
	}

	@Override
	public String toString() {
		return "RequestQuanity [manufacturename=" + manufacturename
				+ ", productid=" + productid + ", qyanity=" + qyanity
				+ ", reqdate=" + reqdate + ", sno=" + sno + ", status="
				+ status + ", supplierid=" + supplierid + "]";
	}

	/**
	 * @param productname
	 *            the productname to set
	 */
	public void setProductname(String productname) {
		this.productname = productname;
	}

	/**
	 * @return the productname
	 */
	public String getProductname() {
		return productname;
	}

}
