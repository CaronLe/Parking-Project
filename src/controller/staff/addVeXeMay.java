package controller.staff;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;

import model.bean.VeXe;
import model.bo.NhaXeBO;
import model.bo.VeXeBO;

/**
 * Servlet implementation class addVeXeDap
 */
@WebServlet("/addVeXeMay")
public class addVeXeMay extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addVeXeMay() {
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
		veXeBO.addVeXeMay();
		
		NhaXeBO nxBO = new NhaXeBO();
		int soChoTrong = nxBO.soChoTrong();
		request.setAttribute("soChoTrong", soChoTrong);
		
		ArrayList<String> anhXeMay = new ArrayList<String>();
		anhXeMay.add(request.getContextPath() + "/Resources/images/xemay/anh1.jpg");
		anhXeMay.add(request.getContextPath() + "/Resources/images/xemay/anh2.jpg");
		anhXeMay.add(request.getContextPath() + "/Resources/images/xemay/anh3.jpg");
		anhXeMay.add(request.getContextPath() + "/Resources/images/xemay/anh4.jpg");
		anhXeMay.add(request.getContextPath() + "/Resources/images/xemay/anh5.jpg");
		anhXeMay.add(request.getContextPath() + "/Resources/images/xemay/anh6.jpg");
		anhXeMay.add(request.getContextPath() + "/Resources/images/xemay/anh7.jpg");
		anhXeMay.add(request.getContextPath() + "/Resources/images/xemay/anh8.jpg");
		anhXeMay.add(request.getContextPath() + "/Resources/images/xemay/anh9.jpg");
		anhXeMay.add(request.getContextPath() + "/Resources/images/xemay/anh10.jpg");
		int soXeMay = anhXeMay.size();
		request.setAttribute("soXeMay", soXeMay);
		request.setAttribute("anhXeMay", anhXeMay);
		
	    VeXe veXe = VeXeBO.getVeXe();
	    System.out.println(veXe.getMaVeXe());
	    request.setAttribute("veXe", veXe);
	    RequestDispatcher rd = request.getRequestDispatcher("/staff/QuanLyXe.jsp");
	    rd.forward(request, response);
	}

}
