package controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.GiaVe;
import model.bo.GiaVeBO;

/**
 * Servlet implementation class NhaXe_SuaGiaVe
 */
@WebServlet("/NhaXe_SuaGiaVe")
public class NhaXe_SuaGiaVe extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NhaXe_SuaGiaVe() {
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
		// set utf-8
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/plain; charset=utf-8");
		response.setCharacterEncoding("UTF-8");

		GiaVeBO giaVeBO = new GiaVeBO();
		String maGiaVe = (String) request.getParameter("id");
		if (request.getParameter("errorFlag") != null)
			request.setAttribute("errorFlag", request.getParameter("errorFlag"));
		GiaVe giave = null;
		String errorString = null;
		try {
			int mGiaVe = Integer.parseInt(maGiaVe);
			giave = giaVeBO.getGiaVeTheoMaGiaVe(mGiaVe);
		} catch (Exception e) {
			e.printStackTrace();
			errorString = e.getMessage();
		}
		if (giave == null || errorString != null) {
			response.sendRedirect(request.getContextPath() + "/showGiaVe");
			return;
		}
		request.setAttribute("giaVeByID", giave);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin/SuaGiaVe.jsp");
		rd.forward(request, response);
	}

}
