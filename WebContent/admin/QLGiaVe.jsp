<%@page import="java.util.Iterator"%>
<%@page import="model.bean.GiaVe"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.bo.GiaVeBO"%>
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
                <h1 class="page-header">Quản lý giá vé</h1>
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
        					<th rowspan="2">STT</th>
							<th rowspan="2">TÊN NHÀ XE</th>
							<th rowspan="2">ĐỊA CHỈ</th>
							<th colspan="3">XE ĐẠP </th>						
							<th colspan="3">XE MÁY</th>
							<th rowspan="3">CHỨC NĂNG</th>
        				</tr>
        				
        				<tr>
							<th>Ngày thường</th>
							<th>Cuối tuần</th>
							<th>Qua đêm</th>
							<th>Ngày thường</th>
							<th>Cuối tuần</th>
							<th>Qua đêm</th>	
						</tr>
        			</thead>
     			
     				<%
					 @SuppressWarnings("unchecked")
					ArrayList<GiaVe> giaVeList = (ArrayList<GiaVe>) request.getAttribute("giaVeList");
					if (giaVeList != null) {
						Iterator<GiaVe> list = giaVeList.iterator();
						GiaVe gv = null;
						while (list.hasNext()) {
						gv = list.next();
							%>
     			
        			<tbody>
	        			<tr>
							<td><%=gv.getMaGiaVe()%></td>
							<td><%=gv.getTenNhaXe()%></td>
							<td><%=gv.getDiaChi()%></td>
							<td><%=gv.getXeDapNgayThuong()%></td>
							<td><%=gv.getXeDapCuoiTuan()%></td>
							<td><%=gv.getXeDapQuaDem()%></td>
							<td><%=gv.getXeMayNgayThuong()%></td>
							<td><%=gv.getXeMayCuoiTuan()%></td>
							<td><%=gv.getXeMayQuaDem()%></td>
							<td><a href="NhaXe_SuaGiaVe?id=<%=gv.getMaGiaVe()%>">Sửa</a></td>
						</tr> 
						
						<%
						}
					}
				%>
						    			
        			</tbody>
        		</table>
        		
        	</div>
        </div>
	</tiles:putAttribute>
	
	<tiles:putAttribute name="footer">
		<div class="row">
			<div class="col-lg-12">
				<div class="col-lg-10"></div>
				<div class="col-lg-2">
					<a href="<%=request.getContextPath()%>/showAdmin" class="btn btn-info">Quay lại</a>
				</div>
			</div>
		</div>
	</tiles:putAttribute>
	<tiles:putAttribute name="javascript-source">
	
	</tiles:putAttribute>
	
	
</tiles:insertTemplate>