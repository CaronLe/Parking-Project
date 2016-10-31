package controller.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.NhaXe;
import model.bo.NhaXeBO;

/**
 * Servlet implementation class showThoiGianDongMo
 */
@WebServlet("/showThoiGianDongMo")
public class showThoiGianDongMo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public showThoiGianDongMo() {
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
		
		NhaXeBO nxBO = new NhaXeBO();
		ArrayList<NhaXe> nhaXeList = null;
		nhaXeList = nxBO.getThoiGianDongMoCua();
		request.setAttribute("nhaXeList", nhaXeList);
		
		RequestDispatcher rd = request.getRequestDispatcher("/admin/QLThoiGianDongMoCua.jsp");
		rd.forward(request, response);
	}

}
