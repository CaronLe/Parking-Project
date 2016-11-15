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
				<h1 class="page-header">Thống kê nhà xe 1</h1>
			</div>
			<!-- /.col-lg-12  -->
		</div>
	</tiles:putAttribute>

	<tiles:putAttribute name="body">
		<div class="row">
			<div class="col-lg-12">
				<div style="text-align: right; margin-bottom: 15px">
					<form id="er4" action="<%=request.getContextPath()%>/thongkeAdmin">
						<b>Ngày: </b><input style="width: 80px" type="text" name="ngay">
						<b>Tháng: </b><input style="width: 80px" type="text" name="thang">
						<b>Năm: </b><input 	style="width: 80px" type="text" name="nam">
						 <input style="width: 50px"	type="submit" name="Thống kê">
					</form>
				</div>
				
				<div>
					<table class="table table-striped table-bordered table-hover"
						id="dataTables-dsSinhVien">
						<thead>
							<tr>
								<th>STT</th>
								<th>NGÀY THỐNG KÊ</th>
								<th>SỐ XE VÀO</th>
								<th>SỐ XE RA</th>
								<th>TỔNG TIỀN</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>1</td>
								<td>22/01/2016</td>
								<td>1000</td>
								<td>900</td>
								<td>1000000</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</tiles:putAttribute>

	<tiles:putAttribute name="footer">
		<<div class="row">
			<div class="col-lg-12">
				<div class="col-lg-10"></div>
				<div class="col-lg-2">
					<a href="<%=request.getContextPath()%>/showAdmin" class="btn btn-info">Quay lại</a>
				</div>
			</div>
		</div>
	</tiles:putAttribute>
	<tiles:putAttribute name="javascript-source">
		<script type="text/javascript">
	      $(document).ready(function(){
	    	  $('#er4').validate({
	    		  errorPlacement: function(error,element){
	    			  error.insertAfter(element);
	    		  },
	    		  rules:{
	    			  ngay:{
	    				  max: 31,
	    				  digits: true
	    			  },
	    			  thang:{
	    				  max: 12,
	    				  digits: true
	    			  },
	    			  nam:{
	    				  digits: true,
	    				  max: 2016
	    			  }	    			  
	    		  },
	    		  messages:{
	    			  ngay:{
	    				  max: "<span style='color: red'>Số ngày tối đa là 31</span>",
	    				  digits: "<span style='color: red'>Số ngày là một số nguyên dương</span>"
	    			  },
	    			  thang:{
	    				  max: "<span style='color: red'>Số tháng tối đa là 12</span>",
	    				  digits: "<span style='color: red'>Số tháng là một số nguyên dương</span>"
	    			  },
	    			  nam:{
	    				  max: "<span style='color: red'>Số năm tối đa là 2016</span>",
	    				  digits: "<span style='color: red'>Số năm là một số nguyên dương</span>"
	    			  }			 
	    		  }
	    	  });
	      });
	   </script>
	</tiles:putAttribute>


</tiles:insertTemplate>