
<%@page import="com.Dao.Dao"%>
<%@page import="java.util.List"%>
<%@page import="com.Controller.SupplierRegister"%>
<%@page import="com.Model.SupplierRegPojo"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Smart Bazaar an E-commerce Online Shopping Category
			Flat Bootstrap Responsive Website Template | Contact :: w3layouts</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="keywords"
			content="Smart Bazaar Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
SmartPhone Compatible web template, free WebDesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
		<script type="application/x-javascript">
addEventListener("load", function() {
	setTimeout(hideURLbar, 0);
}, false);
function hideURLbar() {
	window.scrollTo(0, 1);
}</script>
		<!-- Custom Theme files -->
		<link href="css/bootstrap.css" rel="stylesheet" type="text/css"
			media="all" />
		<link href="css/style.css" rel="stylesheet" type="text/css"
			media="all" />
		<link href="css/animate.min.css" rel="stylesheet" type="text/css"
			media="all" />
		<!-- animation -->
		<link href="css/menu.css" rel="stylesheet" type="text/css" media="all" />
		<!-- menu style -->
		<!-- //Custom Theme files -->
		<!-- font-awesome icons -->
		<link href="css/font-awesome.css" rel="stylesheet">
		<!-- //font-awesome icons -->
		<!-- js -->
		<script src="js/jquery-2.2.3.min.js">
</script>
		<script src="js/jquery-scrolltofixed-min.js" type="text/javascript">
</script>
		<!-- fixed nav js -->
		<script>
$(document).ready(function() {

	// Dock the header to the top of the window when scrolled past the banner. This is the default behaviour.

		$('.header-two').scrollToFixed();
		// previous summary up the page.

		var summaries = $('.summary');
		summaries.each(function(i) {
			var summary = $(summaries[i]);
			var next = summaries[i + 1];

			summary.scrollToFixed( {
				marginTop : $('.header-two').outerHeight(true) + 10,
				zIndex : 999
			});
		});
	});
</script>
		<!-- //js -->
		<!-- web-fonts -->

		<!-- web-fonts -->
		<!-- start-smooth-scrolling -->
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
		<!-- //end-smooth-scrolling -->
		<!-- smooth-scrolling-of-move-up -->
		<script type="text/javascript">
$(document).ready(function() {

	var defaults = {
		containerID : 'toTop', // fading element id
		containerHoverID : 'toTopHover', // fading element hover id
		scrollSpeed : 1200,
		easingType : 'linear'
	};

	$().UItoTop( {
		easingType : 'easeOutQuart'
	});

});
</script>
		<!-- //smooth-scrolling-of-move-up -->
		<link rel="stylesheet" href="css/Alreat.css" type="text/css"></link>
	</head>
	<body>
		<!-- header -->
		<div class="header">
			<div class="w3ls-header">
				<!--header-one-->
				<div class="w3ls-header-left">
					<p>
						<a href="#">UPTO $50 OFF ON LAPTOPS | USE COUPON CODE LAPPY </a>
					</p>
				</div>
				<div class="w3ls-header-right">
					<ul>
						<li class="dropdown head-dpdn">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown"><i
								class="fa fa-user" aria-hidden="true"></i> My Account<span
								class="caret"></span> </a>
							<ul class="dropdown-menu">
								<li>
									<a href="Logout">Logout</a>
								</li>
								
							</ul>
						</li>
					</ul>
				</div>
				<div class="clearfix">
				</div>
			</div>
			<div class="header-two">
				<!-- header-two -->

			</div>
			<!-- //header-two -->
			<div class="header-three">
				<!-- header-three -->
				<div class="container">
					<div class="menu">
						<div class="cd-dropdown-wrapper">
							<a class="cd-dropdown-trigger" href="#0">Store Categories</a>
							<nav class="cd-dropdown">
							<a href="#0" class="cd-close">Close</a>
							<ul class="cd-dropdown-content">
								<li>
									<li><a href="products.jsp">View Product</a></li>
								<li><a href="AddProductmanu.jsp">Add Product </a></li>
								<a href="manufactureRequest.jsp">Manufacturer Requested</a>
								</li>

								
							</ul>
							</nav>
						</div>
					</div>
					<div class="move-text">
						<div class="marquee">
							<a href="offers.html"> New collections are available
								here...... <span>Get extra 10% off on everything | no
									extra taxes </span> <span> Try shipping pass free for 15 days
									with unlimited</span> </a>
						</div>
						<script type="text/javascript" src="js/jquery.marquee.min.js">
</script>
						<script>
$('.marquee').marquee( {
	pauseOnHover : true
});
//@ sourceURL=pen.js
</script>
					</div>
				</div>
			</div>
		</div>
		<!-- //header -->
		<!-- contact-page -->
<script type="text/javascript">
function Random() {
  return Math.floor(Math.random() * 9999);
}

