package model.dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FileAnhDAO {
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public byte[] exportAnh(int id){
    	Blob file = null;
        byte[ ] fileData = null ;
	   con = SQLConnection.getConnection();
	   String sql = "SELECT Anh FROM NhanVien WHERE MaNhanVien = "+id;
	   try {
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while(rs.next()){
			file = rs.getBlob("Anh");
		}
		fileData = file.getBytes(1,(int)file.length());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			SQLConnection.closeConnection(con);
			SQLConnection.closePrepareStatement(pstmt);
			SQLConnection.closeResultSet(rs);
		}
	   return fileData;
	}
}
