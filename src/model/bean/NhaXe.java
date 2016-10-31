package model.bean;

import java.sql.Time;

public class NhaXe {
	private String maNhaXe;
	private String tenNhaXe;
	private String diaChi;
	private int soLuongXe;
	private int choTrong;
	private Time thoiGianMo;
	private Time thoiGianDong;
	

	public NhaXe(String maNhaXe, String tenNhaXe,int soLuongXe) {
		this.maNhaXe = maNhaXe;
		this.tenNhaXe = tenNhaXe;
		this.soLuongXe = soLuongXe;
	}
	
	public NhaXe(String maNhaXe, String tenNhaXe, String diaChi, Time thoiGianMo, Time thoiGianDong ) {
		this.maNhaXe = maNhaXe;
		this.tenNhaXe = tenNhaXe;
		this.diaChi = diaChi;
		this.thoiGianMo = thoiGianMo;
		this.thoiGianDong = thoiGianDong;
		
	}
	
	public NhaXe(String maNhaXe, String tenNhaXe, String diaChi,int soLuongXe, int choTrong, Time thoiGianMo, Time thoiGianDong) {
		this.maNhaXe = maNhaXe;
		this.tenNhaXe = tenNhaXe;
		this.diaChi = diaChi;
		this.soLuongXe = soLuongXe;
		this.choTrong = choTrong;
		this.thoiGianMo = thoiGianMo;
		this.thoiGianDong = thoiGianDong;
	}


	public NhaXe() {
		// TODO Auto-generated constructor stub
	}

	public String getMaNhaXe() {
		return maNhaXe;
	}

	public void setMaNhaXe(String maNhaXe) {
		this.maNhaXe = maNhaXe;
	}

	public String getTenNhaXe() {
		return tenNhaXe;
	}

	public void setTenNhaXe(String tenNhaXe) {
		this.tenNhaXe = tenNhaXe;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public int getSoLuongXe() {
		return soLuongXe;
	}

	public void setSoLuongXe(int soLuongXe) {
		this.soLuongXe = soLuongXe;
	}

	public int getChoTrong() {
		return choTrong;
	}

	public void setChoTrong(int choTrong) {
		this.choTrong = choTrong;
	}

	public Time getThoiGianMo() {
		return thoiGianMo;
	}

	public void setThoiGianMo(Time thoiGianMo) {
		this.thoiGianMo = thoiGianMo;
	}

	public Time getThoiGianDong() {
		return thoiGianDong;
	}

	public void setThoiGianDong(Time thoiGianDong) {
		this.thoiGianDong = thoiGianDong;
	}

	@Override
	public String toString() {
		return maNhaXe + "; " + tenNhaXe + "; " + diaChi +"; " + soLuongXe+";"+ choTrong+";"+ thoiGianMo+";"+ thoiGianDong+";";
	}
}