function randomValue() {
document.getElementById('tb').value = Random();
}
</script>
		<div class="contact">

			<div class="container" align="center">
				<%
				HttpSession session2 = request.getSession(false);
				String supid=(String)session2.getAttribute("supid");
				
				
					//String supid = (String) request.getAttribute("result");
					if (request.getAttribute("msg") != null) {
						String msg = (String) request.getAttribute("msg");
				%>
				<div class="alert">
					<span class="closebtn"
						onclick="this.parentElement.style.display='none';">&times;</span>
					<strong></strong>
					<%=msg%>
					<%
						}
					%>
				</div>
				<h3 class="w3ls-title w3ls-title1">
					Supplier Add Product
				</h3>
				<div class="contact-form-row">
					<%
						
						String supname = null;

						Dao dao = new Dao();
						List<SupplierRegPojo> list = dao.getSupplierDetails(supid);
						for (SupplierRegPojo pojo : list) {
							supname = pojo.getName();

						}
						System.out.print("------------>>" + supid);
					%>

					<form action="SupplierAddProduct" method="post"
						enctype="multipart/form-data">
						<input type="text" name="Sname" placeholder="SupplierName"
							required="" value="<%=supname%>" readonly="readonly">
						<input class="email" type="text" name="suplierid"
							placeholder="Supplier-ID" value="<%=supid%>" required=""
							readonly="readonly">
						<input type="text" name="proid" placeholder="Product_Id"
							required="" onclick="randomValue();" id="tb" readonly="readonly">
							
						<input class="email" type="text" name="productname"
							placeholder="ProductName" required="">
						<input type="text" name="des" placeholder="Description"
							required="">
						<input class="email" type="text" name="price" placeholder="Price"
							required="">
						<input type="text" name="quanity" placeholder="Quanity"
							required="">
						<%--<input class="email" type="file" name="pic" placeholder="PHOTO"required=" " accept="image/*">
						--%>
						<div align="center">
							<img id="blah" alt="Your Photo" width="70" height="70"
								class="email" />
							<br />
							<input type="file" class="email" name="pic"
								placeholder="Enter your evidance here...." required=""
								onchange="document.getElementById('blah').src = window.URL.createObjectURL(this.files[0])">
						</div>
						<input type="submit" value="SUBMIT">
					</form>


					<%--<textarea placeholder="Message" name="Message" required=""></textarea>
						--%>
					<%--<div class="col-md-4 contact-right">
					<div class="cnt-w3agile-row">
						<div class="col-md-3 contact-w3icon">
							<i class="fa fa-truck" aria-hidden="true"></i>
						</div>
						<div class="col-md-9 contact-w3text">
							<p>Manage Your Orders <br>Easily Track Orders & Returns </p> 
						</div>
						<div class="clearfix"> </div>
					</div>
					<div class="cnt-w3agile-row cnt-w3agile-row-mdl">
						<div class="col-md-3 contact-w3icon">
							<i class="fa fa-bell" aria-hidden="true"></i>
						</div>
						<div class="col-md-9 contact-w3text">
							<p>Notifications <br>Get Relevant Alerts & Recommendations</p> 
						</div>
						<div class="clearfix"> </div>
					</div>
					<div class="cnt-w3agile-row">
						<div class="col-md-3 contact-w3icon">
							<i class="fa fa-heart" aria-hidden="true"></i>
						</div>
						<div class="col-md-9 contact-w3text">
							<p>Requirements<br> With Wishlists, Reviews, Ratings</p> 
						</div>
						<div class="clearfix"> </div>
					</div>
				--%>
				</div>
				<div class="clearfix">
				</div>
			</div>
		</div>
		</div>
		<!-- //contact-page -->
		<!-- footer-top -->

		<!-- //footer-top -->
		<!-- subscribe -->
		<div class="subscribe">
			<div class="container">
				<div class="col-md-6 social-icons w3-agile-icons">
					<h4>
						Keep in touch
					</h4>
					<ul>
						<li>
							<a href="#" class="fa fa-facebook icon facebook"> </a>
						</li>
						<li>
							<a href="#" class="fa fa-twitter icon twitter"> </a>
						</li>
						<li>
							<a href="#" class="fa fa-google-plus icon googleplus"> </a>
						</li>
						<li>
							<a href="#" class="fa fa-dribbble icon dribbble"> </a>
						</li>
						<li>
							<a href="#" class="fa fa-rss icon rss"> </a>
						</li>
					</ul>
					<ul class="apps">
						<li>
							<h4>
								Download Our app :
							</h4>
						</li>
						<li>
							<a href="#" class="fa fa-apple"></a>
						</li>
						<li>
							<a href="#" class="fa fa-windows"></a>
						</li>
						<li>
							<a href="#" class="fa fa-android"></a>
						</li>
					</ul>
				</div>

				<div class="clearfix">
				</div>
			</div>
		</div>
		<!-- //subscribe -->
		<!-- footer -->
		<div class="footer">
			<div class="container">

			</div>
		</div>
		<!-- //footer -->
		<div class="copy-right">
			<div class="container">
				<p>
					© 2016 Smart bazaar . All rights reserved | Design by
					<a href="http://w3layouts.com"> W3layouts.</a>
				</p>
			</div>
		</div>
		<!-- cart-js -->
		<script src="js/minicart.js">
</script>
		<script>
w3ls.render();

w3ls.cart.on('w3sb_checkout', function(evt) {
	var items, len, i;

	if (this.subtotal() > 0) {
		items = this.items();

		for (i = 0, len = items.length; i < len; i++) {
			items[i].set('shipping', 0);
			items[i].set('shipping2', 0);
		}
	}
});
</script>
		<!-- //cart-js -->
		<!-- menu js aim -->
		<script src="js/jquery.menu-aim.js">
</script>
		<script src="js/main.js">
</script>
		<!-- Resource jQuery -->
		<!-- //menu js aim -->
		<!-- Bootstrap core JavaScript
    ================================================== -->
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="js/bootstrap.js">
</script>
	</body>
</html>