package blockchain;

public class ProductsBean {
	private String brandName, productName, serialId, productPrice,
			productAssembleId, dSno, dProductPrice, dProductName, image;

	public ProductsBean(String brandName, String productName, String serialId,
			String productPrice, String productAssembleId, String dSno,
			String dProductPrice, String dProductName, String image) {
		super();
		this.brandName = brandName;
		this.productName = productName;
		this.serialId = serialId;
		this.productPrice = productPrice;
		this.productAssembleId = productAssembleId;
		this.dSno = dSno;
		this.dProductPrice = dProductPrice;
		this.dProductName = dProductName;
		this.image = image;
	}

	public ProductsBean() {

	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getSerialId() {
		return serialId;
	}

	public void setSerialId(String serialId) {
		this.serialId = serialId;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductAssembleId() {
		return productAssembleId;
	}

	public void setProductAssembleId(String productAssembleId) {
		this.productAssembleId = productAssembleId;
	}

	public String getdSno() {
		return dSno;
	}

	public void setdSno(String dSno) {
		this.dSno = dSno;
	}

	public String getdProductPrice() {
		return dProductPrice;
	}

	public void setdProductPrice(String dProductPrice) {
		this.dProductPrice = dProductPrice;
	}

	public String getdProductName() {
		return dProductName;
	}

	public void setdProductName(String dProductName) {
		this.dProductName = dProductName;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
