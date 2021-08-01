
<%@page import="com.Dao.Dao"%>
<%@page import="java.util.List"%>
<%@page import="com.Modul.ManufactureInven"%>
<%@page import="com.dis.modul.DisPojo"%>
<%@page import="com.Dao.UserDao"%><!DOCTYPE HTML>
<html>
<head>
<title>Gretong</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Gretong Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel='stylesheet' type='text/css' />
<!-- Custom CSS -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<!-- Graph CSS -->
<link href="css/font-awesome.css" rel="stylesheet"> 
<!-- jQuery -->
<!-- lined-icons -->
<link rel="stylesheet" href="css/icon-font.min.css" type='text/css' />
<script src="js/simpleCart.min.js"> </script>
<script src="js/amcharts.js"></script>	
<script src="js/serial.js"></script>	
<script src="js/light.js"></script>	
<!-- //lined-icons -->
<script src="js/jquery-1.10.2.min.js"></script>
   <!--pie-chart--->
<script src="js/pie-chart.js" type="text/javascript"></script>
 <script type="text/javascript">
        $(document).ready(function () {
            $('#demo-pie-1').pieChart({
                barColor: '#3bb2d0',
                trackColor: '#eee',
                lineCap: 'round',
                lineWidth: 8,
                onStep: function (from, to, percent) {
                    $(this.element).find('.pie-value').text(Math.round(percent) + '%');
                }
            });

            $('#demo-pie-2').pieChart({
                barColor: '#fbb03b',
                trackColor: '#eee',
                lineCap: 'butt',
                lineWidth: 8,
                onStep: function (from, to, percent) {
                    $(this.element).find('.pie-value').text(Math.round(percent) + '%');
                }
            });

            $('#demo-pie-3').pieChart({
                barColor: '#ed6498',
                trackColor: '#eee',
                lineCap: 'square',
                lineWidth: 8,
                onStep: function (from, to, percent) {
                    $(this.element).find('.pie-value').text(Math.round(percent) + '%');
                }
            });

           
        });
    </script>
<link rel="stylesheet" href="css/Table.css" type="text/css"></link></head> 
<body>
<%
HttpSession session2=request.getSession(false);
String name=(String)session2.getAttribute("name");
String email=(String)session2.getAttribute("email");
String did=(String)session2.getAttribute("did");
%>
   <div class="page-container">
   <!--/content-inner-->
	<div class="left-content">
	   <div class="inner-content">
		<!-- header-starts -->
			<div class="header-section">
			<!-- top_bg -->
						<div class="top_bg">
								<div class="header_top">
									<div class="top_right">
										<ul>
											<li><a href="contact.html">help</a></li>|
											<li><a href="contact.html">Contact</a></li>|
											<li><a href="checkout.html">Delivery information</a></li>
										</ul>
									</div>
									<div class="top_left">
										<h2><span></span> Call us : 032 2352 782</h2>
									</div>
										<div class="clearfix"> </div>
								</div>
						</div>
					<div class="clearfix"></div>
				<!-- /top_bg -->
				</div>
				<div class="header_bg">
							<div class="header">
								<div class="head-t">
									<div class="logo">
										<a href="index.html"><img src="images/logo.png" class="img-responsive" alt=""> </a>
									</div>
										<!-- start header_right -->
									<div class="header_right">
										<div class="rgt-bottom">
											<div class="log">
												<div class="login">
													
												</div>
											</div>
											
										
										<div class="create_btn">
											<a href="Logout">CHECKOUT</a>
										</div>
										<div class="clearfix"> </div>
									</div>
									
									<div class="clearfix"> </div>
								</div>
								<div class="clearfix"> </div>
							</div>
						</div>
				</div>
					<!-- //header-ends -->
				<!--content-->
			<div class="content">
				<div class="women_main">
						<!-- start content -->
								<div class="tab-main">
									<!--/tabs-inner-->
										<div class="tab-inner">
											<div id="tabs" class="tabs">
												<h2 class="inner-tittle">Responsive Horizontal Tabs </h2>
													<table id="customers">
     <%
