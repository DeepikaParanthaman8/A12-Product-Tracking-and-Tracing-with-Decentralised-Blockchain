package com.Service;

import java.util.List;

import com.dis.modul.DisPojo;
import com.dis.modul.DistributorPojo;
import com.dis.modul.ManPojo;

public interface MethodInterface {

	boolean saveDistributor(DistributorPojo distributorPojo);

	String distributorLogin(String email, String password);

	List<ManPojo> loadinventory();

	boolean sendDistributorRequests(DisPojo disPojo);

	List<DisPojo> loadDistributorRequests(String did);

	List<DisPojo> loadDistributorRequestsId(String manufacturer);

	boolean declineDistributor(String pid, String date);

	String approveDistributor(String pid, String date, String quantity,
			String manufacturer);

	boolean updateDistributorProducts(String distributor, String pid, String dprice);

}
