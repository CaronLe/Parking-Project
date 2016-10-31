<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Hệ thống quản lý nhà xe Đại Học Bách Khoa Đà Nẵng</title>

<!-- Bootstrap Core CSS -->
<link
	href="<%=request.getContextPath()%>/Resources/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom Fonts -->
<link
	href="<%=request.getContextPath()%>/Resources/fonts/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">

<!--Datetime picker css  -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/Resources/bootstrap-datetimepicker-master/css/bootstrap-datetimepicker.min.css" />

</head>
<body>
	<!-- Banner  -->
	<div class="container">
		<div style="background-color: #2a710d; color: white" class="jumbotron">
			<!-- 		 #337ab7   -->
			<div class="row">
				<div class="col-md-2">
					<img width="140px" height="140px" alt=""
						src="<%=request.getContextPath()%>/Resources/images/default/12.png">
				</div>
				<div class="" style="align: center">
					<h4>THÀNH PHỐ ĐÀ NẴNG</h4>
					<p
						style="color: #FFFF49; font-size: 40px; font-family: Times New Roman; font-weight: bold;">
						DỊCH VỤ CUNG CẤP THÔNG TIN BÃI ĐỖ XE</p>
				</div>
			</div>
		</div>
	</div>
	<br />
	<br />
	<!-- Page Content -->
	<div class="container">
		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-4">
				<div class="well">
					<form class="form-login" role="form" action="#" method="post">
						<h3 class="title">Vui lòng nhập email</h3>
						<div class="form-group">
							<input name="email" type="text"
								class="form-control input-sm chat-input"
								placeholder="Email" />
						</div>
						<button class="btn btn-sm btn-primary btn-block" type="submit">Submit</button>
					</form>
				</div>

				<!-- 				<div class="well"> -->
				<!-- 					<div class="panel panel-default"> -->
				<!-- 						<div class="panel-body"> -->
				<!-- 							<div class="date"></div> -->
				<!-- 						</div> -->
				<!-- 					</div> -->
				<!-- 				</div> -->

			</div>

		</div>
		<!-- /.row -->

	</div>

	<!-- jQuery -->
	<script src="/Resources/jquery/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="/Resources/bootstrap/js/bootstrap.min.js"></script>

	<!--Datetime picker js  -->
	<script type="text/javascript"
		src="/Resources/bootstrap-datetimepicker-master/js/bootstrap-datetimepicker.js"></script>

	<script type="text/javascript"
		src="/Resources/bootstrap-datetimepicker-master/js/locales/bootstrap-datetimepicker.vi.js"></script>
</body>
</html>