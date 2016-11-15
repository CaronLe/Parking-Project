package controller.staff;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.ThongKeBO;
import model.bean.ThongKe;

/**
 * Servlet implementation class thongKeServlet
 */
@WebServlet("/thongKeServlet")
public class thongKeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public thongKeServlet() {
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

		ThongKe thongKe1 = new ThongKe();
		thongKe1 = ThongKeBO.getThongKeTheoNgay();

		RequestDispatcher rd = request.getRequestDispatcher("/staff/ThongKe.jsp");
		rd.forward(request, response);

	}
	public static void main(String[] args) {
		ThongKe tk = new ThongKe();
		System.out.println(tk.getSoLuotVao());
	}
}
