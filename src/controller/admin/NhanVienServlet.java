package controller.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.NhanVien;
import model.bo.NhanVienBO;
import model.bo.TaiKhoanBO;

/**
 * Servlet implementation class NhanVienServlet
 */
@WebServlet("/NhanVienServlet")
public class NhanVienServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NhanVienServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/plain; charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		
		String suanv = request.getParameter("suanv");
		String xoanv = request.getParameter("xoanv");
		NhanVienBO nvBO = new NhanVienBO();
		if(suanv!=null||xoanv!=null){
			if(suanv!=null){
				int maNhanVien = Integer.parseInt(suanv);
				NhanVien obj = nvBO.getNhanVien(maNhanVien);
				request.setAttribute("obj", obj);
				RequestDispatcher rd = request.getRequestDispatcher("/admin/SuaNhanVien.jsp");
				rd.forward(request, response);
			}
			else if(xoanv!=null){
				TaiKhoanBO tkBO = new TaiKhoanBO();
				int maNhanVien = Integer.parseInt(xoanv);
			    int maTaiKhoan = nvBO.getMaTaiKhoan(maNhanVien);
			    nvBO.deleteNhanVien(maNhanVien);
			    tkBO.deleteTaiKhoan(maTaiKhoan);
			    
                response.sendRedirect("NhanVienServlet");
			}
		}
		else{
			ArrayList<NhanVien> allNhanVien = nvBO.getAllNhanVien();
			request.setAttribute("allNhanVien", allNhanVien);
			RequestDispatcher rd = request.getRequestDispatcher("/admin/QLNhanVien.jsp");
			rd.forward(request, response);
		}
	}
}
