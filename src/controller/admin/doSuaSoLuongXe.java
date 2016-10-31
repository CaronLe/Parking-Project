package controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.NhaXe;
import model.bo.NhaXeBO;
import utils.Validate;

/**
 * Servlet implementation class doSuaSoLuongXe
 */
@WebServlet("/doSuaSoLuongXe")
public class doSuaSoLuongXe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doSuaSoLuongXe() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// set utf-8
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/plain; charset=utf-8");
		response.setCharacterEncoding("UTF-8");


		String maNhaXe = (String) request.getParameter("maNhaXe");
		String tenNhaXe = (String) request.getParameter("tenNhaXe");
		String soLuongXe = (String)request.getParameter("soLuongXe");

		NhaXe nhaXe = new NhaXe();
		NhaXeBO nhaXeBO = new NhaXeBO();
		boolean errorFlag = false;

		// validate du lieu nhap vao
		if (!Validate.validateID(soLuongXe)) {
			errorFlag = true;
		}

		Integer sLuongXe = 0;
		try {
			sLuongXe = Integer.parseInt(soLuongXe);
			nhaXe.setMaNhaXe(maNhaXe);
			nhaXe.setTenNhaXe(tenNhaXe);
			nhaXe.setSoLuongXe(sLuongXe);
			
			System.out.println(nhaXe);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

		// Cap nhat thanh cong
		if (!errorFlag) {
			nhaXeBO.updateSoLuongXe(nhaXe);
			response.sendRedirect(request.getContextPath()
					+ "/showSoLuongXe");
		}
		
		// Du lieu vao khong dung
		else
			response.sendRedirect(request.getContextPath()
					+ "/NhaXe_SuaSoLuongXe?maNhaXe=" + maNhaXe
					+ "&errorFlag=" + errorFlag);
	}

}