UserDao userDao=new UserDao();
List<DisPojo> lists=userDao.loadDistributorRequests(did);
if(!lists.isEmpty()){%>
     <table id="customers">

											<thead>
												<tr>
													<th>
														S.No
													</th>
													<th>Manufacturer</th>
													<th>
														Product Id
													</th>
													<th>
														Product Name
													</th>
													<th>
														Price
													</th>
													
													<th>Quantity</th>
													<th>Total</th>
													<th>Date & Time</th>
													<th>Distributor Price</th>
													
												</tr>
											</thead>
<%
							int i = 1;
								for (DisPojo disPojo : lists) {
									if (Integer.parseInt(disPojo.getDistributorPrice()) == 0
											& disPojo.getStatus().equals("Approved")) {
										int to=Integer.parseInt(disPojo.getPrice()) * Integer.parseInt(disPojo.getQuanity());
										
						%>										
<tbody>
	<tr>
	<td><%=i %>.</td>
	<td><%=disPojo.getManufacturer() %></td>
	<td><%=disPojo.getProductId() %></td>
	<td><%=disPojo.getProductName() %></td>
	<td><%=disPojo.getPrice() %></td>
	<td><%=disPojo.getQuanity()%></td>
	<td><%=to%></td>
	<td><%=disPojo.getDateTime() %></td>
	<td>
	<form method="post" action="DisPrice">
		<input type="hidden" value="<%=disPojo.getProductId() %>" name="pid">
		<input type="number"  name="dprice" onkeyup="validate(<%=to%>,this.value,document.getElementById('<%=disPojo.getProductId()%>'))" min="1" maxlength="<%=to %>"/>
		<input type="hidden" value="<%=disPojo.getProductName() %>" name="panme"/>
		<input type="hidden" value="<%=disPojo.getDateTime() %>" name="date">
		<input type="hidden" value="<%=disPojo.getManufacturer() %>" name="man">
		<input type="hidden" value="<%=disPojo.getPrice() %>" name="price">
		<input type="hidden" value="<%=disPojo.getImage() %>" name="image">
		<input type="submit" id="<%=disPojo.getProductId()%>" value="PAY" style="background-color:#3aa9af;color: white;">
	</form>
	</td>
	</tr>										
</tbody>
<%
							}
									i++;
								}
						%>
					</table>
					<%
						} else {
					%>
					<label>
						There is no products found
					</label>
					<%
						}
					%>
					
					
					
								

												<!-- /tabs -->
											</div>
										<script src="js/cbpFWTabs.js"></script>
									<script>
										new CBPFWTabs( document.getElementById( 'tabs' ) );
									</script>
									
									
				<script>
function validate(quan, val, but) {

	if (val < parseInt(quan)) {
		but.style.display = "none";
		//document.getElementById("Submit").style.display = "none";
	} else {
		but.style.display = "block";
		//document.getElementById("Submit").style.display = "block";
	}

}
</script>							
										<div class="clearfix"> </div>
								</div>
							</div>
	<!-- end content -->
	
		
</div>
</div>
			<!--content-->
		</div>
</div>
				<!--//content-inner-->
			<!--/sidebar-menu-->
				<div class="sidebar-menu">
					<header class="logo1">
						<a href="#" class="sidebar-icon"> <span class="fa fa-bars"></span> </a> 
					</header>
						<div style="border-top:1px ridge rgba(255, 255, 255, 0.15)"></div>
                         <div class="menu">
									<ul id="menu" >
										<li><a href="dmenu.jsp"><i class="fa fa-tachometer"></i> <span>Home</span></a></li>
										 
										 <li id="menu-academico" ><a href="dpros.jsp"><i class="fa fa-file-text-o"></i> <span>Distributor Products</span></a></li>
									<li><a href="#"><i class="lnr lnr-pencil"></i> <span>CONSUMER REQUEST</span></a></li>
									<li id="menu-academico" ><a href="#"><i class="fa fa-file-text-o"></i> <span>Distributor</span></a></li>
									<li id="menu-academico" ><a href="dshipment.jsp"><i class="lnr lnr-book"></i> <span>Shipment</span></a></li>
									
								  </ul>
								</div>
							  </div>
							  <div class="clearfix"></div>	
							</div>
							<script>
							var toggle = true;
										
							$(".sidebar-icon").click(function() {                
							  if (toggle)
							  {
								$(".page-container").addClass("sidebar-collapsed").removeClass("sidebar-collapsed-back");
								$("#menu span").css({"position":"absolute"});
							  }
							  else
							  {
								$(".page-container").removeClass("sidebar-collapsed").addClass("sidebar-collapsed-back");
								setTimeout(function() {
								  $("#menu span").css({"position":"relative"});
								}, 400);
							  }
											
											toggle = !toggle;
										});
							</script>
<!--js -->
<script src="js/jquery.nicescroll.js"></script>
<script src="js/scripts.js"></script>
<!-- Bootstrap Core JavaScript -->
   <script src="js/bootstrap.min.js"></script>
   <!-- /Bootstrap Core JavaScript -->
   <!-- real-time -->
