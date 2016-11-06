<%@page import="model.bean.NhanVien"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<% NhanVien obj = (NhanVien)request.getAttribute("obj");%>
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
				<form class="form-horizontal" id="fr2" action="<%=request.getContextPath() %>/SuaNhanVienServlet">
				    <div class="form-group">
						<label class="control-label col-sm-2" style="text-align: left">Mã NV:</label>
						<div class="col-sm-10">
							<input type="text" name="manv" class="form-control"
								readonly value="<%=obj.getMaNV() %>">
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-sm-2" style="text-align: left">Họ tên:</label>
						<div class="col-sm-10">
							<input type="text" name="hoten" class="form-control"
								placeholder="Họ tên" value="<%=obj.getHoTen()%>">
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-2" style="text-align: left">Địa chỉ:</label>
						<div class="col-sm-10">
							<input type="text" name="diachi" class="form-control"
								placeholder="Địa chỉ" value="<%=obj.getDiaChi() %>">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" style="text-align: left">Số điện thoại:</label>
						<div class="col-sm-10">
							<input type="number" name="sodienthoai" class="form-control"
								placeholder="Số điện thoại" value="<%=obj.getSoDienThoai() %>">
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-2" style="text-align: left">Lương:</label>
						<div class="col-sm-10">
							<input type="number" name="luong" class="form-control"
								placeholder="Lương" value="<%=obj.getLuongNV() %>">
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-2" style="text-align: left">Tài khoản:</label>
						<div class="col-sm-10">
							<input type="text" name="taikhoan" class="form-control"
								placeholder="Tài khoản" readonly value="<%=obj.getTaiKhoan() %>">
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-2" style="text-align: left">Mật khẩu:</label>
						<div class="col-sm-10">
							<input type="text" name="matkhau" class="form-control"
								placeholder="Mật khẩu" value="<%=obj.getMatKhau() %>">
						</div>
					</div>
					<div class="row" align="center">
			          <div class="col-lg-12">
				      <button type="submit" class="btn btn-info">Lưu</button>
				      <a href="NhanVienServlet"><button type="button" class="btn btn-info">Quay lại</button></a>
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