<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<!DOCTYPE html>
<html>
<head>
<title>Computer Peripherals a Ecommerce Online Shopping</title>
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Grocery Store Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //for-mobile-apps -->
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- font-awesome icons -->
<link href="css/font-awesome.css" rel="stylesheet" type="text/css" media="all" /> 
<!-- //font-awesome icons -->
<!-- js -->
<script src="js/jquery-1.11.1.min.js"></script>
<!-- //js -->
<!-- start-smoth-scrolling -->
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event){		
			event.preventDefault();
			$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
		});
	});
</script>
<!-- start-smoth-scrolling -->
<style type="text/css">
.filterDiv {
  display: none;
}

</style>
<style>
.alert {
	padding: 20px;
	background-color: black;
	color: white;
}

.closebtn {
	margin-left: 15px;
	color: white;
	font-weight: bold;
	float: right;
	font-size: 22px;
	line-height: 20px;
	cursor: pointer;
	transition: 0.3s;
}

.closebtn:hover {
	color: black;
}
</style>
<%
HttpSession session2=request.getSession(false);
String name=(String)session2.getAttribute("name");
String email=(String)session2.getAttribute("email");
%>
<link rel="stylesheet" href="css/shipment.css">
</head>
	
<body>
<!-- header -->
	<div class="agileits_header">
		<div class="w3l_offers">
			<a href="products.html">Dl-Tags..... !</a>
		</div>
<%--		<div class="w3l_search">--%>
<%--			<form action="#" method="post">--%>
<%--				<input type="text" name="Product" value="Search a product..." onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Search a product...';}" required="">--%>
<%--				<input type="submit" value=" ">--%>
<%--			</form>--%>
<%--		</div>--%>
		<div class="product_list_header" style="margin-left: 760px">  
                  <form method="get" action="buy.jsp">
                    <input type="submit" name="submit" value="Purchased Items" class="button"/>
                  </form>
		</div>
		<div class="w3l_header_right">
			<ul>
				<li class="dropdown profile_details_drop">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user" aria-hidden="true"></i><span class="caret"></span></a>
					<div class="mega-dropdown-menu">
						<div class="w3ls_vegetables">
							<ul class="dropdown-menu drp-mnu">
								<li><a href="Logout">Logout</a></li> 
							</ul>
						</div>                  
					</div>	
				</li>
			</ul>
		</div>
	
		<div class="clearfix"> </div>
	</div>
<!-- script-for sticky-nav -->
	<script>
	$(document).ready(function() {
		 var navoffeset=$(".agileits_header").offset().top;
		 $(window).scroll(function(){
			var scrollpos=$(window).scrollTop(); 
			if(scrollpos >=navoffeset){
				$(".agileits_header").addClass("fixed");
			}else{
				$(".agileits_header").removeClass("fixed");
			}
		 });
		 
	});
	</script>
<!-- //script-for sticky-nav -->
	<div class="logo_products">
		<div class="container">
			
			<div class="w3ls_logo_products_left1">
				<%--<ul class="phone_email">
					<li><i class="fa fa-phone" aria-hidden="true"></i>(+0123) 234 567</li>
					<li><i class="fa fa-envelope-o" aria-hidden="true"></i><a href="mailto:store@grocery.com">store@grocery.com</a></li>
				</ul>
				<%
						if (request.getAttribute("msg") != null) {
							String msg = (String) request.getAttribute("msg");
				%>
					<center>
						<div class="alert">
							<span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span>
							<strong><%=msg%></strong>
						</div>
					</center>
					<%
						}
					%>
			--%></div>
			<div class="clearfix"> </div>
		</div>
	</div>
<!-- //header -->
<!-- products-breadcrumb -->
	<div class="products-breadcrumb">
		<div class="container">
			<ul>
				<li><i class="fa fa-home" aria-hidden="true"></i><a href="menu.jsp">Home</a><span>|</span></li>
				<li>Welcome&nbsp;:-<label style="color: white;"><b>&nbsp;</b></label></li>
			</ul>
		</div>
	</div>
<!-- //products-breadcrumb -->
<!-- banner -->
	<div class="banner"><br/><br/><br/>
<center><h3><u><font style="font-size: 40px"><i>Order Status</i></font></u></h3></center>
		</div>
		<div class="w3l_banner_nav_right">
		
		
			<div class="w3ls_w3l_banner_nav_right_grid w3ls_w3l_banner_nav_right_grid_veg">
				<div class="w3ls_w3l_banner_nav_right_grid1 w3ls_w3l_banner_nav_right_grid1_veg"><br/>
				<br/><br/>
				

