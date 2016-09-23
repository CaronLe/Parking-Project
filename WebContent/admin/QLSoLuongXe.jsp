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
                <h1 class="page-header">Quản lý số lượng xe</h1>
            </div>
            <!-- /.col-lg-12  -->
        </div>
	</tiles:putAttribute>
	
	<tiles:putAttribute name="body">
		<div class="row">
        	<div class="col-lg-12">
        		
        		<table class="table table-striped table-bordered table-hover" id="dataTables-dsSinhVien">
        			<thead>
        				<tr>
        					<th>STT</th>
							<th>TÊN NHÀ XE</th>
							<th>ĐỊA CHỈ</th>
							<th>SỐ LƯỢNG XE TỐI ĐA</th>
							<th>CHỨC NĂNG</th>
        				</tr>
        			</thead>
        			<tbody>
	        			<tr>
							<td>1</td>
							<td>b</td>
							<td>c</td>
							<td>1000</td>
							<td><a href="SuaSoLuongXe.jsp">Sửa</a> </td>
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