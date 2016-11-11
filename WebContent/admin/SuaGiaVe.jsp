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

	<tiles:putAttribute name="body">
		<div class="row" >
			<div class="col-lg-12">
				<form class="form-horizontal">
					<div class="col-sm-6">
					<div class="form-group">
						<div class="col-sm-6">
							<h2>XE ĐẠP</h2>
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-4" style="text-align: left">Ngày Thường (*):</label>
						<div class="col-sm-6">
							<input type="text" name="XDngaythuong" class="form-control"
								placeholder="Ngày thường">
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-4" style="text-align: left">Cuối tuần (*):</label>
						<div class="col-sm-6">
							<input type="text" name="XDcuoituan" class="form-control"
								placeholder="Cuối tuần">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-4" style="text-align: left">Qua đêm (*):</label>
						<div class="col-sm-6">
							<input type="text" name="XDquadem" class="form-control"
								placeholder="Qua đêm">
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
							<input type="text" name="XMngaythuong" class="form-control"
								placeholder="Ngày thường">
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-4" style="text-align: left">Cuối tuần (*):</label>
						<div class="col-sm-6">
							<input type="text" name="XMcuoituan" class="form-control"
								placeholder="Cuối tuần">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-4" style="text-align: left">Qua đêm (*):</label>
						<div class="col-sm-6">
							<input type="text" name="XMquadem" class="form-control"
								placeholder="Qua đêm">
						</div>
					</div>
					</div>
				</form>

			</div>
		</div>
	</tiles:putAttribute>

	<tiles:putAttribute name="footer">
		<div class="row">
			<div class="col-lg-12">
				<button type="button" class="btn btn-info">Lưu</button>
				<button type="button" class="btn btn-info">Quay lại</button>
			</div>
		</div>
	</tiles:putAttribute>
<tiles:putAttribute name="javascript-source">
       <script type="text/javascript">
          $(document).ready(function(){
        	  $('#fr2').validate({
        		  errorPlacement: function(error,element){
        			  error.insertAfter(element);
        		  },
        		  rules: {
        			  XDngaythuong: {required: true, max: 5000, digits: true},
        			  XDcuoituan: {required: true, max: 10000, digits: true},
        			  XDquadem: {required: true, max: 20000, digits: true},
        			  XMngaythuong: {required: true, max: 10000, digits: true},
        			  XMcuoituan: {required: true, max: 20000, digits: true},
        			  XMquadem: {required: true, max: 50000, digits: true},
        		  },
        		  messages:{
        			  XDngaythuong:{
        				  required: "<span style='color: red'>Giá vé không được để trống</span>",
	    				  max: "<span style='color: red'>Giá vé không vượt quá 5000 VNĐ</span>",
	    				  digits: "<span style='color: red'>Giá vé phải là số nguyên dương</span>"
        			  },
        			  XDcuoituan:{
        				  required: "<span style='color: red'>Giá vé không được để trống</span>",
	    				  max: "<span style='color: red'>Giá vé không vượt quá 10000 VNĐ</span>",
	    				  digits: "<span style='color: red'>Giá vé phải là số nguyên dương</span>"
        			  },
        			  XDquadem:{
        				  required: "<span style='color: red'>Giá vé không được để trống</span>",
	    				  max: "<span style='color: red'>Giá vé không vượt quá 20000 VNĐ</span>",
	    				  digits: "<span style='color: red'>Giá vé phải là số nguyên dương</span>"
        			  },
        			  XMngaythuong:{
        				  required: "<span style='color: red'>Giá vé không được để trống</span>",
	    				  max: "<span style='color: red'>Giá vé không vượt quá 10000 VNĐ</span>",
	    				  digits: "<span style='color: red'>Giá vé phải là số nguyên dương</span>"
        			  },
        			  XMcuoituan:{
        				  required: "<span style='color: red'>Giá vé không được để trống</span>",
	    				  max: "<span style='color: red'>Giá vé không vượt quá 20000 VNĐ</span>",
	    				  digits: "<span style='color: red'>Giá vé phải là số nguyên dương</span>"
        			  },
        			  XMquadem:{
        				  required: "<span style='color: red'>Giá vé không được để trống</span>",
	    				  max: "<span style='color: red'>Giá vé không vượt quá 50000 VNĐ</span>",
	    				  digits: "<span style='color: red'>Giá vé phải là số nguyên dương</span>"
        			  }
        		      
        		  }
        	  });
          });
       </script>
	</tiles:putAttribute>


</tiles:insertTemplate>