package com.banklogic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import org.apache.struts2.ServletActionContext;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

public class DbQueries
{
	String qu="";
	Connection con=null;
	PreparedStatement pst=null;
	
	public DbQueries()
	{
		ServletContext sc=ServletActionContext.getServletContext();
		con=(Connection) sc.getAttribute("connection");
	}
	
	public Integer insertUserDetails(CommonBean comb)
	{
		int dbst=0;
		try
		{
			pst=con.prepareStatement("insert into userinfo values(?,?,?,?,?,?,?,?)");
			pst.setString(1,comb.getAccountnumb());
			pst.setString(2,comb.getUsername());
			pst.setString(3,comb.getMobnum());
			pst.setString(4,comb.getEmail());
			pst.setString(5,comb.getAddress());
			pst.setString(6,comb.getCity());
			pst.setString(7,comb.getPincode());
			pst.setString(8,comb.getState());
			dbst=pst.executeUpdate();
			
			pst=con.prepareStatement("insert into useraccountinfo values(?,?,?,?,?)");
			pst.setString(1,comb.getAccountnumb());
			pst.setString(2,comb.getPinpass());
			pst.setString(3,comb.getAmount());
			pst.setString(4,"null");
			pst.setString(5,"null");
			dbst=pst.executeUpdate();			
			pst.close();
		}
		catch(MySQLIntegrityConstraintViolationException e)
		{
			dbst=0;
		}
		catch (Exception e)	
		{
			e.printStackTrace();
		}
		return dbst;
	}
	
	public ArrayList getUsersAccountId()
	{
		ArrayList arrayl=new ArrayList();
		try
		{
			qu="select accountno from userinfo";
			pst=con.prepareStatement(qu);
			ResultSet rs=pst.executeQuery();			 
			while(rs.next())
			{
				arrayl.add(rs.getString(1));
			}
			pst.close();
		}
		catch (Exception e)	
		{
			e.printStackTrace();
		}
		return arrayl;
	}
	
	public String getUserAccountInd(String accno)
	{
		String str="";
		try
		{
			qu="SELECT userinfo.*,useraccountinfo.amount"
				+" FROM userinfo"
				+" INNER JOIN useraccountinfo"
				+" ON userinfo.accountno=useraccountinfo.accountno"
				+" where userinfo.accountno=?";
			
			pst=con.prepareStatement(qu);
			pst.setString(1,accno);
			ResultSet rs=pst.executeQuery();			 
			if(rs.next())
			{
				str=accno+"&"+rs.getString(2)+"&"+rs.getString(9)+"&"+rs.getString(3)+"&"+rs.getString(4)+"&"+rs.getString(5)+"&"+rs.getString(6)+"&"+rs.getString(7)+"&"+rs.getString(8);
			}
			pst.close();
		}
		catch (Exception e)	
		{
			e.printStackTrace();
		}
		return str;
	}
	
	public String retAccountAmount(String accno)
	{
		String str="";
		try
		{
			pst=con.prepareStatement("select accountholdername from userinfo where accountno=?");
			pst.setString(1,accno);
			ResultSet rs=pst.executeQuery();			 
			if(rs.next())
			{
				str=accno+"&"+rs.getString(1);
			}
			pst.close();
		}
		catch (Exception e)	
		{
			e.printStackTrace();
		}
		return str;
	}
	
	public void updateAccountHolderTab(CommonBean comb)
	{
		try
		{
			pst=con.prepareStatement("update userinfo set accountholdername=?,mobilenumber=?,mailid=?,Address=?,city=?,pincode=?,state=? where accountno=? ");			
			pst.setString(1,comb.getUsername());
			pst.setString(2,comb.getMobnum());
			pst.setString(3,comb.getEmail());
			pst.setString(4,comb.getAddress());
			pst.setString(5,comb.getCity());
			pst.setString(6,comb.getPincode());
			pst.setString(7,comb.getState());
			pst.setString(8,comb.getAccountnumb());
			pst.executeUpdate();
			pst.close();
		}
		catch (Exception e)	
		{
			e.printStackTrace();
		}
	}
	
	public void addAmountAccount(CommonBean comb)
	{
		try
		{
			String str="";
			pst=con.prepareStatement("select amount from useraccountinfo where accountno=?");
			pst.setString(1,comb.getAccountnumb());
			ResultSet rs=pst.executeQuery();			 
			if(rs.next())
			{
				str=rs.getString(1);
			}
			
			int am=Integer.parseInt(str.trim())+Integer.parseInt(comb.getAmount().toString().trim());
			
			pst=con.prepareStatement("update useraccountinfo set amount=? where accountno=?");
			pst.setString(1,(am+""));
			pst.setString(2,comb.getAccountnumb());
			pst.executeUpdate();
			pst.close();
		}
		catch (Exception e)	
		{
			e.printStackTrace();
		}
	}
	
	public int checkTransaction(CommonBean comb)
	{
		int dbst=0;
		try
		{
			pst=con.prepareStatement("select pinpass,amount,opass,transferamount from useraccountinfo where accountno=?");
			pst.setString(1,comb.getAccountnumb());
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{
				String atmpin=rs.getString(1);
				String amount=rs.getString(2);
				String opass=rs.getString(3);
				String transamt=rs.getString(4);
				System.out.println(comb.getAccountnumb());
				if(atmpin.equals(comb.getPinpass()) && opass.equals(comb.getOpass()))
				{
					int amt=Integer.parseInt(amount)-Integer.parseInt(transamt);
					System.out.println(amt);
					if(amt>0)
					{
						pst=con.prepareStatement("update useraccountinfo set amount=? where accountno=?");
						pst.setString(1,""+amt);
						pst.setString(2,comb.getAccountnumb());
						dbst=pst.executeUpdate();
						
						pst=con.prepareStatement("update useraccountinfo set transferamount=? where accountno=?");
						pst.setString(1,"null");
						pst.setString(2,comb.getAccountnumb());
						pst.executeUpdate();
					}
					else
					{
						dbst=0;
					}
				}
			}
		}
		catch (Exception e)	
		{
			e.printStackTrace();
		}
		return dbst;
	}	
}