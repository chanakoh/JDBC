package chap2_MVC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class cafeModel {
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String username = "khcafe";
	String password = "KHCAFE";
	
	public void insertCafe(String C_NAME, String ADDRESS, String PHONE_NUMBER,String OPERATING_HOURS  ) {
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			String sql = "INSERT INT0 CAFES (C_NAME,ADDRESS,PHONE_NUMBER,OPERATING_HOURS)"
					+ "VALUES(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,C_NAME);
			ps.setString(2, ADDRESS);
			ps.setString(3,PHONE_NUMBER);
			ps.setString(4, OPERATING_HOURS);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void updateMenu(String DESCRIPTION, int MENU_ID) {
		
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			String sql = "UPDATE MENU SET DESCRIPTION = ? WHERE MENU_ID = ? ";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,DESCRIPTION);
			st.setInt(2, MENU_ID);
		//	st.setInt(3, CAFE_ID);
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	public void updateCafe(String OPERATING_HOURS, int CAFE_ID) {
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			String sql = "UPDATE CAFES SET OPERATING_HOURS = ? WHERE CAFE_ID = ? ";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, OPERATING_HOURS);
			st.setInt(2, CAFE_ID);
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
	public void selctCafe(int CAFE_ID) {
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			String sql = "SELECT * FROM CAFES WHERE CAFE_ID = ? ";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, CAFE_ID);
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
	public void findCafe(String find) {
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			String sql = "SELECT * FROM CAFES WHERE INSTR(ADDRESS,?) >0 ";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, find);
			ResultSet result = st.executeQuery();
		
			while(result.next()) {
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
	public void deleteCafe(int CAFE_ID) {
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			String sql = "DELETE FROM CAFES WHERE CAFE_ID = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1,CAFE_ID);
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void deleteMenu(int CAFE_ID) {
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			String sql = "DELETE FROM MENU WHERE CAFE_ID = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1,CAFE_ID);
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

/*public void selctMenu(String MENU_ID) {
	try {
		Connection con = DriverManager.getConnection(url, username, password);
		String sql = "SELECT * FROM MENU WHERE MENU_NAME = ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, MENU_ID);
		ResultSet result = st.executeQuery();
	
		while(result.next()) {
		int a = result.getInt("MENU_ID");
		int b = result.getInt("CAFE_ID");
		String c = result.getString("MENU_NAME");
		String d = result.getString("PRICE");
		String e = result.getString("DESCRIPTION");
		
		System.out.println("CAFE_ID:"+a);
		System.out.println("카페이름:"+b);
		System.out.println("주소:"+c);
		System.out.println("카페 연락처:"+d);
		System.out.println("운영시간:"+e);
		}
		}
	}*/

}
