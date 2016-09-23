<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<tiles:insertTemplate template="../template/ad-template.jsp">
	<!-- DataTables CSS -->
	<link
		href="<%=request.getContextPath()%>/Resources/datatable-bootstrap/css/dataTables.bootstrap.css"
		rel="stylesheet" />

	<!-- DataTables Responsive CSS -->
	<link
		href="<%=request.getContextPath()%>/Resources/datatable-responsive/css/dataTables.responsive.css"
		rel="stylesheet" />

	<tiles:putAttribute name="header">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Sửa thông tin nhân viên</h1>
			</div>
			<!-- /.col-lg-12  -->
		</div>
	</tiles:putAttribute>

	<tiles:putAttribute name="body">
		<div class="row">
			<div class="col-lg-12" style="height: 70%">
				<form class="form-horizontal">
					<div class="form-group">
						<label class="control-label col-sm-2" style="text-align: left">Họ tên:</label>
						<div class="col-sm-10">
							<input type="text" name="hoten" class="form-control"
								placeholder="Họ tên">
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-2" style="text-align: left">Địa chỉ:</label>
						<div class="col-sm-10">
							<input type="text" name="diachi" class="form-control"
								placeholder="Địa chỉ">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" style="text-align: left">Số điện thoại:</label>
						<div class="col-sm-10">
							<input type="number" name="sodienthoai" class="form-control"
								placeholder="Số điện thoại">
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-2" style="text-align: left">Lương:</label>
						<div class="col-sm-10">
							<input type="number" name="luong" class="form-control"
								placeholder="Lương">
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-2" style="text-align: left">Tài khoản:</label>
						<div class="col-sm-10">
							<input type="text" name="taikhoan" class="form-control"
								placeholder="Tài khoản">
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-2" style="text-align: left">Mật khẩu:</label>
						<div class="col-sm-10">
							<input type="text" name="tieude" class="form-control"
								placeholder="Mật khẩu">
						</div>
					</div>
				</form>

			</div>
		</div>
	</tiles:putAttribute>

	<tiles:putAttribute name="footer">
		<div class="row">
			<div class="col-lg-12">
				<button type="button" class="btn btn-info">Lưu</button>
				<button type="button" class="btn btn-info">Quay lại</button>
			</div>
		</div>
	</tiles:putAttribute>
	<tiles:putAttribute name="javascript-source">

	</tiles:putAttribute>


</tiles:insertTemplate>