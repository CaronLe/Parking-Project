package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.NhaXe;

public class NhaXeDAO {
	private String sqlSoLuongXe = "SELECT MaNhaXe, TenNhaXe, SoLuongXe FROM NhaXe";
	private String sqlThoiGianDongMoCua = "SELECT MaNhaXe, TenNhaXe, DiaChi, ThoiGianMo, ThoiGianDong  FROM NhaXe";
	private String sqlNhaXeTheoMaNX_SoLuong = "SELECT MaNhaXe, TenNhaXe, SoLuongXe FROM NhaXe WHERE MaNhaXe = ?";
	private String sqlNhaXeTheoMaNX_ThoiGian = "SELECT MaNhaXe, TenNhaXe, DiaChi, ThoiGianMo, ThoiGianDong FROM NhaXe WHERE MaNhaXe = ?";
	private String sqlCapNhatSoLuongXe = "UPDATE NhaXe SET TenNhaXe = ?, SoLuongXe = ? WHERE MaNhaXe = ?";
	private String sqlCapNhatThoiGianDongMoCua = "UPDATE NhaXe SET TenNhaXe = ?, DiaChi = ?, ThoiGianMo = ?, ThoiGianDong = ? WHERE MaNhaXe = ?";

	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	private ArrayList<NhaXe> listNhaXe = null;
	private NhaXe NhaXe = null;

	//sqlSoLuongXe
	public ArrayList<NhaXe> getSoLuongXe() {
		listNhaXe = new ArrayList<NhaXe>();

		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlSoLuongXe);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				NhaXe = new NhaXe(null, null, 0);
				NhaXe.setMaNhaXe(rs.getString(1));
				NhaXe.setTenNhaXe(rs.getString(2));
				NhaXe.setSoLuongXe(rs.getInt(3));

				listNhaXe.add(NhaXe);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLConnection.closeConnection(this.con);
			SQLConnection.closePrepareStatement(pstmt);
			SQLConnection.closeResultSet(rs);
		}

		return listNhaXe;
	}

	// GetThoiGianDongMoCua
	public ArrayList<NhaXe> getThoiGianDongMoCua() {
		listNhaXe = new ArrayList<NhaXe>();

		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlThoiGianDongMoCua);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				NhaXe = new NhaXe(null, null, null, null, null);
				NhaXe.setMaNhaXe(rs.getString(1));
				NhaXe.setTenNhaXe(rs.getString(2));
				NhaXe.setDiaChi(rs.getString(3));
				NhaXe.setThoiGianMo(rs.getTime(4));
				NhaXe.setThoiGianDong(rs.getTime(5));

				listNhaXe.add(NhaXe);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLConnection.closeConnection(this.con);
			SQLConnection.closePrepareStatement(pstmt);
			SQLConnection.closeResultSet(rs);
		}

		return listNhaXe;
	}
	
	//sqlNhaXeTheoMaNX_SoLuong
	public NhaXe getNhaXeTheoMaNX_SoLuong(String maNhaXe) {
		this.NhaXe = null;

		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlNhaXeTheoMaNX_SoLuong);
			pstmt.setString(1, maNhaXe);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				NhaXe = new NhaXe(rs.getString(1), rs.getString(2),
						rs.getInt(3));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLConnection.closeConnection(this.con);
			SQLConnection.closePrepareStatement(pstmt);
			SQLConnection.closeResultSet(rs);
		}

		return this.NhaXe;
	}
	
	//sqlNhaXeTheoMaNX_ThoiGian
		public NhaXe getNhaXeTheoMaNX_ThoiGian(String maNhaXe) {
			this.NhaXe = null;

			try {
				con = SQLConnection.getConnection();
				pstmt = con.prepareStatement(sqlNhaXeTheoMaNX_ThoiGian);
				pstmt.setString(1, maNhaXe);
				rs = pstmt.executeQuery();

				if (rs.next()) {
					NhaXe = new NhaXe(rs.getString(1), rs.getString(2),rs.getString(3), rs.getTime(4), rs.getTime(5));
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				SQLConnection.closeConnection(this.con);
				SQLConnection.closePrepareStatement(pstmt);
				SQLConnection.closeResultSet(rs);
			}

			return this.NhaXe;
		}

	 //sqlCapNhatSoLuongXe
	public int updateSoLuongXe(NhaXe nx) {
		int result = 0;

		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlCapNhatSoLuongXe);

			pstmt.setString(1, nx.getTenNhaXe());
			pstmt.setInt(2, nx.getSoLuongXe());
			pstmt.setString(3, nx.getMaNhaXe());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLConnection.closeConnection(this.con);
			SQLConnection.closePrepareStatement(pstmt);
		}

		return result;
	}

	 //sqlCapNhatThoiGianDongMoCua
	public int updateThoiGianDongMoCua(NhaXe tg) {
		int result = 0;

		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlCapNhatThoiGianDongMoCua);

			pstmt.setString(1, tg.getTenNhaXe());
			pstmt.setString(2, tg.getDiaChi());
			pstmt.setTime(3, tg.getThoiGianMo());
			pstmt.setTime(4, tg.getThoiGianDong());
			pstmt.setString(5, tg.getMaNhaXe());

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
