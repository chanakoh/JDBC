package com.kh.db.oracledb.CRUD.pre;
//cafes insert 작성해서 여러 카페 추가하기

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class insertExam {

	public static void main(String[] args) {
		String udbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "khcafe";
		String password = "KHCAFE";
		
			try {
				Connection con = DriverManager.getConnection(udbcUrl, userName, password);
				String insertSQL = "INSERT INTO cafes( C_NAME, ADDRESS, PHONE_NUMBER, OPERATING_HOURS)"
						+"VALUES (?,?,?,?)";
				PreparedStatement ps = con.prepareStatement(insertSQL);
				//insertCafes(ps,22,"못나가는 카페","서울시 도봉구","02-555-5555","매일: 09:00-22:00");
				//insertCafes(ps,23,"안나가는 카페","서울시 구로구","02-666-6666","매일: 09:00-20:00");
				//insertCafes(ps,24,"지나가는 카페","서울시 영등포구","02-777-7777","매일: 09:00-19:00");
				insertCafes(ps,"나가주는 카페","서울시 서초구","02-888-8888","매일: 09:00-18:00");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
	
	//CAFE_ID, C_NAME, ADDRESS, PHONE_NUMBER, OPERATING_HOURS
	static void insertCafes(PreparedStatement ps, String C_NAME, String ADDRESS, String PHONE_NUMBER, String OPERATING_HOURS)
	throws SQLException{
	//	ps.setInt(1, CAFE_ID);
		ps.setString(1, C_NAME);
		ps.setString(2, ADDRESS);
		ps.setString(3,PHONE_NUMBER);
		ps.setString(4, OPERATING_HOURS);
		//ps.executeUpdate();
		
		int rowsInsert = ps.executeUpdate();
		System.out.println(rowsInsert+"row추가");
	}
}
