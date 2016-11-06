package model.bo;

import java.util.ArrayList;

import javax.servlet.http.Part;

import model.bean.NhanVien;
import model.dao.NhanVienDAO;

public class NhanVienBO {
    NhanVienDAO nv = new NhanVienDAO();
    public ArrayList<NhanVien> getAllNhanVien(){
    	return nv.getAllNhanVien();
    }
    public NhanVien getNhanVien(int maNhanVien){
    	return nv.getNhanVien(maNhanVien);
    }
    public void deleteNhanVien(int maNhanVien){
    	nv.deleteNhanVien(maNhanVien);
    }
    public void updateNhanVien(int maNhanVien,String hoTen,String diaChi,String soDienThoai,int luong,String maNhaXe,String matKhau){
    	nv.updateNhanVien(maNhanVien, hoTen, diaChi, soDienThoai, luong, maNhaXe, matKhau);
    }
    public void insertNhanVien(String tenTaiKhoan,String hoTen,String diaChi,String soDienThoai,int luong,String maNhaXe,Part filePart){
    	nv.insertNhanVien(tenTaiKhoan, hoTen, diaChi, soDienThoai, luong,maNhaXe,filePart);
    }
    public int getMaTaiKhoan(int maNhanVien){
    	return nv.getMaTaiKhoan(maNhanVien);
    }
}