<script language="javascript" type="text/javascript" src="js/jquery.flot.js"></script>
	<script type="text/javascript">
	$(function() {

		// We use an inline data source in the example, usually data would
		// be fetched from a server

		var data = [],
			totalPoints = 300;

		function getRandomData() {

			if (data.length > 0)
				data = data.slice(1);

			// Do a random walk

			while (data.length < totalPoints) {

				var prev = data.length > 0 ? data[data.length - 1] : 50,
					y = prev + Math.random() * 10 - 5;

				if (y < 0) {
					y = 0;
				} else if (y > 100) {
					y = 100;
				}

				data.push(y);
			}

			// Zip the generated y values with the x values

			var res = [];
			for (var i = 0; i < data.length; ++i) {
				res.push([i, data[i]])
			}

			return res;
		}

		// Set up the control widget

		var updateInterval = 30;
		$("#updateInterval").val(updateInterval).change(function () {
			var v = $(this).val();
			if (v && !isNaN(+v)) {
				updateInterval = +v;
				if (updateInterval < 1) {
					updateInterval = 1;
				} else if (updateInterval > 2000) {
					updateInterval = 2000;
				}
				$(this).val("" + updateInterval);
			}
		});

		var plot = $.plot("#placeholder", [ getRandomData() ], {
			series: {
				shadowSize: 0	// Drawing is faster without shadows
			},
			yaxis: {
				min: 0,
				max: 100
			},
			xaxis: {
				show: false
			}
		});

		function update() {

			plot.setData([getRandomData()]);

			// Since the axes don't change, we don't need to call plot.setupGrid()

			plot.draw();
			setTimeout(update, updateInterval);
		}

		update();

		// Add the Flot version string to the footer

		$("#footer").prepend("Flot " + $.plot.version + " &ndash; ");
	});

	</script>
<!-- /real-time -->
<script src="js/jquery.fn.gantt.js"></script>
    <script>
		$(function() {

			"use strict";

			$(".gantt").gantt({
				source: [{
					name: "Sprint 0",
					desc: "Analysis",
					values: [{
						from: "/Date(1320192000000)/",
						to: "/Date(1322401600000)/",
						label: "Requirement Gathering", 
						customClass: "ganttRed"
					}]
				},{
					name: " ",
					desc: "Scoping",
					values: [{
						from: "/Date(1322611200000)/",
						to: "/Date(1323302400000)/",
						label: "Scoping", 
						customClass: "ganttRed"
					}]
				},{
					name: "Sprint 1",
					desc: "Development",
					values: [{
						from: "/Date(1323802400000)/",
						to: "/Date(1325685200000)/",
						label: "Development", 
						customClass: "ganttGreen"
					}]
				},{
					name: " ",
					desc: "Showcasing",
					values: [{
						from: "/Date(1325685200000)/",
						to: "/Date(1325695200000)/",
						label: "Showcasing", 
						customClass: "ganttBlue"
					}]
				},{
					name: "Sprint 2",
					desc: "Development",
					values: [{
						from: "/Date(1326785200000)/",
						to: "/Date(1325785200000)/",
						label: "Development", 
						customClass: "ganttGreen"
					}]
				},{
					name: " ",
					desc: "Showcasing",
					values: [{
						from: "/Date(1328785200000)/",
						to: "/Date(1328905200000)/",
						label: "Showcasing", 
						customClass: "ganttBlue"
					}]
				},{
					name: "Release Stage",
					desc: "Training",
					values: [{
						from: "/Date(1330011200000)/",
						to: "/Date(1336611200000)/",
						label: "Training", 
						customClass: "ganttOrange"
					}]
				},{
					name: " ",
					desc: "Deployment",
					values: [{
						from: "/Date(1336611200000)/",
						to: "/Date(1338711200000)/",
						label: "Deployment", 
						customClass: "ganttOrange"
					}]
				},{
					name: " ",
					desc: "Warranty Period",
					values: [{
						from: "/Date(1336611200000)/",
						to: "/Date(1349711200000)/",
						label: "Warranty Period", 
						customClass: "ganttOrange"
					}]
				}],
				navigate: "scroll",
				scale: "weeks",
				maxScale: "months",
				minScale: "days",
				itemsPerPage: 10,
				onItemClick: function(data) {
					alert("Item clicked - show some details");
				},
				onAddClick: function(dt, rowId) {
					alert("Empty space clicked - add an item!");
				},
				onRender: function() {
					if (window.console && typeof console.log === "function") {
						console.log("chart rendered");
					}
				}
			});

			$(".gantt").popover({
				selector: ".bar",
				title: "I'm a popover",
				content: "And I'm the content of said popover.",
				trigger: "hover"
			});

			prettyPrint();

		});
    </script>
		   <script src="js/menu_jquery.js"></script>
</body>
</html>