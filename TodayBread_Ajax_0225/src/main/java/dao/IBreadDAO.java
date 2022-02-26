package dao;

import java.sql.Connection;
import java.util.ArrayList;

import dto.BreadDTO;

public interface IBreadDAO {
	// db연결
	public Connection getConnection();
	
	// 상품 등록
	public int registBread();
	
	// 상품 목록
	public ArrayList<BreadDTO> breadList();
	
	// 매출 1위 상품
	public BreadDTO getTodayBread();
	
}
