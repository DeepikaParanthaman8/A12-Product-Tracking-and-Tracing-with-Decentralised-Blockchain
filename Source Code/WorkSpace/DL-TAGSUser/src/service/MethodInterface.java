package service;

import java.util.List;

import model.BuyPojo;
import model.ShopPojo;
import model.UserPojo;

public interface MethodInterface {

	boolean saveUser(UserPojo userPojo);

	String loginUser(String email, String password);

	boolean saveProducts(BuyPojo buyPojo);

	List<BuyPojo> purchasedProducts();

	boolean updateSavedProducts(String email, String date);

	boolean saveStoreRequests(ShopPojo shopPojo);

	List<ShopPojo> loadShopProducts();

	boolean updateStore(String productID);

	boolean updateStore(String productid,String quanity);

}
