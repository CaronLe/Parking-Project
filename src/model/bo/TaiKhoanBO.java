package model.bo;

import model.bean.TaiKhoan;
import model.dao.TaiKhoanDAO;

public class TaiKhoanBO {
	TaiKhoanDAO tkDao = new TaiKhoanDAO();
	public TaiKhoan getTheoTenTaiKhoanVaMatKhau(String tenTaiKhoan, String matKhau) {
		return tkDao.getTheoTenTaiKhoanVaMatKhau(tenTaiKhoan, matKhau);
	}
}
