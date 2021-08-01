package service;

public class ShopPojoall {
	private String distributorID, distributorprice, image, manifacture, price,
			productid, productName, status, adateqrcode, quanity, qrcode;

	/**
	 * @param distributorID
	 * @param distributorprice
	 * @param image
	 * @param manifacture
	 * @param price
	 * @param productid
	 * @param productName
	 * @param status
	 * @param adateqrcode
	 * @param quanity
	 */
	public ShopPojoall(String distributorID, String distributorprice,
			String image, String manifacture, String price, String productid,
			String productName, String status, String adateqrcode,
			String quanity, String qrcode) {
		super();
		this.distributorID = distributorID;
		this.distributorprice = distributorprice;
		this.image = image;
		this.manifacture = manifacture;
		this.price = price;
		this.productid = productid;
		this.productName = productName;
		this.status = status;
		this.adateqrcode = adateqrcode;
		this.quanity = quanity;
		this.qrcode = qrcode;
	}

	public String getDistributorID() {
		return distributorID;
	}

	public void setDistributorID(String distributorID) {
		this.distributorID = distributorID;
	}

	public String getDistributorprice() {
		return distributorprice;
	}

	public void setDistributorprice(String distributorprice) {
		this.distributorprice = distributorprice;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getManifacture() {
		return manifacture;
	}

	public void setManifacture(String manifacture) {
		this.manifacture = manifacture;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAdateqrcode() {
		return adateqrcode;
	}

	public void setAdateqrcode(String adateqrcode) {
		this.adateqrcode = adateqrcode;
	}

	public String getQuanity() {
		return quanity;
	}

	public void setQuanity(String quanity) {
		this.quanity = quanity;
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

}
