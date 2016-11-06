package model.bo;

import model.bean.TaiKhoan;
import model.dao.TaiKhoanDAO;

public class TaiKhoanBO {
	TaiKhoanDAO tkDao = new TaiKhoanDAO();
	public TaiKhoan getTheoTenTaiKhoanVaMatKhau(String tenTaiKhoan, String matKhau) {
		return tkDao.getTheoTenTaiKhoanVaMatKhau(tenTaiKhoan, matKhau);
	}
	public boolean checkTaiKhoan(String tk){
		return tkDao.checkTaiKhoan(tk);
	}
	public void insertTaiKhoan(String tenTaiKhoan,String matKhau){
		tkDao.insertTaiKhoan(tenTaiKhoan, matKhau);
	}
	public void deleteTaiKhoan(int maTaiKhoan){
		tkDao.deleteTaiKhoan(maTaiKhoan);
	}
}
