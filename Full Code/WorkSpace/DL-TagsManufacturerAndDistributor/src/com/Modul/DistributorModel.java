package com.Modul;

import java.io.Serializable;

public class DistributorModel implements Serializable {

	private static final long serialVersionUID = 1L;
	public ContractModel contractModel;
	public String disPrice;
	public String disName;
	public String disId;
	public String images;
	public String proname;
	public String proid;
	public String qrcode;
	public ContractModel getContractModel() {
		return contractModel;
	}
	public void setContractModel(ContractModel contractModel) {
		this.contractModel = contractModel;
	}
	public String getDisPrice() {
		return disPrice;
	}
	public void setDisPrice(String disPrice) {
		this.disPrice = disPrice;
	}
	public String getDisName() {
		return disName;
	}
	public void setDisName(String disName) {
		this.disName = disName;
	}
	public String getDisId() {
		return disId;
	}
	public void setDisId(String disId) {
		this.disId = disId;
	}
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
	public String getProname() {
		return proname;
	}
	public void setProname(String proname) {
		this.proname = proname;
	}
	public String getProid() {
		return proid;
	}
	public void setProid(String proid) {
		this.proid = proid;
	}
	public String getQrcode() {
		return qrcode;
	}
	public void setQrcode(String qrcode) {
		this.qrcode = qrcode;
	}

	
	

}
