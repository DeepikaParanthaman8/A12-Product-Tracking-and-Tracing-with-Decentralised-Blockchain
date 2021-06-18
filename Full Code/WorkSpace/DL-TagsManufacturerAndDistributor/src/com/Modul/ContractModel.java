package com.Modul;

import java.io.Serializable;
import java.util.List;

public class ContractModel implements Serializable {

	private static final long serialVersionUID = 1589322800283028622L;

	private String manuName;
	private String price;
	private String imagePath;
	private String proId;
	private String numberOfProduct;
	private String assembleDate;
	private List<SupplierModel> hashMap;

	public String getManuName() {
		return manuName;
	}

	public void setManuName(String manuName) {
		this.manuName = manuName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getProId() {
		return proId;
	}

	public void setProId(String proId) {
		this.proId = proId;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public List<SupplierModel> getHashMap() {
		return hashMap;
	}

	public void setHashMap(List<SupplierModel> hashMap) {
		this.hashMap = hashMap;
	}

	@Override
	public String toString() {
		return "ContractModel [hashMap=" + hashMap + ", imagePath=" + imagePath
				+ ", manuName=" + manuName + ", price=" + price + ", proId="
				+ proId + "]";
	}

	/**
	 * @param numberOfProduct
	 *            the numberOfProduct to set
	 */
	public void setNumberOfProduct(String numberOfProduct) {
		this.numberOfProduct = numberOfProduct;
	}

	/**
	 * @return the numberOfProduct
	 */
	public String getNumberOfProduct() {
		return numberOfProduct;
	}

	/**
	 * @param assembleDate the assembleDate to set
	 */
	public void setAssembleDate(String assembleDate) {
		this.assembleDate = assembleDate;
	}

	/**
	 * @return the assembleDate
	 */
	public String getAssembleDate() {
		return assembleDate;
	}
}
