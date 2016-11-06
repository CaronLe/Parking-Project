package controller.admin;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.FileAnhBO;
import model.dao.FileAnhDAO;

/**
 * Servlet implementation class ExportFileServlet
 */
@WebServlet("/ExportFileServlet")
public class ExportFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExportFileServlet() {
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
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/plain; charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		
		int id=Integer.parseInt(request.getParameter("id"));
		FileAnhBO anhBO = new FileAnhBO();
		byte[] file = anhBO.exportAnh(id);
		response.setContentType("image/jpg");
        response.setHeader("Content-Disposition", "inline");
        response.setContentLength(file.length);
        
        OutputStream output = response.getOutputStream();
        output.write(file);
        output.flush();
		//RequestDispatcher rd = request.getRequestDispatcher("XemAnh.jsp");
//		rd.forward(request, response)
	}

}
