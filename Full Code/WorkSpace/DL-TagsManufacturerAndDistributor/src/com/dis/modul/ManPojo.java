package com.dis.modul;

import java.io.Serializable;

public class ManPojo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String productId, manufacturerName, productName, price, imagePath,
			description, Quantity, assembledate;

	public ManPojo(String productId, String manufacturerName,
			String productName, String price, String imagePath,
			String description, String Quantity, String assembledate) {
		super();
		this.productId = productId;
		this.manufacturerName = manufacturerName;
		this.productName = productName;
		this.price = price;
		this.imagePath = imagePath;
		this.description = description;
		this.Quantity = Quantity;
		this.assembledate = assembledate;
	}

	public ManPojo() {
		// TODO Auto-generated constructor stub
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getManufacturerName() {
		return manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @param quantity
	 *            the quantity to set
	 */
	public void setQuantity(String quantity) {
		Quantity = quantity;
	}

	/**
	 * @return the quantity
	 */
	public String getQuantity() {
		return Quantity;
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
