package model.bean;

public class NhanVien {
	private int maNV;
	private int maTK;
	private String maNX;
	private String hoTen;
	private String diaChi;
	private String soDienThoai;
	private int luongNV;
	private String taiKhoan;
	private String matKhau;

	public int getMaNV() {
		return maNV;
	}

	public void setMaNV(int maNV) {
		this.maNV = maNV;
	}

	public int getMaTK() {
		return maTK;
	}

	public void setMaTK(int maTK) {
		this.maTK = maTK;
	}

	public String getMaNX() {
		return maNX;
	}

	public void setMaNX(String maNX) {
		this.maNX = maNX;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public int getLuongNV() {
		return luongNV;
	}

	public void setLuongNV(int luongNV) {
		this.luongNV = luongNV;
	}
	
    public String getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(String taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public NhanVien(){
    	super();
    }

	public NhanVien(int maNV, int maTK, String maNX, String hoTen, String diaChi, String soDienThoai, int luongNV,
			String taiKhoan, String matKhau) {
		super();
		this.maNV = maNV;
		this.maTK = maTK;
		this.maNX = maNX;
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
		this.luongNV = luongNV;
		this.taiKhoan = taiKhoan;
		this.matKhau = matKhau;
	}
}
