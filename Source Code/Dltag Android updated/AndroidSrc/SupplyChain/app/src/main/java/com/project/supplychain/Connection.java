package com.project.supplychain;

public class Connection {
	public static final String Domain_Name ="DL-TagsManufacturerAndDistributor";

	public static String Port_No = "8888";
	/*-------------------Url Call-------------------*/
	public static String MAIN_URL = "http://"+IpAddress.Ip_Address+":"+Port_No+"/"+Domain_Name+"/";
	public static String USER_LOGIN = MAIN_URL+"UserSignin";
	public static String USER_PRODUCT = MAIN_URL+"GetQrDetails";
	public static String Product_Image = MAIN_URL+"/photo/";


}
