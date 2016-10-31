package model.bo;

import java.util.ArrayList;

import model.bean.GiaVe;
import model.dao.GiaVeDAO;

public class GiaVeBO {
	GiaVeDAO gvDAO = new GiaVeDAO();
	public ArrayList<GiaVe> getGiaVeTheoNhaXe() {
		return gvDAO.getGiaVeTheoNhaXe();
	}
	public GiaVe getGiaVeTheoMaGiaVe(int maGiaVe) {
		return gvDAO.getGiaVeTheoMaGiaVe(maGiaVe);
	}
	public int updateGiaVeTheoMaGiaVe(GiaVe gv) {
		return gvDAO.updateGiaVeTheoMaGiaVe(gv);
	}

}
