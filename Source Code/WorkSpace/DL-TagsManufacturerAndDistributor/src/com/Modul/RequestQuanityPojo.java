package com.Modul;

import java.io.Serializable;

public class RequestQuanityPojo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String manifactureName;
	private String supplierid;
	private String productid;
	private String quantity;
	private String status;
	private String requestedDate;
	private String productname;

	/**
	 * @param manifactureName
	 * @param supplierid
	 * @param productid
	 * @param quantity
	 * @param status
	 * @param requestedDate
	 */

	public String getManifactureName() {
		return manifactureName;
	}

	public void setManifactureName(String manifactureName) {
		this.manifactureName = manifactureName;
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

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRequestedDate() {
		return requestedDate;
	}

	public void setRequestedDate(String requestedDate) {
		this.requestedDate = requestedDate;
	}

	@Override
	public String toString() {
		return "RequestQuanityPojo [manifactureName=" + manifactureName
				+ ", productid=" + productid + ", quantity=" + quantity
				+ ", requestedDate=" + requestedDate + ", status=" + status
				+ ", supplierid=" + supplierid + "]";
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
