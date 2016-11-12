package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.bean.GiaVe;
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
			Date timeCurrent=new Date(System.currentTimeMillis());
			SimpleDateFormat timeFormat= new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
			String timeIn=timeFormat.format(timeCurrent.getTime());
			String sql = "insert into VeXe(MaNhaXe,LoaiXe,ThoiGianVao,ThoiGianRa,TrangThai,AnhXe,GiaTien) values(?,?,?,?,?,?,?)";
			con = SQLConnection.getConnection();
			
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, "KE01");
				pstmt.setString(2, "XeMay");
				pstmt.setString(3, timeIn);
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
		
		public void updateVeXe(int maVeXe) {
			String sql = "select ThoiGianVao from VeXe where MaVeXe = "+maVeXe;
			String sql1="select * from GiaVe where MaNhaXe=(select MaNhaXe from VeXe where MaVeXe ="+maVeXe+")";
			String timeIn = null;
			con = SQLConnection.getConnection();
			try {
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next()){
					String time1 = rs.getDate("ThoiGianVao").toString();
					String time2 = rs.getTime("ThoiGianVao").toString();
					timeIn = time1+" "+time2;
					System.out.println(timeIn);
				}
				pstmt = con.prepareStatement(sql1);
				rs = pstmt.executeQuery();
				while(rs.next()){
					GiaVe giaVe = new GiaVe(rs.getInt(1), rs.getString(2), rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getInt(8));	
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	finally{
				SQLConnection.closeConnection(this.con);
				SQLConnection.closePrepareStatement(pstmt);
				SQLConnection.closeResultSet(rs);
			}	
			
			Date timeCurrent=new Date(System.currentTimeMillis());
			String timeIn1 = "11/23/1993 05:12:34";
			String timeOut1 = "11/25/1993 05:12:34";
			SimpleDateFormat timeFormat= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			
			String timeOut=timeFormat.format(timeCurrent.getTime());
			Date thoiGianVao = null;
			Date thoiGianRa = null;
			try {
				thoiGianVao = timeFormat.parse(timeIn);
				thoiGianRa = timeFormat.parse(timeOut);
				int thu = thoiGianRa.getDay();
                
				long diff = thoiGianRa.getTime() - thoiGianVao.getTime();
				
				long diffSeconds = diff / 1000 % 60;
				long diffMinutes = diff / (60 * 1000) % 60;
				long diffHours = diff / (60 * 60 * 1000) % 24;
				long diffDays = diff / (24 * 60 * 60 * 1000);

				System.out.print(diffDays + " days, ");
				System.out.print(diffHours + " hours, ");
				System.out.print(diffMinutes + " minutes, ");
				System.out.print(diffSeconds + " seconds.");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			String sql2 = "update VeXe set ThoiGianRa="+timeOut+", TrangThai=False,GiaTien=";
			
		}
		public static void main(String[] args) {
			VeXeDAO vx = new VeXeDAO();
			vx.updateVeXe(81);
		}
}
