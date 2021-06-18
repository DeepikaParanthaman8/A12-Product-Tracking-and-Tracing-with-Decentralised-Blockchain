package com.dis.modul;

import java.io.Serializable;

public class DisPojo implements Serializable {

	private static final long serialVersionUID = 1L;
	private String manufacturer, distributor, productId, productName, dateTime,
			image, status, price, distributorPrice, quanity, qrcode,
			assembledate;

	public DisPojo(String manufacturer, String distributor, String productId,
			String productName, String dateTime, String image, String status,
			String price, String distributorPrice, String quanity,
			String qrcode, String assembledate) {
		super();
		this.manufacturer = manufacturer;
		this.distributor = distributor;
		this.productId = productId;
		this.productName = productName;
		this.dateTime = dateTime;
		this.image = image;
		this.status = status;
		this.price = price;
		this.distributorPrice = distributorPrice;
		this.quanity = quanity;
		this.qrcode = qrcode;
		this.assembledate = assembledate;
	}

	public DisPojo() {

	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getDistributor() {
		return distributor;
	}

	public void setDistributor(String distributor) {
		this.distributor = distributor;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDistributorPrice() {
		return distributorPrice;
	}

	public void setDistributorPrice(String distributorPrice) {
		this.distributorPrice = distributorPrice;
	}

	/**
	 * @param quanity
	 *            the quanity to set
	 */
	public void setQuanity(String quanity) {
		this.quanity = quanity;
	}

	/**
	 * @return the quanity
	 */
	public String getQuanity() {
		return quanity;
	}

	/**
	 * @param qrcode
	 *            the qrcode to set
	 */
	public void setQrcode(String qrcode) {
		this.qrcode = qrcode;
	}

	/**
	 * @return the qrcode
	 */
	public String getQrcode() {
		return qrcode;
	}

	/**
	 * @param assembledate
	 *            the assembledate to set
	 */
	public void setAssembledate(String assembledate) {
		this.assembledate = assembledate;
	}

	/**
	 * @return the assembledate
	 */
	public String getAssembledate() {
		return assembledate;
	}

}
