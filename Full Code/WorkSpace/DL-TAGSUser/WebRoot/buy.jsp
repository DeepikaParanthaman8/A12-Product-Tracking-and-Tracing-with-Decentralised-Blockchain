<%@page import="java.util.List"%>
<%@page import="blockchain.UserDao"%>
<%@page import="blockchain.ProductsBean"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Grocery Store a Ecommerce Online Shopping</title>
		<!-- for-mobile-apps -->
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="keywords"
			content="Grocery Store Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
		<script type="application/x-javascript">
addEventListener("load", function() {
	setTimeout(hideURLbar, 0);
}, false);
function hideURLbar() {
	window.scrollTo(0, 1);
}</script>
		<!-- //for-mobile-apps -->
		<link href="css/bootstrap.css" rel="stylesheet" type="text/css"
			media="all" />
		<link href="css/style.css" rel="stylesheet" type="text/css"
			media="all" />
		<!-- font-awesome icons -->
		<link href="css/font-awesome.css" rel="stylesheet" type="text/css"
			media="all" />
		<!-- //font-awesome icons -->
		<!-- js -->
		<script src="js/jquery-1.11.1.min.js">
</script>
		<!-- //js -->
		<script src='js/okzoom.js'>
</script>
		<script>
$(function() {
	$('#example').okzoom( {
		width : 150,
		height : 150,
		border : "1px solid black",
		shadow : "0 0 5px #000"
	});
});
</script>
		<!-- start-smoth-scrolling -->
		<script type="text/javascript" src="js/move-top.js">
</script>
		<script type="text/javascript" src="js/easing.js">
</script>
		<script type="text/javascript">
jQuery(document).ready(function($) {
	$(".scroll").click(function(event) {
		event.preventDefault();
		$('html,body').animate( {
			scrollTop : $(this.hash).offset().top
		}, 1000);
	});
});
</script>
		<!-- start-smoth-scrolling -->
		<%
			HttpSession session2 = request.getSession(false);
			String name = (String) session2.getAttribute("name");
			String email = (String) session2.getAttribute("email");
			String aid = request.getParameter("aid");
			String pname = request.getParameter("pname");
			String pprice = request.getParameter("pprice");
			String image = request.getParameter("image");
			String qrcode = request.getParameter("qrcode");
			String d = request.getParameter("d");
			String quanity=request.getParameter("quanity");

			System.out.print("===============>>>>>" + qrcode);
			UserDao userDao = new UserDao();
		%>
		<style type="text/css">
.filterDiv {
	display: none;
}
</style>
	</head>

	<body>
		<!-- header -->
		<div class="agileits_header">
			<div class="w3l_offers">
				<a href="#">DL-Tags...!</a>
			</div>
			<%--		<div class="w3l_search">--%>
			<%--			<form action="#" method="post">--%>
			<%--				<input type="text" name="Product" value="Search a product..." onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Search a product...';}" required="">--%>
			<%--				<input type="submit" value=" ">--%>
			<%--			</form>--%>
			<%--		</div>--%>
			<div class="product_list_header" style="margin-left: 760px">
				<input type="submit" name="submit" value="View your cart"
					class="button" readonly="readonly" />
			</div>
			<div class="w3l_header_right">
				<ul>
					<li class="dropdown profile_details_drop">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown"><i
							class="fa fa-user" aria-hidden="true"></i><span class="caret"></span>
						</a>
						<div class="mega-dropdown-menu">
							<div class="w3ls_vegetables">
								<ul class="dropdown-menu drp-mnu">
									<li>
										<a href="Logout">Logout</a>
									</li>
								</ul>
							</div>
						</div>
					</li>
				</ul>
			</div>

			<div class="clearfix">
			</div>
		</div>
		<!-- script-for sticky-nav -->
		<script>
