package model.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.Part;

import model.bean.NhanVien;

public class NhanVienDAO {
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private NhanVien obj = null;

	public ArrayList<NhanVien> getAllNhanVien() {
		ArrayList<NhanVien> all = new ArrayList<NhanVien>();
		String sql = "select * from NhanVien AS nv,TaiKhoan AS tk where nv.MaTaiKhoan=tk.MaTaiKhoan";
		con = SQLConnection.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int maNV = Integer.parseInt(rs.getString("MaNhanVien"));
				int maTK = Integer.parseInt(rs.getString("MaTaiKhoan"));
				String maNX = rs.getString("MaNhaXe");
				String hoTen = rs.getString("HoTen");
				String diaChi = rs.getString("DiaChi");
				String soDienThoai = rs.getString("SoDienThoai");
				int luongNV = Integer.parseInt(rs.getString("LuongNhanVien"));
				String taiKhoan = rs.getString("TenTaiKhoan");
				String matKhau = rs.getString("MatKhau");
				obj = new NhanVien(maNV, maTK, maNX, hoTen, diaChi, soDienThoai, luongNV, taiKhoan, matKhau);
				all.add(obj);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			SQLConnection.closeConnection(con);
			SQLConnection.closePrepareStatement(pstmt);
			SQLConnection.closeResultSet(rs);
		}
		return all;
	}

	public NhanVien getNhanVien(int maNhanVien) {
		con = SQLConnection.getConnection();
		String sql = "select * from NhanVien as nv,TaiKhoan as tk where nv.MaTaiKhoan=tk.MaTaiKhoan and nv.MaNhanVien=" + maNhanVien;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int maNV = Integer.parseInt(rs.getString("MaNhanVien"));
				int maTK = Integer.parseInt(rs.getString("MaTaiKhoan"));
				String maNX = rs.getString("MaNhaXe");
				String hoTen = rs.getString("HoTen");
				String diaChi = rs.getString("DiaChi");
				String soDienThoai = rs.getString("SoDienThoai");
				int luongNV = Integer.parseInt(rs.getString("LuongNhanVien"));
				String taiKhoan = rs.getString("TenTaiKhoan");
				String matKhau = rs.getString("MatKhau");
				obj = new NhanVien(maNV, maTK, maNX, hoTen, diaChi, soDienThoai, luongNV, taiKhoan, matKhau);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			SQLConnection.closeConnection(con);
			SQLConnection.closePrepareStatement(pstmt);
			SQLConnection.closeResultSet(rs);
		}
		return obj;
	}
	public void deleteNhanVien(int maNhanVien){
		con = SQLConnection.getConnection();
		String sql = "delete from NhanVien where MaNhanVien="+maNhanVien;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			SQLConnection.closeConnection(con);
			SQLConnection.closePrepareStatement(pstmt);
			SQLConnection.closeResultSet(rs);
		}
	}
	public void updateNhanVien(int maNhanVien,String hoTen,String diaChi,String soDienThoai,int luong,String maNhaXe,String matKhau){
		con = SQLConnection.getConnection();
		int maTaiKhoan = 0;
		String sql = "select MaTaiKhoan from NhanVien where MaNhanVien="+maNhanVien;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				maTaiKhoan = Integer.parseInt(rs.getString("MaTaiKhoan"));
			}
			String sql1 = "update TaiKhoan set MatKhau='"+matKhau+"' where MaTaiKhoan="+maTaiKhoan;
			String sql2 = "update NhanVien set HoTen=N'"+hoTen+"',DiaChi=N'"+diaChi+"',SoDienThoai='"+soDienThoai+"',LuongNhanVien="+luong+",MaNhaXe='"+maNhaXe+"' where MaTaiKhoan="+maTaiKhoan;
			System.out.println(sql2);
			pstmt = con.prepareStatement(sql1);
			pstmt.executeUpdate();
			pstmt = con.prepareStatement(sql2);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			SQLConnection.closeConnection(con);
			SQLConnection.closePrepareStatement(pstmt);
			SQLConnection.closeResultSet(rs);
		}
	}
	public void insertNhanVien(String tenTaiKhoan,String hoTen,String diaChi,String soDienThoai,int luong,String maNhaXe,Part filePart){
		con = SQLConnection.getConnection();
		String sql = "select MaTaiKhoan from TaiKhoan where TenTaiKhoan='"+tenTaiKhoan+"'";
		int maTaiKhoan=0;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				maTaiKhoan = rs.getInt("MaTaiKhoan");
				System.out.println(maTaiKhoan);
			}
			String sql1 = "insert into NhanVien(MaTaiKhoan,HoTen,DiaChi,SoDienThoai,LuongNhanVien,MaNhaXe,Anh) values(?,?,?,?,?,?,?)";
			InputStream in = null;
			if(filePart!=null){	
				System.out.println(filePart.getName());
				System.out.println(filePart.getSize());
				System.out.println(filePart.getContentType());
				in = filePart.getInputStream();
		     }
			pstmt = con.prepareStatement(sql1);
			if(in!=null){
				pstmt.setInt(1, maTaiKhoan);
				pstmt.setString(2, hoTen);
				pstmt.setString(3, diaChi);
				pstmt.setString(4, soDienThoai);
				pstmt.setInt(5, luong);
				pstmt.setString(6, maNhaXe);
				pstmt.setBinaryStream(7, in, (int)filePart.getSize());
				int row = pstmt.executeUpdate();
				if(row==0)System.out.println("Loi");
				con.commit();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			SQLConnection.closeConnection(con);
			SQLConnection.closePrepareStatement(pstmt);
			SQLConnection.closeResultSet(rs);
		}
	}
	public int getMaTaiKhoan(int maNhanVien){
		con = SQLConnection.getConnection();
		String sql = "select MaTaiKhoan from NhanVien where MaNhanVien="+maNhanVien;
		int maTaiKhoan = 0;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				maTaiKhoan = rs.getInt("MaTaiKhoan");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			SQLConnection.closeConnection(con);
			SQLConnection.closePrepareStatement(pstmt);
			SQLConnection.closeResultSet(rs);
		}
		return maTaiKhoan;
	}
}
