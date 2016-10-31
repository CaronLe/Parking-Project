package utils;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.TaiKhoan;


public class MyUtils {

	/**
	 * <h1>storeLoginedTaiKhoan</h1> Luu thong tin TaiKhoan vao session
	 * 
	 * @param session
	 * @param loginedTaiKhoan
	 *            Thong tin Tai Khoan can luu
	 */
	public static void storeLoginedTaiKhoan(HttpSession session,
			TaiKhoan loginedTaiKhoan) {
		session.setAttribute("LoginedTaiKhoan", loginedTaiKhoan);
	}

	/**
	 * <h1>getLoginedTaiKhoan</h1> Lay thong tin TaiKhoan tu session
	 * 
	 * @param session
	 * @return loginedTaiKhoan TaiKhoan from session
	 */
	public static TaiKhoan getLoginedTaiKhoan(HttpSession session) {
		TaiKhoan loginedTaiKhoan = (TaiKhoan) session.getAttribute("LoginedTaiKhoan");
		return loginedTaiKhoan;
	}

	/**
	 * <h1>invalidateSesstion</h1> Xoa session
	 * 
	 * @param arg
	 *            session
	 * @return No return value.
	 */
	public static void invalidateSesstion(HttpSession session) {
		System.out.println("MyUtils invalidateSesstion 77 : duoc goi");
		session.invalidate();
	}

	/**
	 * <h1>forward</h1> Chuyen trang
	 * 
	 * @param servletContext
	 * @param request
	 * @param response
	 * @param url
	 * @throws IOException
	 * @throws ServletException
	 * 
	 */
	public static void forward(ServletContext servletContext,
			HttpServletRequest request, HttpServletResponse response, String url)
			throws ServletException, IOException {
		RequestDispatcher rd = servletContext.getRequestDispatcher(url);
		rd.forward(request, response);
	}
}
