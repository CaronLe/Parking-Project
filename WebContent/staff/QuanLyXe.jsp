<%@page import="com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array"%>
<%@page import="java.util.Random"%>
<%@page import="java.util.ArrayList"%>
<%@page import="utils.DateUtils"%>
<%@page import="java.util.Iterator"%>
<%@page import="model.bean.VeXe"%>
<%@page import="model.bo.VeXeBO"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%
	VeXe veXe = new VeXe();
	if (request.getAttribute("veXe") != null) {
		veXe = (VeXe) request.getAttribute("veXe");
	}
%>
<%
	VeXe veXeRa = new VeXe();
    if (request.getAttribute("veXeRa") != null) {
	veXeRa = (VeXe) request.getAttribute("veXeRa");
    }
%>
<%
	int soChoTrong = 0;
	if (request.getAttribute("soChoTrong") != null) {
		soChoTrong = (Integer) request.getAttribute("soChoTrong");
	}
%>

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
											<a class="btn btn-success" href="addVeXeMay">XE MÁY </a>
										</p>
									</div>
									<div class="col-lg-4"></div>
									<div class="col-lg-2">
										<p>
											<a class="btn btn-success" href="addVeXeDap">XE ĐẠP </a>
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
											name="sochotrong" value="<%=soChoTrong%>"
											class="input-medium" />
									</div>
									<div class="col-lg-4"></div>
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
													<td><%=veXe.getMaVeXe()%></td>
												</tr>

												<tr>
													<td style="font-weight: bold;">Loại xe</td>
													<td><%=veXe.getLoaiXe()%></td>
												</tr>
												<tr>
													<td style="font-weight: bold;">Giờ vào</td>
													<td><%=veXe.getThoiGianVao()%></td>
												</tr>
											</tbody>
										</table>
									</div>
								</div>
							</form>
							<div class="form-group">
								<div class="col-lg-12">
									<!-- 										<div class="panel-heading" -->
									<!-- 											style="background-color: #69C !important;"> -->
									<!-- 											<h3 class="panel-title" style="color:; text-align: center;"> ẢNH XE</h3> -->
									<!-- 										</div> -->
									<table class="table table-bordered table-hover" id=""
										style="background-color: #FFF !important;">
										<tbody>
											<tr>
												<%
												     ArrayList<String> anh = null;
												     int soAnh = 0;
													 if(request.getAttribute("anhXeMay")!=null||request.getAttribute("anhXeDap")!=null){
														 if(request.getAttribute("anhXeMay")!=null){
															 anh = (ArrayList<String>)request.getAttribute("anhXeMay");
															 soAnh = (Integer)request.getAttribute("soXeMay");
														 }
														 else{
															 anh = (ArrayList<String>)request.getAttribute("anhXeDap");
															 soAnh = (Integer)request.getAttribute("soXeDap");
														 }
													        	Random n = new Random();
																int x = n.nextInt(4);
																int y = n.nextInt(4);
																while (y == x) {
																	y = n.nextInt(4);
																}
															
												%>
												<td><img width="150px" height="90px" alt=""
													src="<%=anh.get(x)%>"></td>
												<td><img width="150px" height="90px" alt=""
													src="<%=anh.get(y)%>"></td>
											</tr>
                                             <%} %>
										</tbody>

									</table>
								</div>
							</div>
							</form>

						</div>

						<div class=" col-md-9 col-lg-6 ">
							<form class="form-horizontal" role="form"
								action="tinhTienServlet" method="post">
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
										<input class="form-control" type="text" name="mavexe" value=""
											class="input-medium" />
									</div>
									<div class="col-lg-2">
										<p>
											<button type="submit" class="btn btn-success">TÍNH
												TIỀN</button>
										</p>
									</div>

									<div class="col-lg-2"></div>
								</div>

								<div class="form-group">
									<div class="col-lg-12">
										<br /> <br /> <br />
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
													<td><%=veXeRa.getMaVeXe()%></td>
												</tr>

												<tr>
													<td style="font-weight: bold;">Loại xe</td>
													<td><%=veXeRa.getLoaiXe()%></td>
												</tr>
												<tr>
													<td style="font-weight: bold;">Giờ vào</td>
													<td><%=veXeRa.getThoiGianVao()%></td>
												</tr>
												<tr>
													<td style="font-weight: bold;">Giờ ra</td>
													<td><%=veXeRa.getThoiGianRa()%></td>
												</tr>
												<tr>
													<td style="font-weight: bold;">Giá tiền</td>
													<td><%=veXeRa.getGiaTien()%></td>
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
				</div>
			</div>
		</div>
	</tiles:putAttribute>

	<tiles:putAttribute name="footer">
	</tiles:putAttribute>
	<tiles:putAttribute name="javascript-source">

	</tiles:putAttribute>


</tiles:insertTemplate>