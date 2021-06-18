package com.Modul;

import java.io.Serializable;

public class ManifactureMakingProductPojo implements Serializable {

	private static final long serialVersionUID = 1L;
	private String id;
	private String productid;
	private String manifactureName;
	private String productName;
	private String price;
	private String imagepath;
	private String desacription;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProductid() {
		return productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}

	public String getManifactureName() {
		return manifactureName;
	}

	public void setManifactureName(String manifactureName) {
		this.manifactureName = manifactureName;
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

	public String getImagepath() {
		return imagepath;
	}

	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}

	public String getDesacription() {
		return desacription;
	}

	public void setDesacription(String desacription) {
		this.desacription = desacription;
	}

	@Override
	public String toString() {
		return "MAnifactureMakingProductPojo [desacription=" + desacription
				+ ", id=" + id + ", imagepath=" + imagepath
				+ ", manifactureName=" + manifactureName + ", price=" + price
				+ ", productName=" + productName + ", productid=" + productid
				+ "]";
	}

}
