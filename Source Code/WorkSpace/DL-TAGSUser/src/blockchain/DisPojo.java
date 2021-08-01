package blockchain;

public class DisPojo {
	private String manufacturer, distributor, productId, productName, dateTime,
			image, status, price, distributorPrice, quantity, qrcode, adate;

	public DisPojo(String manufacturer, String distributor, String productId,
			String productName, String dateTime, String image, String status,
			String price, String distributorPrice, String quantity,
			String qrcode, String adate) {
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
		this.quantity = quantity;
		this.qrcode = qrcode;
		this.adate = adate;
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
	 * @param quantity
	 *            the quantity to set
	 */
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the quantity
	 */
	public String getQuantity() {
		return quantity;
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

}
