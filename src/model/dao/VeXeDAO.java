package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.bean.VeXe;

public class VeXeDAO {
	
	private Connection con = null;
	private PreparedStatement pstmt = null ;
	private ResultSet rs = null;

	private VeXe VeXe = null;
	
		public void addVeXeDap() {
			Date today=new Date(System.currentTimeMillis());
			SimpleDateFormat timeFormat= new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
			String toDay=timeFormat.format(today.getTime());
			String sql = "insert into VeXe(MaNhaXe,LoaiXe,ThoiGianVao,ThoiGianRa,TrangThai,AnhXe,GiaTien) values(?,?,?,?,?,?,?)";
			con = SQLConnection.getConnection();
			
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, "KE01");
				pstmt.setString(2, "XeDap");
				pstmt.setString(3, toDay);
				pstmt.setString(4, null);
				pstmt.setBoolean(5, true);
				pstmt.setBytes(6, null);
				pstmt.setInt(7, 0);
				pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				SQLConnection.closeConnection(this.con);
				SQLConnection.closePrepareStatement(pstmt);
				SQLConnection.closeResultSet(rs);
			}			
		}
		public void addVeXeMay() {
			Date today=new Date(System.currentTimeMillis());
			SimpleDateFormat timeFormat= new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
			String toDay=timeFormat.format(today.getTime());
			String sql = "insert into VeXe(MaNhaXe,LoaiXe,ThoiGianVao,ThoiGianRa,TrangThai,AnhXe,GiaTien) values(?,?,?,?,?,?,?)";
			con = SQLConnection.getConnection();
			
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, "KE01");
				pstmt.setString(2, "XeMay");
				pstmt.setString(3, toDay);
				pstmt.setString(4, null);
				pstmt.setBoolean(5, true);
				pstmt.setBytes(6, null);
				pstmt.setInt(7, 0);
				pstmt.executeUpdate();	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	finally{
				SQLConnection.closeConnection(this.con);
				SQLConnection.closePrepareStatement(pstmt);
				SQLConnection.closeResultSet(rs);
			}	
		}
		public VeXe getVeXe(){
			con = SQLConnection.getConnection();
			String sql = "select top 1 * from VEXE order by MaVeXe desc";
			try {
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();				
				while(rs.next()){
					VeXe veXe = new VeXe(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4), rs.getString(5), rs.getBoolean(6),rs.getString(7),rs.getInt(8));
					return veXe;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		public VeXe getVeXeRa(int maVeXe) {
			con = SQLConnection.getConnection();
			String sql = "select * from VEXE where MaVeXe="+maVeXe;
			try {
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();				
				while(rs.next()){
					VeXe veXe = new VeXe(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4), rs.getString(5), rs.getBoolean(6),rs.getString(7),rs.getInt(8));
					System.out.println(veXe.getMaVeXe());
					return veXe;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		public static void main(String[] args) {
			VeXeDAO vx =new VeXeDAO();
			vx.getVeXeRa(81);
		}
}
