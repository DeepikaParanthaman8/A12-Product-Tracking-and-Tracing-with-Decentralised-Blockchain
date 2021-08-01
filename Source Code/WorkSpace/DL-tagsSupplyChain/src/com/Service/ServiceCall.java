package com.Service;

import java.util.List;

import com.Model.AddProduct;
import com.Model.ManufactureInven;
import com.Model.RequestQuanity;
import com.Model.SupplierRegPojo;

public interface ServiceCall {

	public boolean userRegister(SupplierRegPojo supplierRegPojo);

	public List<SupplierRegPojo> getUserDetails();

	public String getLogin(String email, String Pass);

	public boolean setAddproduct(AddProduct addProduct);

	public List<SupplierRegPojo> getSupplierDetails(String sup_id);

	public List<AddProduct> getAllProduct();

	public List<RequestQuanity> getProductDetails(String sup_id);

	public boolean acceptedSupplier(String supid);

	public boolean DeclineSupplier(String sno);

	public List<ManufactureInven> getManifactureDetails(String sup_id,
			String productId);

	public List<RequestQuanity> getRequestQuanityDetails(String s_no);

	public boolean insertManifacture_inventry(ManufactureInven manufactureInven);

	public boolean DeclineSupplierQuanity(String quanity, String supplierid,
			String productId);

}
