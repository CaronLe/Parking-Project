<%@page import="utils.DateUtils"%>
<%@page import="java.util.Iterator"%>
<%@page import="model.bean.VeXe"%>
<%@page import="model.bo.VeXeBO"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<tiles:insertTemplate template="../template/staff-template.jsp">
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
				<h1 class="page-header">Nhà xe Đại Học Bách Khoa</h1>
			</div>
			<!-- /.col-lg-12  -->
		</div>
	</tiles:putAttribute>

	<tiles:putAttribute name="body">
		<br />
		<br />
		<div class="row">
			<div class="panel panel-info"
				style="background-color: #CCC !important;">
				<%
				VeXe vx = null;
				%>
				<div class="panel-heading"
					style="background-color: #006 !important;">
					<h3 class="panel-title" style="color: #FF0;">Thông tin vé xe</h3>
				</div>

				<div class="panel-body">
					<div class="row">
						<div class=" col-md-9 col-lg-6"
							style="border-right: double #000000;">

							<form class="form-horizontal" role="form" action="" method="post">
								<div class="form-group">
									<div class="col-lg-12"
										style="font-weight: bold; font-size: 30px; text-align: center;">XE
										VÀO</div>
								</div>

								<div class="form-group">
									<div class="col-lg-2"></div>
									<div class="col-lg-2">
										<p>
											<a class="btn btn-success"
												href="showVeXeMay?id=<%=vx.getMaVeXe()%>">XE MÁY </a>
										</p>
									</div>
									<div class="col-lg-4"></div>
									<div class="col-lg-2">
										<p>
											<a class="btn btn-success"
												href="">XE ĐẠP </a>
										</p>
									</div>
									<div class="col-lg-2"></div>
								</div>
								<div class="form-group">
									<label class="col-lg-4"
										style="text-align: right; line-height: 35px;">Số chỗ
										trống:</label>
									<div class="col-lg-4">
										<input readonly class="form-control" type="text"
											name="ngayDangKy" value="230" class="input-medium" />
									</div>
									<div class="col-lg-4"></div>
								</div>
								
							<input type="hidden" name="maNhaXe" value="<%=vx.getMaNhaXe()%>">
							<input type="hidden" name="trangThai" value="<%=vx.getTrangThai()%>">
							<input type="hidden" name="anhXe" value="<%=vx.getAnhXe()%>">
							<input type="hidden" name="giaTien" value="<%=vx.getGiaTien()%>">
							
								<div class="form-group">
									<div class="col-lg-12">
										<div class="panel-heading"
											style="background-color: #69C !important;">
											<h3 class="panel-title" style="color:; text-align: center;">VÉ
												XE</h3>
										</div>
										<table class="table table-bordered table-hover" id=""
											style="background-color: #FFF !important;">
											<tbody>
												<tr>
													<td style="font-weight: bold;">Số vé</td>
													<td><%=vx.getMaVeXe()%></td>
												</tr>

												<tr>
													<td style="font-weight: bold;">Loại xe</td>
													<td><%=vx.getLoaiXe()%></td>
												</tr>
												<tr>
													<td style="font-weight: bold;">Giờ vào</td>
													<td><%=vx.getThoiGianVao()%></td>
												</tr>
											</tbody>
										</table>
									</div>
								</div>

							</form>
						</div>
						<div class=" col-md-9 col-lg-6 ">
							<form class="form-horizontal" role="form" action="" method="post">
								<div class="form-group">
									<div class="col-lg-12"
										style="font-weight: bold; font-size: 30px; text-align: center;">XE
										RA</div>
								</div>
								<div class="form-group">
									<label class="col-lg-3"
										style="text-align: right; line-height: 35px;">Nhập số
										vé: </label>
									<div class="col-lg-6">
										<input class="form-control" type="text" name="ten" value=""
											class="input-medium" />
									</div>
									<div class="col-lg-2">
										<p>
											<a class="btn btn-success" href="#">TÍNH TIỀN </a>
										</p>
									</div>

									<div class="col-lg-2"></div>
								</div>

								<div class="form-group">
									<div class="col-lg-12">
										<div class="panel-heading"
											style="background-color: #69C !important;">
											<h3 class="panel-title" style="color:; text-align: center;">VÉ
												XE</h3>
										</div>
										<table class="table table-bordered table-hover" id=""
											style="background-color: #FFF !important;">
											<tbody>
												<tr>
													<td style="font-weight: bold;">Số vé</td>
													<td>B101</td>
												</tr>

												<tr>
													<td style="font-weight: bold;">Loại xe</td>
													<td>Xe máy</td>
												</tr>
												<tr>
													<td style="font-weight: bold;">Giờ vào</td>
													<td>7h30'</td>
												</tr>
												<tr>
													<td style="font-weight: bold;">Giờ ra</td>
													<td>10h30'</td>
												</tr>
												<tr>
													<td style="font-weight: bold;">Giá tiền</td>
													<td>5000</td>
												</tr>
											</tbody>
										</table>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>

				<div class="panel-footer" style="background-color: #006 !important;">
					<!-- 					<a data-original-title="Broadcast Message" data-toggle="tooltip" -->
					<!-- 						type="button" class="btn btn-sm btn-primary"> <i -->
					<!-- 						class="fa fa-envelope"></i> -->
					<!-- 					</a> <span class="pull-right"> <a -->
					<!-- 						data-original-title="Remove this user" data-toggle="tooltip" -->
					<!-- 						type="button" class="btn btn-sm btn-info"> Quay lại </a> -->
					<!-- 					</span> -->
				</div>
			</div>
		</div>
	</tiles:putAttribute>

	<tiles:putAttribute name="footer">
	</tiles:putAttribute>
	<tiles:putAttribute name="javascript-source">

	</tiles:putAttribute>


</tiles:insertTemplate>