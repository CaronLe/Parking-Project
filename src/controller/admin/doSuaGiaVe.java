package controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.GiaVe;
import model.bo.GiaVeBO;

/**
 * Servlet implementation class doSuaGiaVe
 */
@WebServlet("/doSuaGiaVe")
public class doSuaGiaVe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doSuaGiaVe() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
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


		String maGiaVe = (String) request.getParameter("maGiaVe");
		String xeDapNgayThuong = (String) request.getParameter("xeDapNgayThuong");
		String xeDapCuoiTuan = (String) request.getParameter("xeDapCuoiTuan");
		String xeDapQuaDem = (String) request.getParameter("xeDapQuaDem");
		String xeMayNgayThuong = (String) request.getParameter("xeMayNgayThuong");
		String xeMayCuoiTuan = (String) request.getParameter("xeMayCuoiTuan");
		String xeMayQuaDem = (String) request.getParameter("xeMayQuaDem");

		GiaVe giaVe = new GiaVe();
		GiaVeBO giaVeBO = new GiaVeBO();
		boolean errorFlag = false;

		// validate du lieu nhap vao

		Integer mGiaVe = 0;
		Integer xDapNgayThuong = 0;
		Integer xDapCuoiTuan= 0;
		Integer xDapQuaDem = 0;
		Integer xMayNgayThuong = 0;
		Integer xMayCuoiTuan = 0;
		Integer xMayQuaDem = 0;
		try {
			mGiaVe = Integer.parseInt(maGiaVe);
			xDapNgayThuong = Integer.parseInt(xeDapNgayThuong);
			xDapCuoiTuan = Integer.parseInt(xeDapCuoiTuan);
			xDapQuaDem = Integer.parseInt(xeDapQuaDem);
			xMayNgayThuong = Integer.parseInt(xeMayNgayThuong);
			xMayCuoiTuan = Integer.parseInt(xeMayCuoiTuan);
			xMayQuaDem = Integer.parseInt(xeMayQuaDem);
			
			giaVe.setMaGiaVe(mGiaVe);
			giaVe.setXeDapNgayThuong(xDapNgayThuong);
			giaVe.setXeDapCuoiTuan(xDapCuoiTuan);
			giaVe.setXeDapQuaDem(xDapQuaDem);
			giaVe.setXeMayNgayThuong(xMayNgayThuong);
			giaVe.setXeMayCuoiTuan(xMayCuoiTuan);
			giaVe.setXeMayQuaDem(xMayQuaDem);
			
			System.out.println(giaVe);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

		// Cap nhat thanh cong
		if (!errorFlag) {
			giaVeBO.updateGiaVeTheoMaGiaVe(giaVe);
			response.sendRedirect(request.getContextPath()
					+ "/showGiaVe");
		}
		
		// Du lieu vao khong dung
		else
			response.sendRedirect(request.getContextPath()
					+ "/NhaXe_SuaGiaVe?maGiaVe=" + maGiaVe
					+ "&errorFlag=" + errorFlag);
	}

}
