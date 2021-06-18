<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Bank Server</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
	<link href="style.css" rel="stylesheet" type="text/css" />	
	<link rel="stylesheet" href="jquery/jqueryui.css">
	<script src="jquery/jquery10.js"></script>
	<script src="jquery/jqueryuijq.js"></script>
	<script src="ajax.js"></script>
	
	<script>
		$(document).ready(function()
		{
			$("#errorreportlab").hide();
			$("#seconddiv").hide();
			$("#firstsubbut").hide();			
			
			$("#newuserlink").click(function()
			{
				$("#firstdiv").hide();
				$("#seconddiv").fadeIn(500);
				
				document.newholderform.usernametext.value="";
				document.newholderform.phonetext.value="";
				document.newholderform.emailtext.value="";
				document.newholderform.addresstext.value="";
				document.newholderform.citytext.value="";
				document.newholderform.pincodetext.value="";
				document.newholderform.statetext.value="";
			});
			
			$("#homelink").click(function()
			{
				$("#seconddiv").hide();
				$("#firstdiv").fadeIn(500);
				
				document.getElementById("errorreportlabfirstdiv").value="";
			});
		});
		
		$(function()
	  	{
  			$.get('citynames.txt', function(txtFile)
	  		{
		  		var languages = txtFile.split("\n");
	  			$("#tags").autocomplete({
	    			source: languages
	  			});
	  			
	  			$("#firstcitytextid").autocomplete({
	    			source: languages
	  			});
			});
		});
	</script>
	
	<script>
		function callAjaxPincode()
		{
			var str=document.getElementById("tags").value;
			makeRequest("callpincodestate?hidden=cityname&key="+str);
		}
		
		function callAccountInfoAjax()
		{
			var str=document.getElementById("selectbankholdid").value;
			makeRequest("editaccountholder?hidden=editholder&key="+str);
		}		
		
		function isNumberKey(evt)
		{
    		var charCode = (evt.which) ? evt.which : event.keyCode
   			if (charCode > 31 && (charCode < 48 || charCode > 57))
        		return false;
    			return true;
		}
		
		function callAccountEditFunc()
		{
		  	var r1=document.getElementById("firstbankholdernamesid");
		  	var r2=document.getElementById("firstamounttextid");
		  	var r3=document.getElementById("firstphonetextid");
		  	var r4=document.getElementById("firstmailtextid");
		  	var r5=document.getElementById("firstaddresstextid");		  	
		  	
		  	r1.readOnly = false;
		  	r3.readOnly = false;
		  	r4.readOnly = false;
		  	r5.readOnly = false;
		  	
		  	$("#editbuttonfirst").hide(500);
		  	$("#firstsubbut").fadeIn(500);
		}
		
		function newholderformfunc()
		{
			$("#errorreportlab").hide();
			var username=document.newholderform.usernametext.value;
			var pho=document.newholderform.phonetext.value;
			var mail=document.newholderform.emailtext.value;
			var addr=document.newholderform.addresstext.value;
			var cit=document.newholderform.citytext.value;
			var pincode=document.newholderform.pincodetext.value;
			var stat=document.newholderform.statetext.value;
		
			var atpos=mail.indexOf("@");
			var dotpos=mail.lastIndexOf(".");
			
			if(username=="" || pho=="" || mail=="" || addr=="" || cit=="" || pincode=="" || stat=="")
			{
				$("#errorreportlab").fadeIn(700);
				document.getElementById('errorreportlab').innerHTML="Please fill all the details.";
				return false;
			}
			else
	    	if(atpos<1 || dotpos<atpos+2 || dotpos+2>=mail.length)
    		{
	    		$("#errorreportlab").fadeIn(700);
				document.getElementById('errorreportlab').innerHTML="Give an valid email address.";
				return false;
    		}
			else
			if(pho.length<10 || pho=="0000000000")
			{
				$("#errorreportlab").fadeIn(1400);
				document.getElementById('errorreportlab').innerHTML="Give an valid mobile number.";
				return false;
			}
			else
			{
				return true;
			}
			return false;
		}
		
		function editholderformfunc()
		{
			$("#errorreportlabfirstdiv").hide();
			var username=document.editformname.firstbankholdernames.value;
			var pho=document.editformname.firstphonetext.value;
			var mail=document.editformname.firstmailtext.value;
			var addr=document.editformname.firstaddresstext.value;
			var cit=document.editformname.firstcitytext.value;
			var pincode=document.editformname.firstpincodetext.value;
			var stat=document.editformname.firststatetext.value;
			
			var atpos=mail.indexOf("@");
			var dotpos=mail.lastIndexOf(".");
			
			if(username=="" || pho=="" || mail=="" || addr=="" || cit=="" || pincode=="" || stat=="")
			{
				$("#errorreportlabfirstdiv").fadeIn(700);
				document.getElementById('errorreportlabfirstdiv').innerHTML="Please fill all the details.";
				return false;
			}
			else
	    	if(atpos<1 || dotpos<atpos+2 || dotpos+2>=mail.length)
    		{
	    		$("#errorreportlabfirstdiv").fadeIn(700);
				document.getElementById('errorreportlabfirstdiv').innerHTML="Give an valid email address.";
				return false;
    		}
			else
			if(pho.length<10 || pho=="0000000000")
			{
				$("#errorreportlabfirstdiv").fadeIn(1400);
				document.getElementById('errorreportlabfirstdiv').innerHTML="Give an valid mobile number.";
				return false;
			}
			else
			{
				return true;
			}
		}
	</script>
  </head>
  
