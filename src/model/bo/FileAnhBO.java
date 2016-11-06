package model.bo;

import model.dao.FileAnhDAO;

public class FileAnhBO {
  FileAnhDAO anh = new FileAnhDAO();
  public byte[] exportAnh(int id){
	  return anh.exportAnh(id);
  }
}
