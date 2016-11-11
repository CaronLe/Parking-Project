package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.GiaVe;

public class GiaVeDAO {
	private String sqlGiaVeTheoNhaXe = "SELECT MaGiaVe, TenNhaXe, DiaChi, XeDapNgayThuong, XeDapCuoiTuan, XeDapQuaDem, XeMayNgayThuong, XeMayCuoiTuan, XeMayQuaDem FROM GiaVe INNER JOIN NhaXe ON GiaVe.MaNhaXe = NhaXe.MaNhaXe";
	private String sqlGiaVeTheoMaGiaVe = "SELECT MaGiaVe, XeDapNgayThuong, XeDapCuoiTuan, XeDapQuaDem, XeMayNgayThuong, XeMayCuoiTuan, XeMayQuaDem FROM GiaVe WHERE MaGiaVe = ? ";
	private String sqlCapNhatGiaVeTheoMaGV = "UPDATE GiaVe SET XeDapNgayThuong = ?, XeDapCuoiTuan = ?, XeDapQuaDem = ?, XeMayNgayThuong = ?, XeMayCuoiTuan = ?, XeMayQuaDem = ? WHERE MaGiaVe = ?";

	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	private ArrayList<GiaVe> listGiaVe = null;
	private GiaVe GiaVe = null;

	// sqlGiaVeTheoNhaXe
	public ArrayList<GiaVe> getGiaVeTheoNhaXe() {
		listGiaVe = new ArrayList<GiaVe>();

		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlGiaVeTheoNhaXe);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				GiaVe = new GiaVe();
				GiaVe.setMaGiaVe(rs.getInt(1));
				GiaVe.setTenNhaXe(rs.getString(2));
				GiaVe.setXeDapNgayThuong(rs.getInt(4));
				GiaVe.setXeDapCuoiTuan(rs.getInt(5));
				GiaVe.setXeDapQuaDem(rs.getInt(6));
				GiaVe.setXeMayNgayThuong(rs.getInt(7));
				GiaVe.setXeMayCuoiTuan(rs.getInt(8));
				GiaVe.setXeMayQuaDem(rs.getInt(9));
				listGiaVe.add(GiaVe);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLConnection.closeConnection(this.con);
			SQLConnection.closePrepareStatement(pstmt);
			SQLConnection.closeResultSet(rs);
		}

		return listGiaVe;
	}

	// sqlGiaVeTheoMaGiaVe
	public GiaVe getGiaVeTheoMaGiaVe(int maGiaVe) {
		this.GiaVe = null;

		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlGiaVeTheoMaGiaVe);
			pstmt.setInt(1, maGiaVe);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				GiaVe = new GiaVe(rs.getInt(1), rs.getInt(2),
						rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getInt(7));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLConnection.closeConnection(this.con);
			SQLConnection.closePrepareStatement(pstmt);
			SQLConnection.closeResultSet(rs);
		}

		return this.GiaVe;
	}

	// sqlCapNhatGiaVe
	public int updateGiaVeTheoMaGiaVe(GiaVe gv) {
		int result = 0;

		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlCapNhatGiaVeTheoMaGV);

			pstmt.setInt(1, gv.getXeDapNgayThuong());
			pstmt.setInt(2, gv.getXeDapCuoiTuan());
			pstmt.setInt(3, gv.getXeDapQuaDem());
			pstmt.setInt(4, gv.getXeMayNgayThuong());
			pstmt.setInt(5, gv.getXeMayCuoiTuan());
			pstmt.setInt(6, gv.getXeMayQuaDem());
			pstmt.setInt(7, gv.getMaGiaVe());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLConnection.closeConnection(this.con);
			SQLConnection.closePrepareStatement(pstmt);
		}

		return result;
	}
}
