package model.bean;

//enum CapDo {
//	admin("admin"), staff("staff");
//
//	private final String value;
//
//	private CapDo(String value) {
//		this.value = value;
//	}
//
//	public String getValue() {
//		return this.value;
//	}
//}

public class TaiKhoan {
	private int maTaiKhoan;
	private String tenTaiKhoan;
	private String matKhau;
	private String capDo;
	
	public TaiKhoan(String tenTaiKhoan, String matKhau,
			String capDo) {
		this.tenTaiKhoan = tenTaiKhoan;
		this.matKhau = matKhau;
		this.capDo = capDo;	
	}
	
	
	public TaiKhoan(int maTaiKhoan, String tenTaiKhoan, String matKhau,
			String capDo) {
		this.maTaiKhoan= maTaiKhoan;
		this.tenTaiKhoan = tenTaiKhoan;
		this.matKhau = matKhau;
		this.capDo = capDo;
	}
	

	
	public int getMaTaiKhoan() {
		return maTaiKhoan;
	}


	public void setMaTaiKhoan(int maTaiKhoan) {
		this.maTaiKhoan = maTaiKhoan;
	}


	public String getTenTaiKhoan() {
		return tenTaiKhoan;
	}


	public void setTenTaiKhoan(String tenTaiKhoan) {
		this.tenTaiKhoan = tenTaiKhoan;
	}


	public String getMatKhau() {
		return matKhau;
	}


	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}


	public String getCapDo() {
		return capDo;
	}


	public void setCapDo(String capDo) {
		this.capDo = capDo;
	}


	@Override
	public String toString() {
		return maTaiKhoan + "; " + tenTaiKhoan + "; " + matKhau + "; " + capDo;
	}
}
