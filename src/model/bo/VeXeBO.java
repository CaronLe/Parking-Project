package model.bo;

import model.bean.VeXe;
import model.dao.VeXeDAO;

public class VeXeBO {
	static VeXeDAO vxDAO = new VeXeDAO();

	public void addVeXeDap() {
		vxDAO.addVeXeDap();
	}

	public void addVeXeMay() {
		vxDAO.addVeXeMay();
	}

	public static VeXe getVeXe() {
		return vxDAO.getVeXe();
	}

	public static VeXe getVeXeRa(int maVeXe) {
		return vxDAO.getVeXeRa(maVeXe);
	}

	public static void updateVeXe(int maVeXe) {
		vxDAO.updateVeXe(maVeXe);
	}

}
