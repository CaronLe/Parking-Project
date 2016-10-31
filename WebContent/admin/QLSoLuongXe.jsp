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

	<!-- DataTables Responsive CSS -->
	<link
		href="<%=request.getContextPath()%>/Resources/datatable-responsive/css/dataTables.responsive.css"
		rel="stylesheet" />

	<tiles:putAttribute name="header">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Quản lý số lượng xe</h1>
			</div>
			<!-- /.col-lg-12  -->
		</div>
	</tiles:putAttribute>

	<tiles:putAttribute name="body">
		<div class="row">
			<div class="col-lg-12">

				<table class="table table-striped table-bordered table-hover"
					id="dataTables-dsSinhVien">
					<thead>
						<tr>
							<th>MÃ NHÀ XE</th>
							<th>TÊN NHÀ XE</th>
							<th>SỐ LƯỢNG XE TỐI ĐA</th>
							<th>CHỨC NĂNG</th>
						</tr>
					</thead>
					<%
					 @SuppressWarnings("unchecked")
					ArrayList<NhaXe> nhaXeList = (ArrayList<NhaXe>) request.getAttribute("nhaXeList");
					if (nhaXeList != null) {
						Iterator<NhaXe> list = nhaXeList.iterator();
						NhaXe nx = null;
						while (list.hasNext()) {
						nx = list.next();
							%>
					<tbody>
						<tr>
							<td><%=nx.getMaNhaXe()%></td>
							<td><%=nx.getTenNhaXe()%></td>
							<td><%=nx.getSoLuongXe()%></td>
							<td><a href="NhaXe_SuaSoLuongXe?id=<%=nx.getMaNhaXe()%>">Sửa</a></td>
						</tr>
						<%
						}
					}
				%>
					</tbody>
					
				</table>

			</div>
		</div>
	</tiles:putAttribute>

	<tiles:putAttribute name="footer">
		<div class="row">
			<div class="col-lg-12">
				<div class="col-lg-10"></div>
				<div class="col-lg-2">
					<a href="<%=request.getContextPath()%>/showAdmin" class="btn btn-info">Quay lại</a>
				</div>
			</div>
		</div>
	</tiles:putAttribute>
	<tiles:putAttribute name="javascript-source">

	</tiles:putAttribute>


</tiles:insertTemplate>