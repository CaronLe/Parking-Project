package controller.staff;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.VeXe;
import model.bo.VeXeBO;

/**
 * Servlet implementation class showVeXeMay
 */
@WebServlet("/showVeXeMay")
public class showVeXeMay extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public showVeXeMay() {
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

		VeXeBO veXeBO = new VeXeBO();
		String maVeXe = (String) request.getParameter("id");
		if (request.getParameter("errorFlag") != null)
			request.setAttribute("errorFlag", request.getParameter("errorFlag"));
		VeXe vexe = null;
		String errorString = null;
		try {
			vexe = veXeBO.getVeXeTheoMaVeXe_XeMay(maVeXe);
		} catch (Exception e) {
			e.printStackTrace();
			errorString = e.getMessage();
		}
		if (vexe == null || errorString != null) {
			response.sendRedirect(request.getContextPath() + "/showStaff");
			return;
		}
		request.setAttribute("veXeByID", vexe);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/staff/QuanLyXe.jsp");
		rd.forward(request, response);
	}

}
