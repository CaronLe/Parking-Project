package controller.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.bo.NhanVienBO;
import model.bo.TaiKhoanBO;
import model.dao.NhanVienDAO;

/**
 * Servlet implementation class ThemNhanVienServlet
 */
@WebServlet("/ThemNhanVienServlet")
@MultipartConfig(maxFileSize=16177215)
public class ThemNhanVienServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThemNhanVienServlet() {
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
		
		PrintWriter out = response.getWriter();
		String nut = request.getParameter("ok");
		if(nut!=null){
			TaiKhoanBO tkBO = new TaiKhoanBO();
			NhanVienBO nvBO = new NhanVienBO();
			
			String tenTaiKhoan = request.getParameter("taikhoan");
			boolean tk = tkBO.checkTaiKhoan(tenTaiKhoan);
			if(tk==true){
				String matKhau = request.getParameter("matkhau");
				String hoTen = request.getParameter("hoten");
				String diaChi = request.getParameter("diachi");
				String soDienThoai = request.getParameter("sodienthoai");
				int luong = Integer.parseInt(request.getParameter("luong"));
				String maNhaXe = request.getParameter("manhaxe");
				Part filePart = request.getPart("uploadFile");
				tkBO.insertTaiKhoan(tenTaiKhoan, matKhau);
				nvBO.insertNhanVien(tenTaiKhoan, hoTen, diaChi, soDienThoai, luong,maNhaXe,filePart);
				response.sendRedirect("NhanVienServlet");
			}
			else {
				String loi = "<strong>Error!</strong> Tài khoản đã có, vui lòng nhập lại";
				request.setAttribute("loi", loi);
				RequestDispatcher rd = request.getRequestDispatcher("admin/ThemNhanVien.jsp");
				rd.forward(request, response);
			 }
		}
		else {
			response.sendRedirect("admin/ThemNhanVien.jsp");
		}
	}
}
