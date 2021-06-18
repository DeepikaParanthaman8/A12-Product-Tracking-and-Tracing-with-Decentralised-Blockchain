
<%@page import="com.Dao.Dao"%>
<%@page import="java.util.List"%>
<%@page import="com.Model.AddProduct"%>
<%@page import="com.Model.RequestQuanity"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Smart</title>
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
		<link rel="stylesheet" href="css/table.css" type="text/css"></link>
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
									<a href="products.jsp">View Product</a>
								</li>
								<li>
									<a href="AddProductmanu.jsp">Add Product </a>
								</li>
								<li>
									<a href="manufactureRequest.jsp">Manufacture Request</a>
								</li>
							</ul>
							<!-- .cd-dropdown-content -->
							</nav>
							<!-- .cd-dropdown -->
						</div>
						<!-- .cd-dropdown-wrapper -->
					</div>
					<div class="move-text">
						<div class="marquee">
							<a href="#"> New collections are available
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
		<!-- values-page -->
		<div class="values">
			<div class="container">
				<h3 class="w3ls-title w3ls-title1">
					Core Values
				</h3>
				<table id="customers">
					<tr>
						<th>
							S_no
						</th>
						<th>
							Manufacture Name
						</th>
						<th>
							Suplier Id
						</th>
						<th>
							Product id
						</th>
						<th>
							Product Name
						</th>
						<th>
							Quanity
						</th>
						<th>
							Date&Time
						</th>
						<th>
							Status
						</th>
					</tr>

					<%
						HttpSession session2 = request.getSession(false);
						String supid = (String) session2.getAttribute("supid");
						System.out.print("S-id"+supid);
						Dao dao = new Dao();
						List<RequestQuanity> list = dao.getProductDetails(supid);
						for (RequestQuanity pojo : list) {
							
							System.out.print("==============>>>>>>"+supid);
					%>
					<tr>
						<td><%=pojo.getSno()%></td>
						<td><%=pojo.getManufacturename()%></td>
						<td><%=pojo.getSupplierid()%></td>
						<td><%=pojo.getProductid()%></td>
						<td><%=pojo.getProductname()%></td>
						<td><%=pojo.getQyanity()%></td>
						<td><%=pojo.getReqdate()%></td>

						<td>
							<a href="Accept?accept=<%=pojo.getSno()%>"><button
									style="background-color: green; color: white;">
									Accept
								</button> </a>
							<br />
							<form action="AcceptAndDecline" method="post">

								<input type="hidden" name="decline" value="<%=pojo.getSno()%>">
								<input type="submit" value="Decline"
									style="background-color: red; color: white;">
							</form>
						</td>

					</tr>

					<%
							}
					%>
				</table>


			</div>
		</div>
		<!-- //values-page -->
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