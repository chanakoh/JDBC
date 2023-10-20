package com.kh.db.oracledb.CRUD;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class cafeexam {

	public static void main(String[] args) {
	 exam11();
	}
		static void exam1() {
			
		String jdbcurl = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "khcafe";
		String password = "KHCAFE";
		
		Connection con;
		try {
			con = DriverManager.getConnection(jdbcurl, username, password);
			String cafeQuery = "SELECT * FROM cafes";
			PreparedStatement ps = con.prepareStatement(cafeQuery);
			
			ResultSet result = ps.executeQuery();
			System.out.println(result);
			while(result.next()) {
			String name = result.getString("c_name");
			System.out.println("c_name : "+name);
		}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

		static void exam2() {
			String jdbcurl = "jdbc:oracle:thin:@localhost:1521:xe";
			String username = "khcafe";
			String password = "KHCAFE";
			
			try {
				Connection con = DriverManager.getConnection(jdbcurl, username, password);
				String cafeQuery = "SELECT * FROM menu WHERE CAFE_ID = 3";
				PreparedStatement ps = con.prepareStatement(cafeQuery);
				ResultSet result = ps.executeQuery();
				while(result.next()) {
				String name = result.getString("mname");
				System.out.println(name);
			}
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		static void exam3() {
			String jdbcurl = "jdbc:oracle:thin:@localhost:1521:xe";
			String username = "khcafe";
			String password = "KHCAFE";
			
			try {
				Connection con= DriverManager.getConnection(jdbcurl, username, password);
				String insertcafe = "INSERT INTO CAFES (CAFE_ID, C_NAME, ADDRESS, PHONE_NUMBER, OPERATING_HOURS)"
						+"VALUES (?,?,?,?,?)";
				PreparedStatement ps = con.prepareStatement(insertcafe);
				ps.setInt(1,40 );
				ps.setString(2, "무슨카페");
				ps.setString(3, "서울시");
				ps.setString(4, "02-555-1234");
				ps.setString(5, "24시간");
				int rowinsert = ps.executeUpdate();
				System.out.println(rowinsert+"rowinsert");
						
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					
		}
		static void exam4() {
			String jdbcurl = "jdbc:oracle:thin:@localhost:1521:xe";
			String username = "khcafe";
			String password = "KHCAFE";
			
			try {
				Connection con= DriverManager.getConnection(jdbcurl, username, password);
				String ipdateQuery = "UPDATE menu SET price = ? WHERE mname = ?";
				PreparedStatement updatePs = con.prepareStatement(ipdateQuery);
				updatePs.setDouble(1,30);
				updatePs.setString(2,"딸기라떼");
				
				int rowsUpdate = updatePs.executeUpdate();
				System.out.println(rowsUpdate+"update되었습니다.");
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		static void exam5() {
			String jdbcurl = "jdbc:oracle:thin:@localhost:1521:xe";
			String username = "khcafe";
			String password = "KHCAFE";
			
			try {
				Connection con= DriverManager.getConnection(jdbcurl, username, password);
				String ipdateQuery = "UPDATE menu SET description = ? WHERE cafe_id = ?";
				PreparedStatement updatePs = con.prepareStatement(ipdateQuery);
				updatePs.setString(1,"집에가자");
				updatePs.setInt(2,3);
				
				int rowsUpdate = updatePs.executeUpdate();
				System.out.println(rowsUpdate+"update되었습니다.");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		static void exam6() {
			String jdbcurl = "jdbc:oracle:thin:@localhost:1521:xe";
			String username = "khcafe";
			String password = "KHCAFE";
			
			try {
				Connection con= DriverManager.getConnection(jdbcurl, username, password);
				String deleteQuery = "DELETE FROM cafes WHERE cafe_id = ?";
				PreparedStatement deletePs = con.prepareStatement(deleteQuery);
				deletePs.setDouble(1,20);
				int rowsUpdate = deletePs.executeUpdate();
				System.out.println(rowsUpdate+"삭제되었습니다.");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		static void exam7() {
			String jdbcurl = "jdbc:oracle:thin:@localhost:1521:xe";
			String username = "khcafe";
			String password = "KHCAFE";
			try {
				Connection con= DriverManager.getConnection(jdbcurl, username, password);
				String selectQuery = "SELECT COUNT(MNAME) AS CNAME FROM MENU WHERE CAFE_ID = 2";
				PreparedStatement ps = con.prepareStatement(selectQuery);
				ResultSet result = ps.executeQuery();
				System.out.println(result);
				while(result.next()) {
				int name = result.getInt("cname");
				System.out.println("cname : "+name);
			}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		static void exam8() {
			String jdbcurl = "jdbc:oracle:thin:@localhost:1521:xe";
			String username = "khcafe";
			String password = "KHCAFE";
			try {
				Connection con= DriverManager.getConnection(jdbcurl, username, password);
				String selectQuery = "SELECT MNAME FROM MENU WHERE price BETWEEN 5 AND 20";
				PreparedStatement ps = con.prepareStatement(selectQuery);
				ResultSet result = ps.executeQuery();
				while(result.next()) {
					String menu = result.getString("mname");
					System.out.println("cname : "+menu);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		static void exam9() {
			String jdbcurl = "jdbc:oracle:thin:@localhost:1521:xe";
			String username = "khcafe";
			String password = "KHCAFE";
			try {
				Connection con= DriverManager.getConnection(jdbcurl, username, password);
				String selectQuery = "SELECT DESCRIPTION FROM MENU WHERE MNAME = '아메리카노'";
				PreparedStatement ps = con.prepareStatement(selectQuery);
				ResultSet result = ps.executeQuery();
				while(result.next()) {
					String menu = result.getString("DESCRIPTION");
					System.out.println("cname : "+menu);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		static void exam11() {
			String jdbcurl = "jdbc:oracle:thin:@localhost:1521:xe";
			String username = "khcafe";
			String password = "KHCAFE";
				try {
					Connection con= DriverManager.getConnection(jdbcurl, username, password);

					String ipdateQuery = "UPDATE cafes SET OPERATING_HOURS = ? WHERE CAFE_ID = ? ";
					PreparedStatement updatePs = con.prepareStatement(ipdateQuery);
					updatePs.setString(1,"매일");
					updatePs.setInt(2,1);
					int rowsUpdate = updatePs.executeUpdate();
					System.out.println(rowsUpdate+"update되었습니다.");
					
					String viewQuery = "SELECT DESCRIPTION FROM MENU WHERE CAFE_ID =1";
					PreparedStatement ps = con.prepareStatement(viewQuery);
					ResultSet result = ps.executeQuery();
					while(result.next()) {
						String menu = result.getString("DESCRIPTION");
						System.out.println("cname : "+menu);
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
				
		}
}
//SELECT*FROM EMPLOYEE WHERE BONUS = NULL AND MANAGER_ID ! =NULL;
