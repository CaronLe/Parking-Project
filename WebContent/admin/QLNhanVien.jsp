<%@page import="java.util.ArrayList"%>
<%@page import="model.bean.NhanVien" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<% ArrayList<NhanVien> allNhanVien = (ArrayList<NhanVien>)request.getAttribute("allNhanVien"); %>
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
                <h1 class="page-header">Danh sách nhân viên</h1>
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
							<th>HỌ TÊN</th>
							<th>ĐỊA CHỈ</th>
							<th>SỐ ĐIỆN THOẠI</th>
							<th>LƯƠNG</th>
							<th>ẢNH</th>
							<th>TÀI KHOẢN</th>
							<th>MẬT KHẨU</th>
							<th>CHỨC NĂNG</th>
        				</tr>
        			</thead>
        			<%
        			int i=0;
        			for(NhanVien obj:allNhanVien){
        			i++;
        			%>
        			<tbody>
	        			<tr>
							<td><%=i %></td>
							<td><%=obj.getHoTen() %></td>
							<td><%=obj.getDiaChi() %></td>
							<td><%=obj.getSoDienThoai() %></td>
							<td><%=obj.getLuongNV() %></td>
							<td><a href="ExportFileServlet?id=<%=obj.getMaNV() %>">Nhân viên <%=i %></a></td>
							<td><%=obj.getTaiKhoan() %></td>
							<td><input type="password" readonly="readonly" style="width:60px" id="pass<%=i %>" value="<%=obj.getMatKhau() %>">
							     <input type="text" readonly="readonly" style="width:60px" id="text<%=i %>" value="<%=obj.getMatKhau() %>">
							     &nbsp&nbsp<input type="checkbox" id="check<%=i %>">
							</td>
							<td><a href="NhanVienServlet?suanv=<%=obj.getMaNV()%>">Sửa</a> | <a href="NhanVienServlet?xoanv=<%=obj.getMaNV()%>">Xóa</a></td>
						</tr>     			
        			</tbody>
        			
        			<script type="text/javascript">
	                   $(document).ready(function(){
	                	   $('#text<%=i%>').hide();
	                	    $('#pass<%=i%>').blur(function() {
	                	        $('#text<%=i%>').val($(this).val());
	                	    });
	    	              $('#check<%=i %>').change(function() {
	    	                 var isChecked = $(this).prop('checked');
	    	                 if (isChecked) {
	    	                   $('#pass<%=i%>').hide();
	    	                   $('#text<%=i%>').show();
	    	                 }
	    	                 else {
	    	                   $('#pass<%=i%>').show();
	    	                   $('#text<%=i%>').hide();
	    	                 }
	    	              });
	                   });
	               </script>
        			 
        			<%} %>
        		</table>
        		
        	</div>
        </div>
	</tiles:putAttribute>
	
	<tiles:putAttribute name="footer">
		<div class="row">
			<div class="col-lg-12">
				<a href="ThemNhanVienServlet"><button type="button" class="btn btn-info">Thêm nhân viên</button></a>
				<a href="NhanVienServlet"><button type="button" class="btn btn-info">Quay lại</button></a>
			</div>
		</div>
	</tiles:putAttribute>
	<tiles:putAttribute name="javascript-source">
	   
	</tiles:putAttribute>
	
</tiles:insertTemplate>