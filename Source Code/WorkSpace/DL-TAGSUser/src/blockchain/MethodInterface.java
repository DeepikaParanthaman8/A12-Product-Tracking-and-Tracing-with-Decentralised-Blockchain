package blockchain;

import java.util.List;

public interface MethodInterface {

	List<ProductsBean> getAllProducts();

	List<ProductsBean> getAllProducts(String aid);

	boolean requestForProducts(String email);

	String getDistributorsList();

	List<DisPojo> loadDistributorsData(String did);

	boolean updateShipment(String id);

}
