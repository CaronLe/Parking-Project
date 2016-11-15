package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.sun.java_cup.internal.runtime.Symbol;

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
				pstmt.setString(2, "Xe Dap");
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
				pstmt.setString(2, "Xe May");
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
			String sql = "select ThoiGianVao,LoaiXe from VeXe where MaVeXe = "+maVeXe;
			String sql1="select * from GiaVe where MaNhaXe=(select MaNhaXe from VeXe where MaVeXe ="+maVeXe+")";
			String timeIn = null;
			String loaiXe = null;
			GiaVe giaVe = null;
			long tienVe = 0;
			con = SQLConnection.getConnection();
			try {
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next()){
					String time1 = rs.getDate("ThoiGianVao").toString();
					String time2 = rs.getTime("ThoiGianVao").toString();
					loaiXe = rs.getString("LoaiXe");
					timeIn = time1+" "+time2;
					System.out.println("Loai xe: "+loaiXe);
					System.out.println("Thoi gian vao: "+timeIn);
				}
				pstmt = con.prepareStatement(sql1);
				rs = pstmt.executeQuery();
				while(rs.next()){
					giaVe = new GiaVe(rs.getInt(1), rs.getString(2), rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getInt(8));	
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Date timeCurrent=new Date(System.currentTimeMillis());
			SimpleDateFormat timeFormat= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String timeOut=timeFormat.format(timeCurrent.getTime());
			System.out.println("Thoi gian ra: "+timeOut);
			
			Date thoiGianVao = null;
			Date thoiGianRa = null;
			try {
				thoiGianVao = timeFormat.parse(timeIn);
				thoiGianRa = timeFormat.parse(timeOut);
				int thuRa = thoiGianRa.getDay();
				int thuVao = thoiGianVao.getDay();
				int gioVao = thoiGianVao.getHours();
				int gioRa = thoiGianRa.getHours();
				System.out.println("gio Vao: "+gioVao);
				System.out.println("gio Ra: "+gioRa);
				if(thuRa==0)thuRa = thuRa+7;
				if(thuVao==0)thuVao = thuVao+7;
				System.out.println("Thu : "+thuVao);
                System.out.println("Thu : "+thuRa);
                
				long diff = thoiGianRa.getTime() - thoiGianVao.getTime();
				
				long soGiay = diff / 1000 % 60;
				long soPhut = diff / (60 * 1000) % 60;
				long soGio = diff / (60 * 60 * 1000) % 24;
				long soNgay = diff / (24 * 60 * 60 * 1000);

				System.out.print(soNgay + " days, ");
				System.out.print(soGio + " hours, ");
				System.out.print(soPhut + " minutes, ");
				System.out.print(soGiay + " seconds.\n");
				
				if(soNgay<7){
					tienVe =  kiemTraTrongTuan(thuVao, thuRa, soNgay, soGio, gioVao, gioRa, loaiXe, giaVe);
					System.out.println("Trong tuần = "+kiemTraTrongTuan(thuVao, thuRa, soNgay, soGio, gioVao, gioRa, loaiXe, giaVe));
				}
				else{
					long soTuan = soNgay/7;
					long ngayDu = soNgay%7;
					tienVe = soTuan*nguyenTuan(loaiXe, giaVe)+kiemTraTrongTuan(thuVao, thuRa, ngayDu, soGio, gioVao, gioRa, loaiXe, giaVe);
					System.out.println(soTuan+" Tuần = "+soTuan*nguyenTuan(loaiXe, giaVe)+", Trong tuần = "
					+kiemTraTrongTuan(thuVao, thuRa, ngayDu, soGio, gioVao, gioRa, loaiXe, giaVe));
					System.out.println("Gia ve la: "+tienVe);
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			String sql2 = "update VeXe set ThoiGianRa='"+timeOut+"', TrangThai='False',GiaTien="+(int)tienVe+" where MaVeXe="+maVeXe;
			try {
				pstmt = con.prepareStatement(sql2);
				pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		public static long nguyenTuan(String loaiXe,GiaVe giaVe){
			long tongTien = 0;
			if(loaiXe.equals("Xe May")){
				tongTien = 7 * giaVe.getXeMayQuaDem();
			}
			if(loaiXe.equals("Xe Dap")){
				tongTien = 7 * giaVe.getXeDapQuaDem();
			}
			return tongTien;
		}
		
		public static long kiemTraTrongTuan(int thuVao,int thuRa,long soNgay,long soGio,int gioVao,int gioRa,String loaiXe,GiaVe giaVe){
			long tienVe = 0 ;
			if(thuVao<6&&thuRa<6&&thuVao<=thuRa){
				tienVe = ngayThuong(soNgay, soGio, gioVao, loaiXe,giaVe );
			}
			if(thuVao<6&&thuRa>=6){
				int soNgayNT = 5 - thuVao;
				int soGioNT = 30 - gioVao;
				int soNgayCT = thuRa - 6;
				int soGioCT = gioRa - 6;
				tienVe = ngayThuong(soNgayNT, soGioNT, gioVao, loaiXe, giaVe)+cuoiTuan(soNgayCT, soGioCT, 6, loaiXe, giaVe);
			}
			if(thuVao>=6&&thuRa>=6&&soNgay<=2){
				tienVe = cuoiTuan(soNgay, soGio, gioVao, loaiXe, giaVe);
			}
			if(thuVao>=6&&thuRa<6){
				int soNgayNT = thuRa - 1;
				int soGioNT = gioRa - 6;
				int soNgayCT = 7 - thuVao;
				int soGioCT = 30 - gioVao;
				tienVe = ngayThuong(soNgayNT, soGioNT, 6, loaiXe, giaVe)+cuoiTuan(soNgayCT, soGioCT, gioVao, loaiXe, giaVe);
			}
			if(thuVao>=thuRa&&thuVao<6&&soNgay>2){
				int soNgayNT1 = 5 - thuVao;
				int soGioNT1 = 30 - gioVao;
				int soNgayNT2 = thuRa - 1;
				int soGioNT2 = gioRa - 6;
				
				tienVe = ngayThuong(soNgayNT1, soGioNT1, gioVao, loaiXe, giaVe)+cuoiTuan(loaiXe, giaVe)
				+ngayThuong(soNgayNT2, soGioNT2, 6, loaiXe, giaVe);	
			}
			if(thuVao>=thuRa&&thuVao>=6&& soNgay>5){
				int soNgayCT1 = 7 - thuVao;
				int soGioCT1 = 30 - gioVao;
				int soNgayCT2 = thuRa - 6;
				int soGioCT2 = gioRa - 6;
				
				tienVe = cuoiTuan(soNgayCT1, soGioCT1, gioVao, loaiXe, giaVe)+ngayThuong(loaiXe, giaVe)
				+cuoiTuan(soNgayCT2, soGioCT2, gioVao, loaiXe, giaVe);
			}
			return tienVe;
		}
		
		public static long ngayThuong(long soNgay,long soGio,int gioVao,String loaiXe,GiaVe giaVe){
			long tongTien = 0;
			if(soNgay==0){
				if(soGio+gioVao<22){
					if(loaiXe.equals("Xe May")){
						tongTien = giaVe.getXeMayNgayThuong();
					}
					if(loaiXe.equals("Xe Dap")){
						tongTien = giaVe.getXeDapNgayThuong();
					}
				}
				else{
					if(loaiXe.equals("Xe May")){
						tongTien = giaVe.getXeMayQuaDem();
					}
					if(loaiXe.equals("Xe Dap")){
						tongTien = giaVe.getXeDapQuaDem();
					}
				}
			}
			else{
				if(soGio+gioVao<22){
					if(loaiXe.equals("Xe May")){
						tongTien = soNgay*giaVe.getXeMayQuaDem()+giaVe.getXeMayNgayThuong();
					}
					if(loaiXe.equals("Xe Dap")){
						tongTien = soNgay*giaVe.getXeDapQuaDem()+giaVe.getXeDapNgayThuong();
					}
				}
				else{
					if(loaiXe.equals("Xe May")){
						tongTien = (soNgay+1)*giaVe.getXeMayQuaDem();
					}
					if(loaiXe.equals("Xe Dap")){
						tongTien = (soNgay+1)*giaVe.getXeDapQuaDem();
					}
				}
			}
			return tongTien;
		}
		
		public static long ngayThuong(String loaiXe,GiaVe giaVe){
			long tongTien = 0;
				if(loaiXe.equals("Xe May")){
					tongTien = 5*giaVe.getXeMayQuaDem();
				}
				if(loaiXe.equals("Xe Dap")){
					tongTien = 5*giaVe.getXeDapQuaDem();
				}
			return tongTien;
		}
		
		public static long cuoiTuan(long soNgay,long soGio,int gioVao,String loaiXe,GiaVe giaVe){
			long tongTien = 0;
			if(soNgay==0){
				if(soGio+gioVao<22){
					if(loaiXe.equals("Xe May")){
						tongTien = giaVe.getXeMayCuoiTuan();
					}
					if(loaiXe.equals("XeDap")){
						tongTien = giaVe.getXeDapCuoiTuan();
					}
				}
				else{
					if(loaiXe.equals("Xe May")){
						tongTien = giaVe.getXeMayQuaDem();
					}
					if(loaiXe.equals("Xe Dap")){
						tongTien = giaVe.getXeDapQuaDem();
					}
				}
			}
			else{
				if(soGio+gioVao<22){
					if(loaiXe.equals("Xe May")){
						tongTien = soNgay*giaVe.getXeMayQuaDem()+giaVe.getXeMayCuoiTuan();
					}
					if(loaiXe.equals("Xe Dap")){
						tongTien = soNgay*giaVe.getXeDapQuaDem()+giaVe.getXeDapCuoiTuan();
					}
				}
				else{
					if(loaiXe.equals("Xe May")){
						tongTien = (soNgay+1)*giaVe.getXeMayQuaDem();
					}
					if(loaiXe.equals("Xe Dap")){
						tongTien = (soNgay+1)*giaVe.getXeDapQuaDem();
					}
				}
			}
			return tongTien;
		}
		
		public static long cuoiTuan(String loaiXe,GiaVe giaVe){
			long tongTien = 0;
				if(loaiXe.equals("Xe May")){
					tongTien = 2*giaVe.getXeMayQuaDem();
				}
				if(loaiXe.equals("Xe Dap")){
					tongTien = 2*giaVe.getXeDapQuaDem();
				}
			return tongTien;
		}
}