<body>
	<div id="topPan">
		<center><img src="images/banklogo3.png" alt="Education Zone" border="0" width="350" height="130" style="margin-top:10px;" title="Education Zone"/></center>	
		<div id="topContactPan"></div>
		<div id="topMenuPan">
	  		<div id="topMenuLeftPan"></div>
	  		<div id="topMenuMiddlePan">
		  		<ul>
					<li class="home"><a href="javascript:void(0);" id="homelink">Home</a></li>
					<li><a href="#"></a></li>
					<li><a href="javascript:void(0);" id="newuserlink">NewUser</a></li>
					<li><a href="#"></a></li>
					<li><a href="addamount">AddAmount</a></li>		
					<li><a href="#"></a></li>
					<li><a href="#"></a></li>			
					<li class="contact"><a href="logout" class="contact">Logout</a></li>
				</ul>
	  		</div>
	  		<div id="topMenuRightPan"></div>
		</div>
	</div>

	<div id="bodyPan">	
		<div id="firstdiv">
			<div id="bodyLeftPan">
				<div style="border:1px solid #CFCFCF;padding:15px;">
  					<center><label style="font-weight:bold;color:black;font:28px/28px Georgia,Times New Roman,Times,serif;">Account Information</label></center>
  				</div>
  				<br/>
  				<center><label id="errorreportlabfirstdiv" style=";font-weight:bold;color:red;letter-spacing:2px;"><s:actionmessage/>  		
		  		</label></center>
		  		<br/>
  				<div style="border:1px solid #CFCFCF;padding:15px;">
					<center>
					<s:form action="firstformedit" name="editformname" onsubmit="return editholderformfunc()">
					<table id="plantablid">
						<tr>
							<td>
							 	<s:select name="firstselectaccountnotext" id="selectbankholdid" list="bankaccntholdnames" label="Account No" onclick="callAccountInfoAjax()">
							 	</s:select>
							</td>
						</tr>
						<tr>
							<td>
							 	<s:textfield name="firstbankholdernames" id="firstbankholdernamesid" label="Account Holder" readonly="true"></s:textfield>
							</td>
						</tr>
						<tr>
							<td>
							 	<s:textfield name="firstamounttext" id="firstamounttextid" value="Rs." label="Balance Amount" readonly="true"></s:textfield>
							</td>
						</tr>
						<tr>
							<td>
							 	<s:textfield name="firstphonetext" id="firstphonetextid" onkeypress="return isNumberKey(event)" label="Mobile Number" readonly="true" maxlength="10"></s:textfield>
							</td>
						</tr>
						<tr>
							<td>
							 	<s:textfield name="firstmailtext" id="firstmailtextid" label="E Mail" readonly="true"></s:textfield>
							</td>
						</tr>
						<tr>
							<td>
							 	<s:textfield name="firstaddresstext" id="firstaddresstextid" label="Address" readonly="true"></s:textfield>
							</td>
						</tr>
						<tr>
							<td>
							 	<s:textfield name="firstcitytext" id="firstcitytextid" label="City" readonly="true" onblur="callAjaxPincode()"></s:textfield>
							</td>
						</tr>
						<tr>
							<td>
							 	<s:textfield name="firstpincodetext" id="firstpincodetextid" label="PinCode" readonly="true"></s:textfield>
							</td>
						</tr>
						<tr>
							<td>
							 	<s:textfield name="firststatetext" id="firststatetextid" label="State" readonly="true"></s:textfield>
							</td>
						</tr>
						<tr>
							<td></td>
							<td>
							 	<input style="margin-left:122px;" type="button" id="editbuttonfirst" name="editbutton" value="  Edit  " onclick="callAccountEditFunc()"/>
							 	<s:submit value="Submit" id="firstsubbut"></s:submit>
							</td>
						</tr>
					</table>
					</s:form>
					</center>	
				</div>
			</div> 
		</div>
		
		
		<div id="seconddiv">
			<div id="bodyLeftPan">
				<div style="border:1px solid #CFCFCF;padding:15px;">
		  			<center><label style="font-weight:bold;color:black;font:28px/28px Georgia,Times New Roman,Times,serif;">New Account Holder</label></center>
		  		</div>
  				<br/>
  				<center><label id="errorreportlab" style="font-weight:bold;color:red;text-align:center;letter-spacing:2px;">  		
		  		</label></center>
		  		<br/>
  				<div style="border:1px solid #CFCFCF;padding:15px;">
					<center>
					<s:form action="newholder" name="newholderform" onsubmit="return newholderformfunc()" >
					<table id="plantablid">
						<tr>
							<td>
							 	<s:textfield name="usernametext" label="Account Holder Name"></s:textfield>
							</td>
						</tr>
						
						<tr>
							<td>
							 	<s:textfield name="phonetext" label="Mobile Number" onkeypress="return isNumberKey(event)" maxlength="10"></s:textfield>
							</td>
						</tr>
						<tr>
							<td>
							 	<s:textfield name="emailtext" label="E-mail"></s:textfield>
							</td>
						</tr>
						<tr>
							<td>
							 	<s:textfield name="addresstext" label="Address"></s:textfield>
							</td>
						</tr>
						<tr>
							<td>
							 	<s:textfield name="citytext" id="tags" label="City" onblur="callAjaxPincode()"></s:textfield>
							</td>
						</tr>
						<tr>
							<td>
							 	<s:textfield name="pincodetext" id="pincodeid" label="PinCode" readonly="true"></s:textfield>
							</td>
						</tr>
						<tr>
							<td>
							 	<s:textfield name="statetext" id="stateid" label="State" readonly="true"></s:textfield>
							</td>
						</tr>
						<tr>
							<td></td>
							<td>
							 	<s:submit style="margin-left:83px;" name="editbutton" value="  Submit  "/>
							</td>
						</tr>
					</table>					
					</s:form>
					</center>
				</div>
			</div> 
		</div>
	</div>
	
	<div>
  		<div id="footerPan" style="padding:12px;">
			<center><p class="copyright">©Google zone. All right reserved.</p></center>  
		</div>
	</div>
</body>
</html>

