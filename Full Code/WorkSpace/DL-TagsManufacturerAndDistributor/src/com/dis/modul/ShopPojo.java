package com.dis.modul;

import java.io.Serializable;

public class ShopPojo implements Serializable {

	private static final long serialVersionUID = 1L;
	private long id;
	private String manufacturer, distributor, productId, productName, image,
			price, distributorPrice, status, adate, qrcode, quantiny;

	public ShopPojo(String manufacturer, String distributor, String productId,
			String productName, String image, String price,
			String distributorPrice, String status, String adate,
			String qrcode, String quantiny) {
		super();
		this.manufacturer = manufacturer;
		this.distributor = distributor;
		this.productId = productId;
		this.productName = productName;
		this.image = image;
		this.price = price;
		this.distributorPrice = distributorPrice;
		this.status = status;
		this.adate = adate;
		this.qrcode = qrcode;
		this.quantiny = quantiny;
	}

	public ShopPojo() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @param adate
	 *            the adate to set
	 */
	public void setAdate(String adate) {
		this.adate = adate;
	}

	/**
	 * @return the adate
	 */
	public String getAdate() {
		return adate;
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
	 * @param quantiny
	 *            the quantiny to set
	 */
	public void setQuantiny(String quantiny) {
		this.quantiny = quantiny;
	}

	/**
	 * @return the quantiny
	 */
	public String getQuantiny() {
		return quantiny;
	}

}
