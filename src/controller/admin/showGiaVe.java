package controller.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.GiaVe;
import model.bo.GiaVeBO;

/**
 * Servlet implementation class showGiaVe
 */
@WebServlet("/showGiaVe")
public class showGiaVe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public showGiaVe() {
        super();
        // TODO Auto-generated constructor stub
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
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/plain; charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		
		GiaVeBO gvBO = new GiaVeBO();
		ArrayList<GiaVe> giaVeList = null;
		giaVeList = gvBO.getGiaVeTheoNhaXe();
		request.setAttribute("giaVeList", giaVeList);
		
		RequestDispatcher rd = request.getRequestDispatcher("/admin/QLGiaVe.jsp");
		rd.forward(request, response);
	}

}
