<%@page import="utils.DateUtils"%>
<%@page import="java.util.Iterator"%>
<%@page import="model.bean.NhaXe"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.bo.NhaXeBO"%>
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
	<%
		NhaXe nhaXe = (NhaXe) request.getAttribute("nhaXeByID");
			if (request.getAttribute("errorFlag") != null) {
	%><h3 style="color: red;">Cập nhật thất bại</h3>
	<%
		}
	%>
	<tiles:putAttribute name="body">
		<div class="row">
			<div class="col-lg-12" style="height: 70%">
				<form class="form-horizontal" role="form"
					action="<%=request.getContextPath()%>/doSuaThoiGianDongMoCua"
					method="post">
					<input type="hidden" name="maNhaXe" value="<%=nhaXe.getMaNhaXe()%>">
					
					<div class="form-group">
						<label class="control-label col-sm-3" style="text-align: left">Nhà
							xe:</label>
						<div class="col-sm-3">
							<input readonly class="form-control" type="text" name="tenNhaXe"
								value="<%=nhaXe.getTenNhaXe()%>" class="input-medium" />

						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-sm-3" style="text-align: left">Địa chỉ:</label>
						<div class="col-sm-3">
							<input readonly class="form-control" type="text" name="diaChi"
								value="<%=nhaXe.getDiaChi()%>" class="input-medium" />

						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-3" style="text-align: left">Thời
							gian mở cửa (*):</label>
						<div class="col-sm-3">
							<input placeholder="Thời gian mở cửa" class="form-control" type="text" name="thoiGianMo"
							value="<%=nhaXe.getThoiGianMo()%>" class="input-medium" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-3" style="text-align: left">Thời
							gian đóng cửa (*):</label>
						<div class="col-sm-3">
							<input placeholder="Thời gian đóng cửa" class="form-control" type="text" name="thoiGianDong"
							value="<%=nhaXe.getThoiGianDong()%>" class="input-medium" />
						</div>
					</div>
					<br/>
					<div class="form-group">
						<label class="col-lg-4 control-label"></label>
						<div class="col-md-8">
							<input type="submit" class="btn btn-info" value="Lưu"> <span></span>
							<a href="<%=request.getContextPath()%>/showSoLuongXe"
								class="btn btn-info">Quay lại</a>
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
        	  $('#fr2').validate({
        		  errorPlacement: function(error,element){
        			  error.insertAfter(element);
        		  },
        		  rules: {
        			  hoten: {required: true, maxlength: 20},
        			  diachi: {required: true, maxlength: 100},
        			  sodienthoai: {required: true, digits: true, maxlength: 15},
        			  luong: {required: true, max: 2147483647, digits: true},
        			  taikhoan: {required: true, maxlength: 20},
        			  matkhau: {required: true, maxlength: 20}
        		  },
        		  messages:{
        			  hoten:{
        				  required: "<span style='color: red'>Họ tên không được để trống</span>",
	    				  maxlength: "<span style='color: red'>Tên không được lớn hơn 20 kí tự</span>"
        			  },
        		      diachi:{
        		    	  required: "<span style='color: red'>Địa chỉ không được để trống</span>",
	    				  maxlength: "<span style='color: red'>Địa chỉ không được lớn hơn 100 kí tự</span>"
        		      },
        		      sodienthoai:{
        		    	  required: "<span style='color: red'>Số điện thoại không được để trống</span>",
	    				  digits: "<span style='color: red'>Số điện thoại phải là số nguyên dương</span>",
	    				  maxlength: "<span style='color: red'>Số điện thoại không vượt quá 15 kí tự</span>"
        		      },
        		      luong:{
        		    	  required: "<span style='color: red'>Tiền lương không được để trống</span>",
	    				  max: "<span style='color: red'>Giá tiền không vượt quá 2147483647 VNĐ</span>",
	    				  digits: "<span style='color: red'>Tiền lương phải là số nguyên dương</span>"
        		      },
        		      taikhoan:{
        		    	  required: "<span style='color: red'>Tài khoản không được để trống</span>",
	    				  maxlength: "<span style='color: red'>Tài khoản không được lớn hơn 20 kí tự</span>"
        		      },
        		      matkhau:{
        		    	  required: "<span style='color: red'>Mật khẩu không được để trống</span>",
	    				  maxlength: "<span style='color: red'>Mật khẩu không được lớn hơn 20 kí tự</span>"
        		      }
        		  }
        	  });
          });
       </script>
	</tiles:putAttribute>


</tiles:insertTemplate>