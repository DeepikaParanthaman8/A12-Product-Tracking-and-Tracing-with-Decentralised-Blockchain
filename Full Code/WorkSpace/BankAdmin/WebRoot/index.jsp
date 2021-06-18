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
	
	<script>
		$(document).ready(function()
		{
			$("#errorreportlab").hide();
		});
	</script>
	
	<script>
	function adminformfunc()
	{
		var username=document.adminlogform.adminusername.value;
		var pass=document.adminlogform.adminpassword.value;
		
		if(username=="" || pass=="")
		{
			$("#errorreportlab").fadeIn(700);
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
			<li class="home">Home</li>
			<li><a href="#"></a></li>
			<li><a href="#">NewUser</a></li>
			<li><a href="#"></a></li>
			<li><a href="#">History</a></li>		
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
  		<center><label style="font-weight:bold;color:black;font:28px/28px Georgia,Times New Roman,Times,serif;">Admin Login</label></center>
  		</div>
  		<br/>
  		<center><label id="errorreportlab" style="font-weight:bold;color:red;text-align:center;letter-spacing:2px;">  		
  		</label></center>
  		<br/>
  		<div style="border:1px solid #CFCFCF;padding:15px;">
			<center>
			<s:form action="banklogin" name="adminlogform" onsubmit="return adminformfunc()">
				<s:textfield name="adminusername" label="Username"></s:textfield>
				<s:password name="adminpassword" label="Password"></s:password>
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

