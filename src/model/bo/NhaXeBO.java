package model.bo;

import java.util.ArrayList;

import model.bean.NhaXe;
import model.dao.NhaXeDAO;

public class NhaXeBO {
	NhaXeDAO nxDAO = new NhaXeDAO();

	public ArrayList<NhaXe> getSoLuongXe() {
		return nxDAO.getSoLuongXe();
	}
	
	public ArrayList<NhaXe> getThoiGianDongMoCua() {
		return nxDAO.getThoiGianDongMoCua();
	}
	
	public NhaXe getNhaXeTheoMaNX_SoLuong(String maNhaXe) {
		return nxDAO.getNhaXeTheoMaNX_SoLuong(maNhaXe);
	}
	
	public NhaXe getNhaXeTheoMaNX_ThoiGian(String maNhaXe) {
		return nxDAO.getNhaXeTheoMaNX_ThoiGian(maNhaXe);
	}
	
	public int updateSoLuongXe(NhaXe nx) {
		return nxDAO.updateSoLuongXe(nx);
	}
	
	public int updateThoiGianDongMoCua(NhaXe tg) {
		return nxDAO.updateThoiGianDongMoCua(tg);
	}
	public int soChoTrong(){
		return nxDAO.soChoTrong();
	}
}
