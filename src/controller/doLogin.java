package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.TaiKhoan;
import model.bo.TaiKhoanBO;
import utils.MyUtils;

/**
 * Servlet implementation class doGVLogin
 */
//@WebServlet("/doLogin")
public class doLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doLogin() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// kiem tra dang nhap
		TaiKhoanBO tkBO = new TaiKhoanBO();
		
		String tenTaiKhoan = request.getParameter("tenTaiKhoan");
		String matKhau = request.getParameter("matKhau");
		
		TaiKhoan tk = tkBO.getTheoTenTaiKhoanVaMatKhau(tenTaiKhoan, matKhau);
		
		if (tk != null) {
			// luu TaiKhoan vao session
			MyUtils.storeLoginedTaiKhoan(request.getSession(), tk);

			// chuyen trang theo CapDo
						if("admin".equals(tk.getCapDo())) {
							response.sendRedirect(request.getContextPath() + "/showAdmin");  // Demo - thuc te se tro toi AdminServlet 
						} else {
							response.sendRedirect(request.getContextPath() + "/showStaff");    // - thuc te  se tro toi StaffSevlet
						}
						
					} else {
						// o lai trang login
						response.sendRedirect(request.getContextPath() + "/Login.jsp");
					}
					
					
				}

			}
