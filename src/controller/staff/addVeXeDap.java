package controller.staff;

import java.io.IOException;
import java.util.ArrayList;

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
 * Servlet implementation class addVeXeDap
 */
@WebServlet("/addVeXeDap")
public class addVeXeDap extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addVeXeDap() {
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
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/plain; charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		
		VeXeBO veXeBO = new VeXeBO();
		veXeBO.addVeXeDap();
		
		VeXe veXe = VeXeBO.getVeXe();
		NhaXeBO nxBO = new NhaXeBO();
		int soChoTrong = nxBO.soChoTrong();
		request.setAttribute("soChoTrong", soChoTrong);
		
		ArrayList<String> anhXeDap = new ArrayList<String>();
		anhXeDap.add(request.getContextPath() + "/Resources/images/xedap/xedap1.jpg");
		anhXeDap.add(request.getContextPath() + "/Resources/images/xedap/xedap2.jpg");
		anhXeDap.add(request.getContextPath() + "/Resources/images/xedap/xedap3.jpg");
		anhXeDap.add(request.getContextPath() + "/Resources/images/xedap/xedap4.jpg");
		anhXeDap.add(request.getContextPath() + "/Resources/images/xedap/xedap5.jpg");
		anhXeDap.add(request.getContextPath() + "/Resources/images/xedap/xedap6.jpg");
		anhXeDap.add(request.getContextPath() + "/Resources/images/xedap/xedap7.jpg");
		anhXeDap.add(request.getContextPath() + "/Resources/images/xedap/xedap8.jpg");
		anhXeDap.add(request.getContextPath() + "/Resources/images/xedap/xedap9.jpg");
		anhXeDap.add(request.getContextPath() + "/Resources/images/xedap/xedap10.jpg");
		int soXeDap = anhXeDap.size();
		request.setAttribute("soXeDap", soXeDap);
		request.setAttribute("anhXeDap", anhXeDap);
		
	    request.setAttribute("veXe", veXe);
	    RequestDispatcher rd = request.getRequestDispatcher("/staff/QuanLyXe.jsp");
	    rd.forward(request, response);
	}

}
