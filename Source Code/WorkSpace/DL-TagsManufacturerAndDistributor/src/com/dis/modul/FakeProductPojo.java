package com.dis.modul;

public class FakeProductPojo {
	private String mName;
	private String productid;
	private String productName;
	private String price;
	private String image;

	/**
	 * @param mName
	 * @param productid
	 * @param productName
	 * @param price
	 * @param image
	 */
	public FakeProductPojo(String mName, String productid, String productName,
			String price, String image) {
		super();
		this.mName = mName;
		this.productid = productid;
		this.productName = productName;
		this.price = price;
		this.image = image;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getProductid() {
		return productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
