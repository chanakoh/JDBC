package com.kh.db.oracledb.CRUD.pre;

import java.sql.Clob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertExam2 {

	public static void main(String[] args) throws SQLException {
		String udbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "khcafe";
		String password = "KHCAFE";
		Connection con = DriverManager.getConnection(udbcUrl, userName, password);
		String insertSQL = "INSERT INTO BOOK( BOOK_ID, TITLE, AUTHOR, PUBLICATION_YEAR, ISBN,GENRE,DESCRIPTION,PRICE,PUBLICATION_DATE,CREATED_DATE,UPDATED_DATE,IS_AVAILABLE)"
				+"VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(insertSQL);
		insertBook(ps,33,"책","작가",2020,"978-0000000000","Fiction","테스트로 적은 책",5.5,Date.valueOf("2023-10-19"),Date.valueOf("2022-10-19"),Date.valueOf("2021-10-19"),"N");
		
		//String selectQuery = "SELECT * FROM book WHERE BOOK_ID= ?";
		//PreparedStatement sps = con.prepareStatement(selectQuery);
		//sps.setInt(1, 50);
		
	}
	
	//BOOK_ID, TITLE, AUTHOR, PUBLICATION_YEAR, ISBN,GENRE,DESCRIPTION,PRICE,PUBLICATION_DATE,CREATED_DATE,UPDATED_DATE,IS_AVAILABLE
	static void insertBook(PreparedStatement ps, int BOOK_ID, String TITLE, String AUTHOR, int PUBLICATION_YEAR, String ISBN, String GENRE, String DESCRIPTION, Double PRICE, Date PUBLICATION_DATE, Date CREATED_DATE, Date UPDATED_DATE, String IS_AVAILABLE)throws SQLException {
	ps.setInt(1,BOOK_ID);
	ps.setString(2,TITLE);
	ps.setString(3,AUTHOR);
	ps.setInt(4,PUBLICATION_YEAR);
	ps.setString(5,ISBN);
	ps.setString(6,GENRE);
	ps.setString(7,DESCRIPTION);
	ps.setDouble(8,PRICE);
	ps.setDate(9,PUBLICATION_DATE);
	ps.setDate(10,CREATED_DATE);
	ps.setDate(11,UPDATED_DATE);
	ps.setString(12, IS_AVAILABLE);
	ps.executeUpdate();
	}
}
