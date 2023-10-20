package com.kh.db.oracledb.CRUD;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class insertSample {

	public static void main(String[] args) {
		//selectBank();
		//selectKhcafe();
		//selecOne();
		//insertBank();
		//createBank2();
		select4();
	}
 static void selectAll() {
		//1.드라이버 연결 : Oracle JDBC 드라이버 클래스 이름
		String driver = "orcale.jdbc.driver.OracleDriver";
		//2.오라클 내 컴퓨터 연결 : 데이터 베이스 연결 정보
		//                              나의ip주소:port번호
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khbank";
		String password = "kh1234";
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, password);
			System.out.println("데이터베이스 연결 성공!");
			
			//SELECT 쿼리
			String selectQuery = "SELECT * FROM BANK WHERE account_id>5";
			PreparedStatement selectState = con.prepareCall(selectQuery);
			ResultSet result = selectState.executeQuery();
			//result.next() : result 객체에서 다음 행(row)으로 이동. 다음 행이 있으면 true반환, 그렇지 않으면 false반환
			System.out.println(result);
			while(result.next()) {
			//khbank에 있는 bank테이블 결과집합에서 account_id를 가져옴
			int accountID = result.getInt("account_id");
			//1,함께해보기 : ACCOUNTnUMBER
			int accountNumber = result.getInt("account_Number");
			String accountName = result.getString("account_name");
			double balance = result.getDouble("balance");
			String branchName = result.getString("BRANCH_NAME");
			Date lasttransactiondate = result.getDate("last_transaction_date");
			
			//2.함께해보기 : branchName
			
			System.out.println("ACCOUNT_ID : "+accountID);
			System.out.println("ACCOUNT_Number : "+accountNumber);
			System.out.println("ACCOUNT_NAME : "+accountName);
			System.out.println("balance : "+balance);
			System.out.println("BRANCH_NAME : "+branchName);
			System.out.println("last_transaction_date : "+lasttransactiondate);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 }
 static void selecOne() {
		String driver = "orcale.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "KHCAFE";
		String password = "KHCAFE";
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, password);
			System.out.println("데이터베이스 연결 성공!");
			
			String selectQuery = "SELECT * FROM MENU";
			PreparedStatement selectState = con.prepareCall(selectQuery);
			ResultSet result = selectState.executeQuery();
			System.out.println(result);
			while(result.next()) {
			int menuID = result.getInt("menu_id");
			System.out.println("menu_id : "+menuID);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
 static void selectTwo() {
	 	String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khbank";
		String password = "kh1234";
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, password);
			//where절 사용해서 조건 추가
			String selectQuery = "SELECT * FROM BANK WHERE account_name in(?,?,?)";
			PreparedStatement selectState = con.prepareCall(selectQuery);
			//여기에 원하는 조건의 account_id 설정
			String[] targetAN = {"김영희","이동훈","배민정"};
			selectState.setString(1,targetAN[0]);
			selectState.setString(2,targetAN[2]);
			selectState.setString(3,targetAN[1]);
			//int targetAID = 1;
			//조건 설정
			//selectState.setInt(1, targetAID);
			ResultSet result = selectState.executeQuery();
			while(result.next()) {
				int a = result.getInt("account_id");
				String b = result.getString("account_number");
				String c = result.getString("account_name");
				double d = result.getInt("BALANCE");
				String e = result.getString("BRANCH_NAME");
				Date f = result.getDate("LAST_TRANSACTION_DATE");
				System.out.println("ACCOUNT_ID:"+a);
				System.out.println("account_number:"+b);
				System.out.println("account_name:"+c);
				System.out.println("BALANCE:"+d);
				System.out.println("BRANCH_NAME:"+e);
				System.out.println("LAST_TRANSACTION_DATE:"+f);
				
				
				
			//}else {
				//System.out.println("조건에 해당하는 데이터가 없습니다.");
			}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
 }
 static void select3() { 
	 String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khcafe";
		String password = "KHCAFE";
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			String sql = "SELECT * FROM CAFES WHERE INSTR(ADDRESS,'부산') >0 ";
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet result = st.executeQuery();
			while(result.next()) {
				System.out.println(result);
				int a = result.getInt("CAFE_ID");
				String b = result.getString("NAME");
				String c = result.getString("ADDRESS");
				String d = result.getString("PHONE_NUMBER");
				String e = result.getString("OPERATING_HOURS");
				System.out.println("CAFE_ID:"+a);
				System.out.println("카페이름:"+b);
				System.out.println("주소:"+c);
				System.out.println("카페 연락처:"+d);
				System.out.println("운영시간:"+e);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 }
 static void select4() {
	 String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khcafe";
		String password = "KHCAFE";
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			String sql = "SELECT * FROM CAFES WHERE MENU_ID = 1";
			PreparedStatement st = con.prepareStatement(sql);
			//st.setInt(1, MENU_ID);
			ResultSet result = st.executeQuery();
			while(result.next()) {
			int a = result.getInt("CAFE_ID");
			String b = result.getString("C_NAME");
			String c = result.getString("ADDRESS");
			String d = result.getString("PHONE_NUMBER");
			String e = result.getString("OPERATING_HOURS");
			System.out.println("CAFE_ID:"+a);
			System.out.println("카페이름:"+b);
			System.out.println("주소:"+c);
			System.out.println("카페 연락처:"+d);
			System.out.println("운영시간:"+e);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 }
 }
