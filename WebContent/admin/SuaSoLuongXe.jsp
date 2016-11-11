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
					action="<%=request.getContextPath()%>/doSuaSoLuongXe"
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
						<label class="control-label col-sm-3" style="text-align: left">Số
							lượng xe tối đa (*):</label>
						<div class="col-sm-3">
							<input placeholder="Số lượng xe tối đa" class="form-control"
								type="text" name="soLuongXe" value="<%=nhaXe.getSoLuongXe()%>"
								class="input-medium" />

						</div>
					</div>

					<div class="form-group">
						<label class="col-lg-3 control-label"></label>
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
        			  soLuongXe: {required: true, maxlength: 20, digits:true }
        		  },
        		  messages:{
        			    luong:{
        		    	  required: "<span style='color: red'>Số lượng xe không được để trống</span>",
	    				  max: "<span style='color: red'>Số lượng xe tối đa không vượt quá 10000 chiếc </span>",
	    				  digits: "<span style='color: red'>Số lượng xe phải là số nguyên dương</span>"
        		      }
        		  }
        	  });
          });
       </script>
	</tiles:putAttribute>


</tiles:insertTemplate>