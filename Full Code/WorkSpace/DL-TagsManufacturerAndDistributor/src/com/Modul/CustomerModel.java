package com.Modul;

import java.io.Serializable;

public class CustomerModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private DistributorModel distributorModel;
	private String traxId, bankName, purdate;

	public DistributorModel getDistributorModel() {
		return distributorModel;
	}

	public void setDistributorModel(DistributorModel distributorModel) {
		this.distributorModel = distributorModel;
	}

	public String getTraxId() {
		return traxId;
	}

	public void setTraxId(String traxId) {
		this.traxId = traxId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getPurdate() {
		return purdate;
	}

	public void setPurdate(String purdate) {
		this.purdate = purdate;
	}

}