<%
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost/dltag", "root", "root");
			
			Statement st = connection.createStatement();
			String selectemo = "select * from shipment where Productid='"
					+ request.getParameter("id") + "'";
			ResultSet rs = st.executeQuery(selectemo);
			
			
			
			int manuid = 0, suppid = 0, cusid = 0, disid = 0;
			if (rs.next()) {

			
				
				manuid = rs.getInt("Manufacture");
				suppid = rs.getInt("Supplier");
				cusid = rs.getInt("Customer");
				disid = rs.getInt("Distributer");
			}
			
		
			
		%>

		<ol class="progtrckr" data-progtrckr-steps="4">

			<%
				if (suppid == 0) {
			%>
			<li class="progtrckr-todo">
				Supplier
			</li>
			<%
				} else {
			%>
			<li class="progtrckr-done">
				Supplier
			</li>
			<%
				}
			%>


			<%
				if (manuid == 0) {
			%>
			<li class="progtrckr-todo">
				Manufacture
			</li>
			<%
				} else {
			%>
			<li class="progtrckr-done">
				Manufacture
			</li>
			<%
				}
			%>

			<%
				if (disid == 0) {
			%>
			<li class="progtrckr-todo">
				Distributor
			</li>
			<%
				} else {
			%>
			<li class="progtrckr-done">
				Distributor
			</li>
			<%
				}
			%>

			<%
				if (cusid == 0) {
			%>
			<li class="progtrckr-todo">
				Customer
			</li>
			<%
				} else {
			%>
			<li class="progtrckr-done">
				Customer
			</li>
			<%
				}
			%>


		</ol>







									

<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>

					<div class="clearfix"> </div>
				</div>
			</div>
			
		<script type="text/javascript" src="js/cart.js"></script>
			
		</div>
		<div class="clearfix"></div>
	</div>
<!-- //banner -->
<!-- footer -->


<script type="text/javascript">
window.onload = function() {
	document.getElementById("myModal").style.display = "none";
}
var span = document.getElementsByClassName("close")[0];
span.onclick = function() {
	modal.style.display = "none";
}
</script>
		<script>
// Get the modal
var modal = document.getElementById('myModal');
// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];
// When the user clicks on <span> (x), close the modal
span.onclick = function() {
	modal.style.display = "none";
}
// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
	if (event.target == modal) {
		modal.style.display = "none";
	}
}
</script>
	<div class="footer">
		<div class="container">
			
		<center>
	<p style="color: white;">� 2018 Grocery Store. All rights reserved</p>
		
		</center>
			
		</div>
	</div>
<!-- //footer -->
<!-- Bootstrap Core JavaScript -->
<script src="js/bootstrap.min.js"></script>
<script>
$(document).ready(function(){
    $(".dropdown").hover(            
        function() {
            $('.dropdown-menu', this).stop( true, true ).slideDown("fast");
            $(this).toggleClass('open');        
        },
        function() {
            $('.dropdown-menu', this).stop( true, true ).slideUp("fast");
            $(this).toggleClass('open');       
        }
    );
});
</script>
<!-- here stars scrolling icon -->
	<script type="text/javascript">
		$(document).ready(function() {
			/*
				var defaults = {
				containerID: 'toTop', // fading element id
				containerHoverID: 'toTopHover', // fading element hover id
				scrollSpeed: 1200,
				easingType: 'linear' 
				};
			*/
								
			$().UItoTop({ easingType: 'easeOutQuart' });
								
			});
	</script>
<!-- //here ends scrolling icon -->
<script src="js/minicart.js"></script>
<script>
		paypal.minicart.render();

		paypal.minicart.cart.on('checkout', function (evt) {
			var items = this.items(),
				len = items.length,
				total = 0,
				i;

			// Count the number of each item in the cart
			for (i = 0; i < len; i++) {
				total += items[i].get('quantity');
			}

			if (total < 3) {
				alert('The minimum order quantity is 3. Please add more to your shopping cart before checking out');
				evt.preventDefault();
			}
		});

	</script>
	<script type="text/javascript">
$(document).ready(function() {
	$(chn).mouseover(function() {
		$(this).css('src', 'images/cat2.png');
	});
	$(chn).mouseout(function() {
		$(this).css('src', 'images/cat.png');
	});
});
</script>
</body>
</html>