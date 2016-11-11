package model.bean;

public class GiaVe {

	private int maGiaVe;
	private String tenNhaXe;
	private String diaChi;
	private int xeDapNgayThuong;
	private int xeDapCuoiTuan;
	private int xeDapQuaDem;
	private int xeMayNgayThuong;
	private int xeMayCuoiTuan;
	private int xeMayQuaDem;
    
	public GiaVe(int maGiaVe, String tenNhaXe, String diaChi, int xeDapNgayThuong, int xeDapCuoiTuan, int xeDapQuaDem,
			int xeMayNgayThuong, int xeMayCuoiTuan, int xeMayQuaDem) {
		this.maGiaVe = maGiaVe;
		this.tenNhaXe = tenNhaXe;
		this.diaChi = diaChi;
		this.xeDapNgayThuong = xeDapNgayThuong;
		this.xeDapCuoiTuan = xeDapCuoiTuan;
		this.xeDapQuaDem = xeDapQuaDem;
		this.xeMayNgayThuong = xeMayNgayThuong;
		this.xeMayCuoiTuan = xeMayCuoiTuan;
		this.xeMayQuaDem = xeMayQuaDem;
	}
	public GiaVe(int maGiaVe, String tenNhaX, int xeDapNgayThuong, int xeDapCuoiTuan, int xeDapQuaDem,
			int xeMayNgayThuong, int xeMayCuoiTuan, int xeMayQuaDem) {
		this.maGiaVe = maGiaVe;
		this.tenNhaXe = tenNhaXe;
		this.xeDapNgayThuong = xeDapNgayThuong;
		this.xeDapCuoiTuan = xeDapCuoiTuan;
		this.xeDapQuaDem = xeDapQuaDem;
		this.xeMayNgayThuong = xeMayNgayThuong;
		this.xeMayCuoiTuan = xeMayCuoiTuan;
		this.xeMayQuaDem = xeMayQuaDem;
	}
	public GiaVe(int maGiaVe, int xeDapNgayThuong, int xeDapCuoiTuan, int xeDapQuaDem,
			int xeMayNgayThuong, int xeMayCuoiTuan, int xeMayQuaDem) {
		this.maGiaVe = maGiaVe;
		this.xeDapNgayThuong = xeDapNgayThuong;
		this.xeDapCuoiTuan = xeDapCuoiTuan;
		this.xeDapQuaDem = xeDapQuaDem;
		this.xeMayNgayThuong = xeMayNgayThuong;
		this.xeMayCuoiTuan = xeMayCuoiTuan;
		this.xeMayQuaDem = xeMayQuaDem;
	}

	public GiaVe() {
		// TODO Auto-generated constructor stub
	}

	public int getMaGiaVe() {
		return maGiaVe;
	}

	public void setMaGiaVe(int maGiaVe) {
		this.maGiaVe = maGiaVe;
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

	public int getXeDapNgayThuong() {
		return xeDapNgayThuong;
	}

	public void setXeDapNgayThuong(int xeDapNgayThuong) {
		this.xeDapNgayThuong = xeDapNgayThuong;
	}

	public int getXeDapCuoiTuan() {
		return xeDapCuoiTuan;
	}

	public void setXeDapCuoiTuan(int xeDapCuoiTuan) {
		this.xeDapCuoiTuan = xeDapCuoiTuan;
	}

	public int getXeDapQuaDem() {
		return xeDapQuaDem;
	}

	public void setXeDapQuaDem(int xeDapQuaDem) {
		this.xeDapQuaDem = xeDapQuaDem;
	}

	public int getXeMayNgayThuong() {
		return xeMayNgayThuong;
	}

	public void setXeMayNgayThuong(int xeMayNgayThuong) {
		this.xeMayNgayThuong = xeMayNgayThuong;
	}

	public int getXeMayCuoiTuan() {
		return xeMayCuoiTuan;
	}

	public void setXeMayCuoiTuan(int xeMayCuoiTuan) {
		this.xeMayCuoiTuan = xeMayCuoiTuan;
	}

	public int getXeMayQuaDem() {
		return xeMayQuaDem;
	}

	public void setXeMayQuaDem(int xeMayQuaDem) {
		this.xeMayQuaDem = xeMayQuaDem;
	}

	@Override
	public String toString() {
		return maGiaVe + "; " + tenNhaXe + "; " + diaChi + "; " + xeDapNgayThuong + ";" + xeDapCuoiTuan + ";"
				+ xeDapQuaDem + ";" + xeMayNgayThuong + ";" + xeMayCuoiTuan + ";" + xeMayQuaDem + ";";
	}

}
