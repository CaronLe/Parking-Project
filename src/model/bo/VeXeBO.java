package model.bo;

import model.bean.VeXe;
import model.dao.VeXeDAO;

public class VeXeBO {
	VeXeDAO vxDAO = new VeXeDAO();

	public VeXe getVeXeTheoMaVeXe_XeMay(String maVeXe) {
		return vxDAO.getVeXeTheoMaVeXe_XeMay(maVeXe);
	}
	
	public VeXe getVeXeTheoMaVeXe_XeDap(String maVeXe) {
		return vxDAO.getVeXeTheoMaVeXe_XeDap(maVeXe);
	}
}
