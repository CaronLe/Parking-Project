package controller.staff;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.VeXe;
import model.bo.NhaXeBO;
import model.bo.VeXeBO;

/**
 * Servlet implementation class tinhTienServlet
 */
@WebServlet("/tinhTienServlet")
public class tinhTienServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public tinhTienServlet() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/plain; charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		
		int maVeXe = 0;
		if(request.getParameter("mavexe")!=null||request.getParameter("mavexe")!=""){
			maVeXe = Integer.parseInt(request.getParameter("mavexe"));
			VeXeBO.updateVeXe(maVeXe);
			VeXe veXe = VeXeBO.getVeXeRa(maVeXe);
			request.setAttribute("veXeRa", veXe);
		}
		
		
		NhaXeBO nxBO = new NhaXeBO();
		int soChoTrong = nxBO.soChoTrong();
		request.setAttribute("soChoTrong", soChoTrong);
		
		RequestDispatcher rd = request.getRequestDispatcher("/staff/QuanLyXe.jsp");
		rd.forward(request, response);
	}
}
