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
				<h1 class="page-header">Thống kê nhà xe 1</h1>
			</div>
			<!-- /.col-lg-12  -->
		</div>
	</tiles:putAttribute>

	<tiles:putAttribute name="body">
		<div class="row">
			<div class="col-lg-12">
				<div style="text-align: right; margin-bottom: 15px">
					<form action="action_page.php">
						<b>Ngày thống kê: </b><input type="date" name="date"> <input
							type="submit" name="Thống kê">
					</form>
				</div>
				
				<div>
					<table class="table table-striped table-bordered table-hover"
						id="dataTables-dsSinhVien">
						<thead>
							<tr>
								<th>STT</th>
								<th>NGÀY THỐNG KÊ</th>
								<th>SỐ XE VÀO</th>
								<th>SỐ XE RA</th>
								<th>TỔNG TIỀN</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>1</td>
								<td>22/01/2016</td>
								<td>1000</td>
								<td>900</td>
								<td>1000000</td>
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