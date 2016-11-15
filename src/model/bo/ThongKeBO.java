package model.bo;

import model.bean.ThongKe;
import model.dao.ThongKeDAO;

public class ThongKeBO {
	static ThongKeDAO thongKeDAO = new ThongKeDAO();
	public static ThongKe getThongKeTheoNgay() {
		return thongKeDAO.getThongKeTheoNgay();
	}
//	public static ThongKe getThongKeAdmin(int ngay, int thang, int nam) {
//		return thongKeDAO.getThongKeAdmin(ngay,thang,nam);
//	}
}
