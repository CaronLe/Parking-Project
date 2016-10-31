package controller.admin;

import java.io.IOException;
import java.sql.Time;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.NhaXe;
import model.bo.NhaXeBO;
import utils.DateUtils;

/**
 * Servlet implementation class doSuaThoiGianDongMoCua
 */
@WebServlet("/doSuaThoiGianDongMoCua")
public class doSuaThoiGianDongMoCua extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public doSuaThoiGianDongMoCua() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// set utf-8
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/plain; charset=utf-8");
		response.setCharacterEncoding("UTF-8");


		String maNhaXe = (String) request.getParameter("maNhaXe");
		String tenNhaXe = (String) request.getParameter("tenNhaXe");
		String diaChi = (String)request.getParameter("diaChi");
		String thoiGianMo = (String)request.getParameter("thoiGianMo");
		String thoiGianDong = (String)request.getParameter("thoiGianDong");

		NhaXe nhaXe = new NhaXe();
		NhaXeBO nhaXeBO = new NhaXeBO();
		boolean errorFlag = false;

		// validate du lieu nhap vao
//		if (!Validate.validateID(thoiGianMo)
//			|| !Validate.validateID(thoiGianDong)) {
//			errorFlag = true;
//		} // Loi do valid cho nay 
		
		java.util.Date tgMo = DateUtils.convertToTime(thoiGianMo);
		java.util.Date tgDong = DateUtils.convertToTime(thoiGianDong);
		
		try {
			nhaXe.setMaNhaXe(maNhaXe);
			nhaXe.setTenNhaXe(tenNhaXe);
			nhaXe.setDiaChi(diaChi);
			nhaXe.setThoiGianMo((Time) tgMo);
			nhaXe.setThoiGianDong((Time) tgDong);
			
			System.out.println(nhaXe);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

		// Cap nhat thanh cong
		if (!errorFlag) {
			nhaXeBO.updateThoiGianDongMoCua(nhaXe);
			response.sendRedirect(request.getContextPath()
					+ "/showThoiGianDongMo");
		}
		
		// Du lieu vao khong dung
		else
			response.sendRedirect(request.getContextPath()
					+ "/NhaXe_SuaThoiGianDongMoCua?maNhaXe=" + maNhaXe
					+ "&errorFlag=" + errorFlag);
	}

}
