package com.Modul;

import java.io.Serializable;
import java.util.List;

public class ContractModel implements Serializable {

	private static final long serialVersionUID = 6529685098267757690L;
	private String manuName;
	private String price;
	private String imagePath;
	private String proId;
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
}
