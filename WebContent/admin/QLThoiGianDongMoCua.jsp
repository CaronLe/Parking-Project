<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

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
                <h1 class="page-header">Quản lý thời gian đóng/ mở cửa</h1>
            </div>
            <!-- /.col-lg-12  -->
        </div>
	</tiles:putAttribute>
	
	<tiles:putAttribute name="body">
		<div class="row">
        	<div class="col-lg-12" style="height: 70%">
        		
        		<table class="table table-striped table-bordered table-hover" id="dataTables-dsSinhVien">
        			<thead>
					<tr>
						<th>STT</th>
						<th>TÊN NHÀ XE</th>
						<th>ĐỊA CHỈ</th>
						<th>THỜI GIAN MỞ CỬA</th>
						<th>THỜI GIAN ĐÓNG CỬA</th>
						<th>CHỨC NĂNG</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>1</td>
						<td>b</td>
						<td>c</td>
						<td>3h</td>
						<td>7h</td>
						<td><a href="SuaThoiGianDongMoCua.jsp">Sửa</a></td>
					</tr>
				</tbody>
        		</table>
        		
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