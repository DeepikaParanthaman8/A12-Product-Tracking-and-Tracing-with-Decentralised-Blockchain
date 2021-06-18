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
		});
		
		function callAmountInfoAjax()
		{
			var str=document.getElementById("selectaddamountid").value;
			makeRequest("addamountaccountholder?hidden=addamountholderaccount&key="+str);
		}
		
		function isNumberKey(evt)
		{
    		var charCode = (evt.which) ? evt.which : event.keyCode
   			if (charCode > 31 && (charCode < 48 || charCode > 57))
        		return false;
    			return true;
		}
		
	</script>
	
	<script>
	function adminformfunc()
	{
		var username=document.addamountform.firstbankholdernames.value;
		var amnttext=document.addamountform.firstamounttext.value;
		
		if(username=="" || amnttext=="")
		{
			$("#errorreportlab").fadeIn(600);
			document.getElementById('errorreportlab').innerHTML="Fields should not be empty.";
			return false;
		}
	}
	</script>
  </head>
  
  <body>
<div id="topPan">
	<center><img src="images/banklogo3.png" alt="Education Zone" border="0" width="350" height="130" style="margin-top:10px;" title="Education Zone"/></center>
	
	<div id="topContactPan">
  </div>
	<div id="topMenuPan">
	  <div id="topMenuLeftPan"></div>
	  
	  <div id="topMenuMiddlePan">
	  	<ul>
			<li class="home"><a href="toadminpage">Home</a></li>
			<li><a href="#"></a></li>
			<li><a href="#"></a></li>
			<li><a href="#"></a></li>
			<li><a href="#"></a></li>		
			<li><a href="#"></a></li>
			<li><a href="#"></a></li>			
			<li class="contact"><a href="#" class="contact">Contact</a></li>
		</ul>
	  </div>
	  <div id="topMenuRightPan"></div>
	</div>
</div>

<div id="bodyPan">
	<div id="bodyLeftPan">
	<div style="border:1px solid #CFCFCF;padding:15px;">
  		<center><label style="font-weight:bold;color:black;font:28px/28px Georgia,Times New Roman,Times,serif;">Add Amount</label></center>
  		</div>
  		<br/>
  		<center><label id="errorreportlab" style="font-weight:bold;color:red;text-align:center;letter-spacing:2px;">  		
  		</label></center>
  		<br/>
  		<div style="border:1px solid #CFCFCF;padding:15px;">
			<center>
			<s:form action="addamountholder" name="addamountform" onsubmit="return adminformfunc()">
				<s:select name="firstselectaccountnotext" id="selectaddamountid" list="bankaccntholdnames" label="Account No" onclick="callAmountInfoAjax()">
			 	</s:select>
				<s:textfield name="firstbankholdernames" id="addamountaccountnameid" label="Account Holder" readonly="true"></s:textfield>
				<s:textfield name="firstamounttext" label="Amount" onkeypress="return isNumberKey(event)"></s:textfield>
				<s:submit></s:submit>
			</s:form>
			<s:actionmessage/>
			</center>
			</div>
	</div> 
</div>
<div>
  <div id="footerPan" style="padding:10px;">
	<center><p class="copyright">©Google zone. All right reserved.</p></center>  
</div>
</div>
</body>
</html>

