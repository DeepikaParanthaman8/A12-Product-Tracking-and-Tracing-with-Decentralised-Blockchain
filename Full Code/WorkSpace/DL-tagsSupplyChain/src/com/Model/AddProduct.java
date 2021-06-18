package com.Model;

public class AddProduct {
	private String image;
	private String suplierid;
	private String proid;
	private String productname;
	private String description;
	private String quanity;
	private String price;

	@Override
	public String toString() {
		return "AddProduct [description=" + description + ", image=" + image
				+ ", price=" + price + ", productname=" + productname
				+ ", proid=" + proid + ", quanity=" + quanity + "]";
	}

	/**
	 * @param image
	 * @param proid
	 * @param productname
	 * @param description
	 * @param quanity
	 * @param price
	 */
	public AddProduct(String image, String proid, String productname,
			String description, String quanity, String price,String suplierid) {
		super();
		this.image = image;
		this.proid = proid;
		this.productname = productname;
		this.description = description;
		this.quanity = quanity;
		this.price = price;
		this.suplierid = suplierid;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getProid() {
		return proid;
	}

	public void setProid(String proid) {
		this.proid = proid;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getQuanity() {
		return quanity;
	}

	public void setQuanity(String quanity) {
		this.quanity = quanity;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public void setSuplierid(String suplierid) {
		this.suplierid = suplierid;
	}

	public String getSuplierid() {
		return suplierid;
	}

}
