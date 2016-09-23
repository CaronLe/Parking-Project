<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<tiles:insertTemplate template="../template/ad-template.jsp">
	<!-- DataTables CSS -->
	<link
		href="<%=request.getContextPath()%>/Resources/datatable-bootstrap/css/dataTables.bootstrap.css"
		rel="stylesheet" />
	<link
		href="<%=request.getContextPath()%>/Resources/bootstrap/css/bootstrap.theme.min.css"
		rel="stylesheet" />

	<!-- DataTables Responsive CSS -->
	<link
		href="<%=request.getContextPath()%>/Resources/datatable-responsive/css/dataTables.responsive.css"
		rel="stylesheet" />

	<tiles:putAttribute name="header">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Sửa thời gian đóng/ mở cửa</h1>
			</div>
			<!-- /.col-lg-12  -->
		</div>
	</tiles:putAttribute>

	<tiles:putAttribute name="body">
		<div class="row" >
			<div class="col-lg-12" style="height: 70%">
				<form class="form-horizontal">
					
					<div class="form-group">
						<label class="control-label col-sm-3" style="text-align: left">Nhà xe:</label>
						<div class="col-sm-3">
							<label>Nhà xe 1</label>
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-3" style="text-align: left">Số lượng xe tối đa (*):</label>
						<div class="col-sm-3">
							<input type="text" name="soluongxetoida" class="form-control"
								placeholder="Số lượng xe tối đa">
						</div>
					</div>

				</form>

			</div>
		</div>
	</tiles:putAttribute>

	<tiles:putAttribute name="footer">
		<div class="row">
			<div class="col-lg-6">
				<button type="button" class="btn btn-info">Lưu</button>
				<button type="button" class="btn btn-info">Quay lại</button>
			</div>
		</div>
	</tiles:putAttribute>
	<tiles:putAttribute name="javascript-source">

	</tiles:putAttribute>


</tiles:insertTemplate>