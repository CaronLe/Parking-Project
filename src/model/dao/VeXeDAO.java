package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.bean.VeXe;

public class VeXeDAO {
	private String sqlVeXeTheoMaVeXe_XeMay = "SELECT MaVeXe, MaNhaXe, LoaiXe, ThoiGianVao, ThoiGianRa, TrangThai, AnhXe, GiaTien FROM VeXe WHERE MaVeXe = 1 AND LoaiXe = 'Xe máy'" ;
	private String sqlVeXeTheoMaVeXe_XeDap = "SELECT MaVeXe, MaNhaXe, LoaiXe, ThoiGianVao, ThoiGianRa, TrangThai, AnhXe, GiaTien FROM VeXe WHERE MaVeXe = ? AND LoaiXe = 'Xe đạp'" ;
	
	private Connection con = null;
	private PreparedStatement pstmt = null ;
	private ResultSet rs = null;

	private VeXe VeXe = null;
	
	
// sqlVeXeTheoMaVeXe_XeMay
	public VeXe  getVeXeTheoMaVeXe_XeMay(String maVeXe) {
		this.VeXe  = null;
		try{
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sqlVeXeTheoMaVeXe_XeMay);
			rs = pstmt.executeQuery();
		if(rs.next()){
			VeXe = new VeXe(rs.getInt(1), rs.getString(2),rs.getString(3), rs.getTime(4),rs.getTime(5),rs.getBoolean(6),rs.getString(7), rs.getInt(8));
		}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			SQLConnection.closeConnection(this.con);
			SQLConnection.closePrepareStatement(pstmt);
			SQLConnection.closeResultSet(rs);
		}
		return this.VeXe;
		
	}
	
	// sqlVeXeTheoMaVeXe_XeDap
		public VeXe  getVeXeTheoMaVeXe_XeDap(String maVeXe) {
			this.VeXe  = null;
			try{
				con = SQLConnection.getConnection();
				pstmt = con.prepareStatement(sqlVeXeTheoMaVeXe_XeDap);
				rs = pstmt.executeQuery();
			if(rs.next()){
				VeXe = new VeXe(rs.getInt(1), rs.getString(2),rs.getString(3), rs.getTime(4),rs.getTime(5),rs.getBoolean(6),rs.getString(7), rs.getInt(8));
			}
				
			}catch(SQLException e){
				e.printStackTrace();
			}finally{
				SQLConnection.closeConnection(this.con);
				SQLConnection.closePrepareStatement(pstmt);
				SQLConnection.closeResultSet(rs);
			}
			return this.VeXe;
			
		}
}
