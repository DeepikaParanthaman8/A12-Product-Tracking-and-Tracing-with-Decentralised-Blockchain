package controller;

import com.wsdl.BankWebServiceDelegate;
import com.wsdl.BankWebServiceService;



public class AccessBankService 
{
	public String requestBank(String mailid,String payment)
	{
		String str="";
		try
		{
			BankWebServiceService bankserverservice=new BankWebServiceService();
			BankWebServiceDelegate bankserdeleg=bankserverservice.getBankWebServicePort();
			str=bankserdeleg.setPayment(mailid, payment);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return str;
	}
}
