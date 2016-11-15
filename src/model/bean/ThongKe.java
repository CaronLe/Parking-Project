package model.bean;

public class ThongKe {

	private int soLuotRa;
	private int soLuotVao;
	private int tongTien;
	private String ngayThongKe;
    
	public ThongKe(){
		super();
	}
	public ThongKe(int soluotra, int soluotvao, int tongtien) {
		this.soLuotRa = soluotra;
		this.soLuotVao = soluotvao;
		this.tongTien = tongtien;
		
	}
	public ThongKe(String ngayThongKe, int soluotra, int soluotvao, int tongtien) {
		this.ngayThongKe = ngayThongKe;
		this.soLuotRa = soluotra;
		this.soLuotVao = soluotvao;
		this.tongTien = tongtien;
		
	}

	public int getSoLuotRa() {
		return soLuotRa;
	}

	public void setSoLuotRa(int soLuotRa) {
		this.soLuotRa = soLuotRa;
	}

	public int getSoLuotVao() {
		return soLuotVao;
	}

	public void setSoLuotVao(int soLuotVao) {
		this.soLuotVao = soLuotVao;
	}

	public int getTongTien() {
		return tongTien;
	}

	public void setTongTien(int tongTien) {
		this.tongTien = tongTien;
	}
	public String getNgayThongKe() {
		return ngayThongKe;
	}

	public void setNgayThongKe(String ngayThongKe) {
		this.ngayThongKe = ngayThongKe;
	}
	
	
}
