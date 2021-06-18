package com.Service;

import java.util.List;

import com.Modul.AddProduct;
import com.Modul.ContractModel;
import com.Modul.M_RegisterPojo;
import com.Modul.ManifactureMakingProductPojo;
import com.Modul.ManufactureInven;
import com.Modul.RequestQuanityPojo;
import com.Modul.SupplierRegPojo;
import com.dis.modul.FakeProductPojo;

public interface ManServiceCall {

	public boolean userRegister(M_RegisterPojo mRegisterPojo);

	public List<M_RegisterPojo> getUserDetails();

	public String M_Login(String email, String Pass);

	public List<SupplierRegPojo> getSupplierDetails();

	public List<AddProduct> getProductDetails(String supid);

	public boolean quantityRequest(RequestQuanityPojo requestQuanityPojo);

	public boolean quantityRequestupdate(String quanity, String productId);

	public List<ManufactureInven> getManifactureDetils(String manifactureEmail);

	public List<ManifactureMakingProductPojo> getMakingProduct(
			String manifactureName);

	public List<ContractModel> getDetails();

	public boolean fackeproduct(FakeProductPojo fakeProduct);

	public List<FakeProductPojo> getfakeproductDetails();

}
