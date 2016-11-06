package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.TaiKhoan;


public class TaiKhoanDAO {
	private String sqlTheoTenTaiKhoanVaMatKhau = "SELECT MaTaiKhoan, TenTaiKhoan, MatKhau, CapDo FROM TaiKhoan WHERE TenTaiKhoan = ? AND MatKhau = ?";
	
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private TaiKhoan TaiKhoan = null;
	
	public TaiKhoan getTheoTenTaiKhoanVaMatKhau(String tenTaiKhoan,String matKhau) {
		this.TaiKhoan = null;

		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlTheoTenTaiKhoanVaMatKhau);
			pstmt.setString(1, tenTaiKhoan);
			pstmt.setString(2, matKhau);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				TaiKhoan = new TaiKhoan(rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getString(4));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLConnection.closeConnection(this.con);
			SQLConnection.closePrepareStatement(pstmt);
			SQLConnection.closeResultSet(rs);
		}

		return this.TaiKhoan;
	}
	public boolean checkTaiKhoan(String tk){
		con = SQLConnection.getConnection();
		String sql  = "select TenTaiKhoan from TaiKhoan";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				if(tk.equals(rs.getString("TenTaiKhoan")))return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Loi cau lenh sql");
		}finally {
			SQLConnection.closeConnection(this.con);
			SQLConnection.closePrepareStatement(pstmt);
			SQLConnection.closeResultSet(rs);
		}
		return true;
	}
	public void insertTaiKhoan(String tenTaiKhoan,String matKhau){
		con = SQLConnection.getConnection();
		String sql = "insert into TaiKhoan(TenTaiKhoan,MatKhau,CapDo) values('"+tenTaiKhoan+"','"+matKhau+"','2')";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			SQLConnection.closeConnection(this.con);
			SQLConnection.closePrepareStatement(pstmt);
			SQLConnection.closeResultSet(rs);
		}
	}
	public void deleteTaiKhoan(int maTaiKhoan){
		con = SQLConnection.getConnection();
		String sql = "delete from TaiKhoan where MaTaiKhoan="+maTaiKhoan;
		try {
			pstmt =con.prepareStatement(sql);
			pstmt.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			SQLConnection.closeConnection(this.con);
			SQLConnection.closePrepareStatement(pstmt);
			SQLConnection.closeResultSet(rs);
		}
	}
}
