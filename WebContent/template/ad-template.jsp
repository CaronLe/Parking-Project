<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html">
<meta content="charset=utf-8">

<title>Quản lý nhà xe (Admin)</title>

<!-- Bootstrap Core CSS -->
<link
	href="<%=request.getContextPath()%>/Resources/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
	
	<link
	href="<%=request.getContextPath()%>/Resources/bootstrap/css/template.css"
	rel="stylesheet">

<!-- MetisMenu CSS -->
<link
	href="<%=request.getContextPath()%>/Resources/metismenu/metisMenu.min.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link
	href="<%=request.getContextPath()%>/Resources/sb-admin-2/css/sb-admin-2.css"
	rel="stylesheet">

<!-- Custom Fonts -->
<link
	href="<%=request.getContextPath()%>/Resources/fonts/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">
<script
		src="<%=request.getContextPath()%>/Resources/jquery/jquery.min.js"></script>
<tiles:insertAttribute name="javascript-source"></tiles:insertAttribute>
</head>
<body>
	<div id="wrapper">

		<!-- Navigation -->
		<nav class="navbar navbar-default navbar-static-top" role="navigation"
			style="margin-bottom: 0">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="">ADMIN</a>
		</div>
		<!-- /.navbar-header -->

		<ul class="nav navbar-top-links navbar-right">
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#"> <i class="fa fa-user fa-fw"></i>
					<i class="fa fa-caret-down"></i>
			</a>
				<ul class="dropdown-menu dropdown-user">
					<li><a href="#"><i class="fa fa-user fa-fw"></i> Thông tin cá nhân</a></li>
					</li>
					<li class="divider"></li>
					<li><a href="doLogout" action = "post"><i class="fa fa-sign-out fa-fw"></i>
							Đăng xuất</a></li>
				</ul> <!-- /.dropdown-user --></li>
			<!-- /.dropdown -->
		</ul>
		<!-- /.navbar-top-links -->

		<div class="navbar-default sidebar" role="navigation">
			<div class="sidebar-nav navbar-collapse">
				<ul class="nav" id="side-menu">
			
					<li><a href="<%=request.getContextPath()%>/NhanVienServlet">
						<i class="fa fa-table fa-fw"></i>Quản lý nhân viên</a>
					</li>
					
					<li><a href="#">
						<i class="fa fa-table fa-fw"></i>Quản lý nhà xe<span class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a href="<%=request.getContextPath()%>/admin/QLThoiGianDongMoCua.jsp">Thời gian Đóng/ Mở cửa</a></li>
							<li><a href="SoLuongXeServlet">Số lượng xe</a></li>
							<li><a href="<%=request.getContextPath()%>/admin/QLGiaVe.jsp">Giá vé</a></li>
						</ul> <!-- /.nav-second-level -->
					</li>
					
					<li><a href="">
						<i class="fa fa-table fa-fw"></i>Thống kê<span class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a href="<%=request.getContextPath()%>/admin/ThongKeNhaXe1.jsp">Nhà xe 1</a></li>
							<li><a href="<%=request.getContextPath()%>/admin/ThongKeNhaXe2.jsp">Nhà xe 2</a></li>
							<li><a href="<%=request.getContextPath()%>/admin/ThongKeNhaXe3.jsp">Nhà xe 3</a></li>
						</ul> <!-- /.nav-second-level -->
					</li>
					
				</ul>
			</div>
			<!-- /.sidebar-collapse -->
		</div>
		<!-- /.navbar-static-side --> </nav>
	
		<div id="page-wrapper">
			<div class="container-fluid" style="height: 500px;">
			<div style="height:15%; ">
				<tiles:insertAttribute name="header"/> 
			</div>
			<div style="height:60%;" >
				<tiles:insertAttribute name="body"/>
			</div>
			<div style="height:15%; text-align: center">
				<tiles:insertAttribute name="footer"/>
			</div>
		</div>
		
	<!-- jQuery -->
	

	<!-- Bootstrap Core JavaScript -->
	<script
		src="<%=request.getContextPath()%>/Resources/bootstrap/js/bootstrap.min.js"></script>
		
	<!-- jQuery Validation  -->
	<script src="<%=request.getContextPath()%>/Resources/jquery-validation/jquery.validate.min.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script
		src="<%=request.getContextPath()%>/Resources/metismenu/metisMenu.min.js"></script>

	<!-- Custom Theme JavaScript -->
	<script
		src="<%=request.getContextPath()%>/Resources/sb-admin-2/js/sb-admin-2.js"></script>
		
	<!--javascript-source attribute  -->
	
</body>
</html>