$(document).ready(function() {
	var navoffeset = $(".agileits_header").offset().top;
	$(window).scroll(function() {
		var scrollpos = $(window).scrollTop();
		if (scrollpos >= navoffeset) {
			$(".agileits_header").addClass("fixed");
		} else {
			$(".agileits_header").removeClass("fixed");
		}
	});

});
</script>
		<!-- //script-for sticky-nav -->
		<div class="logo_products">
			<div class="container">

				<div class="w3ls_logo_products_left1">

					<%
						if (request.getAttribute("msg") != null) {
							String msg = (String) request.getAttribute("msg");
					%>
					<center>
						<div class="alert">
							<span class="closebtn"
								onclick="this.parentElement.style.display='none';">&times;</span>
							<strong><%=msg%></strong>
						</div>
					</center>
					<%
						}
					%>
				</div>
				<div class="clearfix">
				</div>
			</div>
		</div>
		<!-- //header -->
		<!-- products-breadcrumb -->
		<div class="products-breadcrumb">
			<div class="container">
				<ul>
					<li>
						<i class="fa fa-home" aria-hidden="true"></i><a href="menu.jsp">Home</a><span>|</span>
					</li>
					<li>
						Welcome&nbsp;:-
						<label style="color: white;">
							<b>&nbsp;<%=name%></b>
						</label>
					</li>
				</ul>
			</div>
		</div>
		<!-- //products-breadcrumb -->
		<!-- banner -->
		<div class="banner">
			<div class="w3l_banner_nav_right">



				<div class="agileinfo_single">
					<h5><%=pname%></h5>
					<div class="col-md-4 agileinfo_single_left"
						style="height: 270px; width: 200px;">
						<br />
						<img id="example"
							src="http://localhost:8888/<%=image.replace("webapps", "")%>"
							alt=" " class="img-responsive" />
					</div>
					<div class="col-md-8 agileinfo_single_right">

						<div class="w3agile_description">
							<h4>
								Description
							</h4>
							<p>
								<b>Product Name :</b>
								<%=pname%></p>
								<p>
								<b>Product ID :</b>
								<%=aid%></p>
							<img
								src="http://localhost:8888/<%=qrcode.replace("webapps", "")%>"
								style="height: 70px; width: 70px" />
						</div>
						<div class="snipcart-item block">
							<div class="snipcart-thumb agileinfo_single_right_snipcart">
								<h4 id="pris">
									Rs.<%=pprice%>
									<label>
										&nbsp;&nbsp;&nbsp;Quantity:
										<input type="number" min="1" max="<%=quanity%>" value="1"
											style="width: 40px" id="sel">
									</label>
								</h4>

							</div>
							<div class="snipcart-details agileinfo_single_right_details">

								<%--					<input type="submit" name="submit" value="Add to cart" class="button" onclick="sendInfo('<%=pid %>','<%=pname %>', '<%=price %>', '<%=image %>')"/>&nbsp;--%>
								<form action="checkout1.jsp" method="post">

									<input type="hidden" name="aid" value="<%=aid%>">
									<input type="hidden" name="pname" value="<%=pname%>">
									<input type="hidden" name="pprice" value="<%=pprice%>">
									<input type="hidden" name="quantity" id="q">
									<input type="hidden" name="image" value="<%=image%>">
									<input type="hidden" name="d" value="<%=d%>">
									<input type="submit" name="submit" value="Buy Now"
										class="button" style="background-color: #D2691E" id="hi"
										onclick="callD()" />
								</form>
								<script type="text/javascript">
function callD() {
	var a = document.getElementById('sel').value;
	var b
=<%=pprice%>;
						document.getElementById('q').value=a;
						document.getElementById('p').value=(a*b);
					}
					
					</script>
							</div>
						</div>
					</div>
					<div class="clearfix">
					</div>
				</div>
			</div>
			<div class="clearfix"></div>
		</div>
		<!-- //banner -->
		<!-- footer -->
		<script type="text/javascript" src="js/cart.js">
</script>
		<div id="myModal" class="modal1">

			<!-- Modal content -->
			<div class="modal1-content">
				<div class="modal1-header">
					<span class="close">&times;</span>
					<center>
						<h2>
							Cart
						</h2>
					</center>
				</div>
				<div class="modal1-body">

					<table class="timetable_sub">
						<thead id="tabs">
							<tr>
								<th>
									SL No.
								</th>
								<th>
									Product
								</th>
								<th>
									Quantity
								</th>
								<th>
									Product Name
								</th>
								<th>
									Price
								</th>
								<th>
									Remove
								</th>
							</tr>
						</thead>
						<tbody id="mylocation">

						</tbody>

					</table>
				</div>
				<div class="modal1-footer" id="f">
					<h3 style="color: black; margin-left: 450px">
						<b>Total :</b>
						<label id="pri" style="color: white;"></label>
					</h3>
				</div>
			</div>

		</div>
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
					<p style="color: white">
						© 2018 Grocery Store. All rights reserved
					</p>
				</center>
			</div>
		</div>
		<!-- //footer -->
		<!-- Bootstrap Core JavaScript -->
		<script src="js/bootstrap.min.js">
</script>
		<script>
$(document).ready(function() {
	$(".dropdown").hover(function() {
		$('.dropdown-menu', this).stop(true, true).slideDown("fast");
		$(this).toggleClass('open');
	}, function() {
		$('.dropdown-menu', this).stop(true, true).slideUp("fast");
		$(this).toggleClass('open');
	});
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

	$().UItoTop( {
		easingType : 'easeOutQuart'
	});

});
</script>
		<!-- //here ends scrolling icon -->
		<script src="js/minicart.js">
</script>
		<script>
paypal.minicart.render();

paypal.minicart.cart
		.on(
				'checkout',
				function(evt) {
					var items = this.items(), len = items.length, total = 0, i;

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
	$(hi).mouseover(function() {
		$(this).css('background-color', 'mediumvioletred');
	});
	$(hi).mouseout(function() {
		$(this).css('background-color', '#D2691E');
	});
});
</script>
	</body>
</html>