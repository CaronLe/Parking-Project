package controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.NhaXe;
import model.bo.NhaXeBO;

/**
 * Servlet implementation class NhaXe_SuaThoiGianDongMoCua
 */
@WebServlet("/NhaXe_SuaThoiGianDongMoCua")
public class NhaXe_SuaThoiGianDongMoCua extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NhaXe_SuaThoiGianDongMoCua() {
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
 		// set utf-8
 		request.setCharacterEncoding("UTF-8");
 		response.setContentType("text/plain; charset=utf-8");
 		response.setCharacterEncoding("UTF-8");
 		
 		NhaXeBO nhaXeBO = new NhaXeBO();
 		String maNhaXe = (String)request.getParameter("id");
 		if(request.getParameter("errorFlag")!=null)
 			request.setAttribute("errorFlag", request.getParameter("errorFlag"));
 		NhaXe nhaxe=null;
 		String errorString = null;
 		try{
 			
 			nhaxe = nhaXeBO.getNhaXeTheoMaNX_ThoiGian(maNhaXe);
 		}catch(Exception e){
 			e.printStackTrace();
 			errorString = e.getMessage();
 		}
 		if(nhaxe==null||errorString!=null){
 			response.sendRedirect(request.getContextPath()+"/showThoiGianDongMo");
 			return;
 		}
 		request.setAttribute("nhaXeByID", nhaxe);
 		RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin/SuaThoiGianDongMoCua.jsp");
 		rd.forward(request, response);
 	}

 }
