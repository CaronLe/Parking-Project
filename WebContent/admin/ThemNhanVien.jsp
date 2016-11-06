<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%String loi = (String)request.getAttribute("loi"); %>

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
				<h1 class="page-header">Thêm nhân viên</h1>
			</div>
			<!-- /.col-lg-12  -->
		</div>
	</tiles:putAttribute>

	<tiles:putAttribute name="body">
		<div class="row">
			<div class="col-lg-12" style="height: 70%">
				<form action="<%=request.getContextPath()%>/ThemNhanVienServlet" method="post" class="form-horizontal" id="fr1" enctype="multipart/form-data">
					<div class="form-group">
						<label class="control-label col-sm-2" style="text-align: left">Họ tên:</label>
						<div class="col-sm-10">
							<input type="text" name="hoten" class="form-control"
								placeholder="Họ tên">
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-2" style="text-align: left">Địa chỉ:</label>
						<div class="col-sm-10">
							<input type="text" name="diachi" class="form-control"
								placeholder="Địa chỉ">
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-sm-2" style="text-align: left">Số điện thoại:</label>
						<div class="col-sm-10">
							<input type="number" name="sodienthoai" class="form-control"
								placeholder="Số điện thoại">
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-2" style="text-align: left">Lương:</label>
						<div class="col-sm-10">
							<input type="number" name="luong" class="form-control"
								placeholder="Lương">
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-sm-2" style="text-align: left">Mã nhà xe:</label>
						<div class="col-sm-10">
							<input type="text" name="manhaxe" class="form-control"
								placeholder="Mã nhà xe">
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-sm-2" style="text-align: left">Upload:</label>
						<div class="col-sm-10">
							<input type="file" name="uploadFile">
						</div>
					</div>
					
					<div class="form-group">
					  <div class="col-sm-2"></div>
					  <div class="col-sm-10">
                       <div class="alert alert-danger" style="text-align: center" id="myAlert">
                         <a href="#" class="close">&times;</a>
                          <%=loi %>
                       </div>
                      </div>
                    </div>
                    <script type="text/javascript">
                      
                      $(document).ready(function(){
                    	  $(".close").click(function(){
                              $("#myAlert").alert("close");
                             });
                    	  var loi  = <%=loi%>;
                    	  if(loi==null){
                    		  $("#myAlert").hide();
                    	  }
                    	  else{
                    		  $("#myAlert").show();
                    	  }
                       });
                     </script>

					<div class="form-group">
						<label class="control-label col-sm-2" style="text-align: left">Tài khoản:</label>
						<div class="col-sm-10">
							<input type="text" name="taikhoan" class="form-control"
								placeholder="Tài khoản">
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-2" style="text-align: left">Mật khẩu:</label>
						<div class="col-sm-10">
							<input type="text" name="matkhau" class="form-control"
								placeholder="Mật khẩu">
						</div>
					</div>
					<div class="row" align="center">
			          <div class="col-lg-12">
				        <button type="submit" class="btn btn-info" name="ok">Lưu</button>
				        <a href="<%=request.getContextPath() %>/NhanVienServlet"><button type="button" class="btn btn-info">Quay lại</button></a>
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
	    	  $('#fr1').validate({
	    		  errorPlacement: function(error,element){
	    			  error.insertAfter(element);
	    		  },
	    		  rules:{
	    			  hoten:{
	    				  required: true,
	    				  maxlength: 20
	    			  },
	    			  diachi:{
	    				  required: true,
	    				  maxlength: 100
	    			  },
	    			  sodienthoai:{
	    				  required: true,
	    				  digits: true,
	    				  maxlength: 15
	    			  },
	    			  luong:{
	    				  required: true,
	    				  max: 2147483647,
	    				  digits: true
	    			  },
	    			  manhaxe:{
	    				  required: true,
	    				  maxlength: 10
	    			  },
	    			  taikhoan:{
	    				  required: true,
	    				  maxlength: 20
	    			  },
	    			  matkhau:{
	    				  required: true,
	    				  maxlength: 20
	    			  }
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
	    				  maxlength: "<span style='color: red'>Độ dài không vượt quá 15 kí tự</span>"
	    			  },
	    			  luong:{
	    				  required: "<span style='color: red'>Tiền lương không được để trống</span>",
	    				  max: "<span style='color: red'>Giá tiền không vượt quá 2147483647 VNĐ</span>",
	    				  digits: "<span style='color: red'>Tiền lương phải là số nguyên dương</span>"
	    			  },
	    			  manhaxe:{
	    				  required: "<span style='color: red'>Mã nhà xe không được để trống</span>",
	    				  maxlength: "<span style='color: red'>Mã nhà xe không được lớn hơn 10 kí tự</span>" 
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