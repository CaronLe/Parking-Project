package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.bean.ThongKe;

public class ThongKeDAO {
	private Connection con = null;
	private PreparedStatement pstmt = null ;
	private ResultSet rs = null;
	
	public ThongKe getThongKeTheoNgay() {
		Date timeCurrent=new Date(System.currentTimeMillis());
		SimpleDateFormat timeFormatYear= new SimpleDateFormat("yyyy");
		SimpleDateFormat timeFormatMonth= new SimpleDateFormat("MM");
		SimpleDateFormat timeFormatDay= new SimpleDateFormat("dd");
		String year =timeFormatYear.format(timeCurrent.getTime());
		String month =timeFormatMonth.format(timeCurrent.getTime());
		String day =timeFormatDay.format(timeCurrent.getTime());
		
		String sql="select count(ThoiGianVao), count(ThoiGianRa), SUM(GiaTien) from VEXE where YEAR(ThoiGianVao) ="+year+" and MONTH(ThoiGianVao)="+month+" and DAY(ThoiGianVao)="+day;
		con = SQLConnection.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				ThongKe thongKe = new ThongKe(rs.getInt(1),rs.getInt(2),rs.getInt(3));
				return thongKe;
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
//	public ThongKe getThongKeAdmin(int day, int month, int year) {
//		String sql="select count(ThoiGianVao), count(ThoiGianRa), SUM(GiaTien) from VEXE where year(ThoiGianVao) ="+year+" and MONTH(ThoiGianVao)="+month+" and DAY(ThoiGianVao)="+day;
//		con = SQLConnection.getConnection();
//		try {
//			pstmt = con.prepareStatement(sql);
//			rs = pstmt.executeQuery();
//			while(rs.next()){
//				ThongKe thongKe = new ThongKe(rs.getInt(1),rs.getInt(2),rs.getInt(3));
//				System.out.println(thongKe.getSoLuotRa());
//				return thongKe;
//				
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//	}
}
