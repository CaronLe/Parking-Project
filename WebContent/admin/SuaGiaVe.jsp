<%@page import="utils.DateUtils"%>
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
				<h1 class="page-header">Sửa giá vé</h1>
			</div>
			<!-- /.col-lg-12  -->
		</div>
	</tiles:putAttribute>
	
	<%
		GiaVe giaVe = (GiaVe) request.getAttribute("giaVeByID");
			if (request.getAttribute("errorFlag") != null) {
	%><h3 style="color: red;">Cập nhật thất bại</h3>
	<%
		}
	%>

	<tiles:putAttribute name="body">
		<div class="row" >
			<div class="col-lg-12">
				<form class="form-horizontal"role="form" id="er3"
					action="<%=request.getContextPath()%>/doSuaGiaVe"
					method="post">
					
					<input type="hidden" name="maGiaVe" value="<%=giaVe.getMaGiaVe()%>">
					
					<div class="col-sm-6">
					<div class="form-group">
						<div class="col-sm-6">
							<h2>XE ĐẠP</h2>
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-4" style="text-align: left">Ngày Thường (*):</label>
						<div class="col-sm-6">
							<input type="text" name="xeDapNgayThuong" class="form-control"
								placeholder="Ngày thường" value="<%=giaVe.getXeDapNgayThuong()%>">
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-4" style="text-align: left">Cuối tuần (*):</label>
						<div class="col-sm-6">
							<input type="text" name="xeDapCuoiTuan" class="form-control"
								placeholder="Cuối tuần" value="<%=giaVe.getXeDapCuoiTuan()%>">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-4" style="text-align: left">Qua đêm (*):</label>
						<div class="col-sm-6">
							<input type="text" name="xeDapQuaDem" class="form-control"
								placeholder="Qua đêm" value="<%=giaVe.getXeDapQuaDem()%>">
						</div>
					</div>
					</div>
					
						<div class="col-sm-6">
					<div class="form-group">
						<div class="col-sm-6">
							<h2>XE MÁY</h2>
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-4" style="text-align: left">Ngày Thường (*):</label>
						<div class="col-sm-6">
							<input type="text" name="xeMayNgayThuong" class="form-control"
								placeholder="Ngày thường" value="<%=giaVe.getXeMayNgayThuong()%>">
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-4" style="text-align: left">Cuối tuần (*):</label>
						<div class="col-sm-6">
							<input type="text" name="xeMayCuoiTuan" class="form-control"
								placeholder="Cuối tuần" value="<%=giaVe.getXeMayCuoiTuan()%>">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-4" style="text-align: left">Qua đêm (*):</label>
						<div class="col-sm-6">
							<input type="text" name="xeMayQuaDem" class="form-control"
								placeholder="Qua đêm" value="<%=giaVe.getXeMayQuaDem()%>">
						</div>
					</div>
					<br/><br/>
					<div class="form-group">
						<label class="col-lg-3 control-label"></label>
						<div class="col-md-8">
							<input type="submit" class="btn btn-info" value="Lưu"> <span></span>
							<a href="<%=request.getContextPath()%>/showGiaVe"
								class="btn btn-info">Quay lại</a>
						</div>
					</div>
					
					</div>
				</form>

			</div>
		</div>
	</tiles:putAttribute>

	<tiles:putAttribute name="footer">

	</tiles:putAttribute>
	<tiles:putAttribute name="javascript-source">
		<script type="text/javascript">
          $(document).ready(function(){
        	  $('#er3').validate({
        		  errorPlacement: function(error,element){
        			  error.insertAfter(element);
        		  },
        		  rules: {
        			  xeDapNgayThuong: {required: true, digits: true, max: 10000},
        			  xeDapCuoiTuan: {required: true, digits: true, max: 15000},
        			  xeDapQuaDem: {required: true, digits: true, max: 20000},
        			  xeMayNgayThuong: {required: true, digits: true, max: 20000},
        			  xeMayCuoiTuan: {required: true, digits: true, max: 25000},
        			  xeMayQuaDem: {required: true, digits: true, max: 30000},
        		  },
        		  messages:{
        			  xeDapNgayThuong:{
        				  required: "<span style='color: red'>Không được để trống</span>",
        				  digits: "<span style='color: red'>Giá vé phải là số nguyên dương</span>",
	    				  max: "<span style='color: red'>Không lớn hơn 10000 VNĐ</span>"
        			  },
        			  xeDapCuoiTuan:{
        				  required: "<span style='color: red'>Không được để trống</span>",
        				  digits: "<span style='color: red'>Giá vé phải là số nguyên dương</span>",
	    				  max: "<span style='color: red'>Không lớn hơn 15000 VNĐ</span>"
        		      },
        		      xeDapQuaDem:{
        		    	  required: "<span style='color: red'>Không được để trống</span>",
        				  digits: "<span style='color: red'>Giá vé phải là số nguyên dương</span>",
	    				  max: "<span style='color: red'>Không lớn hơn 20000 VNĐ</span>"
        		      },
        		      xeMayNgayThuong:{
        		    	  required: "<span style='color: red'>Không được để trống</span>",
        				  digits: "<span style='color: red'>Giá vé phải là số nguyên dương</span>",
	    				  max: "<span style='color: red'>Không lớn hơn 20000 VNĐ</span>"
        		      },
        		      xeMayCuoiTuan:{
        		    	  required: "<span style='color: red'>Không được để trống</span>",
        				  digits: "<span style='color: red'>Giá vé phải là số nguyên dương</span>",
	    				  max: "<span style='color: red'>Không lớn hơn 25000 VNĐ</span>"
        		      },
        		      xeMayQuaDem:{
        		    	  required: "<span style='color: red'>Không được để trống</span>",
        				  digits: "<span style='color: red'>Giá vé phải là số nguyên dương</span>",
	    				  max: "<span style='color: red'>Không lớn hơn 30000 VNĐ</span>"
        		      }
        		  }
        	  });
          });
       </script>
	</tiles:putAttribute>


</tiles:insertTemplate>