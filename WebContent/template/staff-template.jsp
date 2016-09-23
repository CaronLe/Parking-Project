<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html">
<meta content="charset=utf-8">

<title>Sinh viên</title>

<!-- Bootstrap Core CSS -->
<link href="<%=request.getContextPath()%>/Resources/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="<%=request.getContextPath()%>/Resources/metismenu/metisMenu.min.css"
	rel="stylesheet">

<!-- Custom CSS -->	
<link href="<%=request.getContextPath()%>/Resources/sb-admin-2/css/sb-admin-2.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="<%=request.getContextPath()%>/Resources/fonts/font-awesome/css/font-awesome.min.css" rel="stylesheet">


<!-- jQuery -->
<script src="<%=request.getContextPath()%>/Resources/jquery/jquery.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="<%=request.getContextPath()%>/Resources/bootstrap/js/bootstrap.min.js"></script>

<!-- jQuery Validation  -->
<script src="<%=request.getContextPath()%>/Resources/jquery-validation/jquery.validate.min.js"></script>

<!-- Metis Menu Plugin JavaScript -->
<script src="<%=request.getContextPath()%>/Resources/metismenu/metisMenu.min.js"></script>

<!-- Custom Theme JavaScript -->
<script src="<%=request.getContextPath()%>/Resources/sb-admin-2/js/sb-admin-2.js"></script>

<!--javascript-source attribute  -->
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
			<a class="navbar-brand" href="">NHÂN VIÊN</a>
		</div>
		<!-- /.navbar-header -->

		<ul class="nav navbar-top-links navbar-right">
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#"> <i class="fa fa-user fa-fw"></i>
					<i class="fa fa-caret-down"></i>
			</a>
				<ul class="dropdown-menu dropdown-user">
					<li><a href="#"><i class="fa fa-user fa-fw"></i> Thông tin
							cá nhân</a></li></li>
			<li class="divider"></li>
			<li><a href=""><i class="fa fa-sign-out fa-fw"></i> Đăng
					xuất</a></li>
		</ul>
		<!-- /.dropdown-user -->
		</li>
		<!-- /.dropdown -->
		</ul>
		<!-- /.navbar-top-links -->

		<div class="navbar-default sidebar" role="navigation">
			<div class="sidebar-nav navbar-collapse">
				<ul class="nav" id="side-menu">

					<li><a href=""> <i class="fa fa-table fa-fw"></i>Quản lý
							nhà xe
					</a></li>


					<li><a href=""> <i class="fa fa-table fa-fw"></i>Thống kê
					</a></li>

				</ul>
			</div>
			<!-- /.sidebar-collapse -->
		</div>
		<!-- /.navbar-static-side --> </nav>

		<!-- Page Content -->
		<div id="page-wrapper">
			<div class="container-fluid">
				<tiles:insertAttribute name="content"></tiles:insertAttribute>

				<!--  <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">Blank</h1>
                    </div>
                    <!-- /.col-lg-12 
                </div>  -->
				<!-- /.row -->
			</div>
			<!-- /.container-fluid -->
		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->



</body>
</html>