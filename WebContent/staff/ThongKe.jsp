<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<tiles:insertTemplate template="../template/staff-template.jsp">
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
				<h1 class="page-header">Thống kê</h1>
			</div>
			<!-- /.col-lg-12  -->
		</div>
	</tiles:putAttribute>

	<tiles:putAttribute name="body">
		<div class="row">
			<div class="col-lg-12">
				<div class="form-group">
					<label class="col-lg-9"
						style="text-align: right; line-height: 35px;">Thời gian:</label>
					<div class="col-lg-3">
						<input readonly class="form-control" type="text" name="ngayDangKy"
							value="" class="input-medium" />
					</div>
				</div>

				<div>
				<br/>
				<br/>
					<table class="table table-striped table-bordered table-hover"
						id="dataTables-dsSinhVien">
						<thead>
							<tr>
								<th>SỐ LƯỢT VÀO</th>
								<th>SỐ LƯỢT RA</th>
								<th>TỔNG TIỀN</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>200</td>
								<td>150</td>
								<td>500.000</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</tiles:putAttribute>

	<tiles:putAttribute name="footer">
		<div class="row">
			<div class="col-lg-12">
				<button type="button" class="btn btn-info">Quay lại</button>
			</div>
		</div>
	</tiles:putAttribute>
	<tiles:putAttribute name="javascript-source">

	</tiles:putAttribute>


</tiles:insertTemplate>