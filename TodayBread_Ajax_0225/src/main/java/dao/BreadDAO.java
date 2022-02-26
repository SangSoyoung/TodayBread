package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dto.BreadDTO;

public class BreadDAO implements IBreadDAO {

	@Override
	public Connection getConnection() {
		Connection con = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "system", "1234");
			
		} catch (ClassNotFoundException e) {
			System.out.println("jar파일을 확인해주세요~" + e);
		} catch (SQLException e) {
			System.out.println("url, id, pw를 확인해주세요~" + e);
		}

		return con;
	}

	@Override
	public int registBread() {
		// TODO 자동 생성된 메소드 스텁
		return 0;
	}

	@Override
	public ArrayList<BreadDTO> breadList() {
		// TODO 자동 생성된 메소드 스텁
		return null;
	}

	@Override
	public BreadDTO getTodayBread() {

		BreadDTO b = new BreadDTO();
		
		Connection con = getConnection();
		try {
			Statement stmt = con.createStatement();
			//String sql = "select * from bread where code='" + code + "'";
			String sql = "select * from v_amount "
					   + "where total = (select max(total) from v_amount)";
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				b.setCode(rs.getString("code"));
				b.setName(rs.getString("name"));
				b.setPrice(rs.getInt("price"));
				b.setIntro(rs.getString("intro"));
				b.setImg(rs.getString("img"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return b;
	}

}
