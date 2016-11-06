package controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.ProcessBuilder.Redirect;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.NhanVienBO;

/**
 * Servlet implementation class SuaNhanVienServlet
 */
@WebServlet("/SuaNhanVienServlet")
public class SuaNhanVienServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuaNhanVienServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/plain; charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		
		int maNhanVien = Integer.parseInt(request.getParameter("manv"));
		String hoTen = request.getParameter("hoten");
		String diaChi = request.getParameter("diachi");
		String soDienThoai = request.getParameter("sodienthoai");
		int luong = Integer.parseInt(request.getParameter("luong"));
		String matKhau = request.getParameter("matkhau");
		NhanVienBO nhanVien = new NhanVienBO();
		nhanVien.updateNhanVien(maNhanVien, hoTen, diaChi, soDienThoai, luong, matKhau);
		
		
		
		response.sendRedirect("NhanVienServlet");
	}

}
