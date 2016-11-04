package model.bean;

import java.sql.Time;

public class VeXe {
	private int maVeXe;
	private String maNhaXe;
	private String loaiXe;
	private Time thoiGianVao;
	private Time thoiGianRa;
	private Boolean trangThai;
	private String anhXe;
	private int giaTien;

	public VeXe(int maVeXe, String maNhaXe, String loaiXe, Time thoiGianVao, Time thoiGianRa, boolean trangThai,
			String anhXe, int giaTien) {
		this.maVeXe = maVeXe;
		this.maNhaXe = maNhaXe;
		this.loaiXe = loaiXe;
		this.thoiGianVao = thoiGianVao;
		this.thoiGianRa = thoiGianRa;
		this.trangThai = trangThai;
		this.anhXe = anhXe;
		this.giaTien = giaTien;

	}

	public int getMaVeXe() {
		return maVeXe;
	}

	public void setMaVeXe(int maVeXe) {
		this.maVeXe = maVeXe;
	}

	public String getMaNhaXe() {
		return maNhaXe;
	}

	public void setMaNhaXe(String maNhaXe) {
		this.maNhaXe = maNhaXe;
	}

	public String getLoaiXe() {
		return loaiXe;
	}

	public void setLoaiXe(String loaiXe) {
		this.loaiXe = loaiXe;
	}

	public Time getThoiGianVao() {
		return thoiGianVao;
	}

	public void setThoiGianVao(Time thoiGianVao) {
		this.thoiGianVao = thoiGianVao;
	}

	public Time getThoiGianRa() {
		return thoiGianRa;
	}

	public void setThoiGianRa(Time thoiGianRa) {
		this.thoiGianRa = thoiGianRa;
	}

	public Boolean getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(Boolean trangThai) {
		this.trangThai = trangThai;
	}

	public String getAnhXe() {
		return anhXe;
	}

	public void setAnhXe(String anhXe) {
		this.anhXe = anhXe;
	}

	public int getGiaTien() {
		return giaTien;
	}

	public void setGiaTien(int giaTien) {
		this.giaTien = giaTien;
	}

	@Override
	public String toString() {
		return maVeXe + "; " + maNhaXe + "; " + loaiXe +"; " + thoiGianVao+";"+ thoiGianRa+";"+ trangThai+";"+ anhXe+";"+ giaTien+";";
	}
	
	
}
