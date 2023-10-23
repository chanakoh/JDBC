package com.kh.user.VODAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class UserMain {

	public static void main(String[] args) {
		UserMain um = new UserMain();
		um.selectScanner();
	}
	public boolean checkId(int userId) {
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUserName = "KHCAFE";
		String dbPassWord = "KHCAFE";
		try {
			Connection cc = DriverManager.getConnection(jdbcURL, dbUserName, dbPassWord);
			//2.sql작성
			String sql = "SELECT COUNT(*) FROM USERINFO WHERE USER_ID = ?";
			PreparedStatement st = cc.prepareStatement(sql);
			st.setInt(1, userId);
			//3.if활용해서 result.next()
			ResultSet result = st.executeQuery();
			if(result.next()) {
				int count = result.getInt(1);
				return count >0;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}return false;
		//1.db연결
		
		
		//4.return >0 1이상이면 일치
	}
	public boolean checkName(String userName) throws SQLException {
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUserName = "KHCAFE";
		String dbPassWord = "KHCAFE";
		Connection cc = DriverManager.getConnection(jdbcURL, dbUserName, dbPassWord);
		String sql = "SELECT COUNT(*) FROM USERINFO WHERE USER_NAME = ?";
		PreparedStatement st = cc.prepareStatement(sql);
		st.setString(1, userName);
		ResultSet result = st.executeQuery();
		if(result.next()) {
			int count = result.getInt(1);
			return count>0;
		}return false;
	}
 	public void selectAll() {
		// 1. DB 연결 URL, USERNAME, PASSWORD
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUserName = "KHCAFE";
		String dbPassWord = "KHCAFE";
		
		try {
			Connection connection = DriverManager.getConnection(jdbcURL, dbUserName, dbPassWord);
			UserDAO userDAO = new UserDAO(connection);
			
			List<UserVO> users = userDAO.getAllUsers();
			for(UserVO u : users) {
				System.out.println("user id:"+u.getUserId());
				System.out.println("user name:"+u.getUserName());
				System.out.println("user email:"+u.getEmail());
				System.out.println("user date: "+u.getRegDate());
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void insertRun() {
		
		}
	public void selectScanner() {
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUserName = "KHCAFE";
		String dbPassWord = "KHCAFE";
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("user id 입력해주세요.");
			System.out.println("종료하고 싶다면 특수문자 제외 [e] 입력");
			String input = sc.nextLine();
			System.out.println("유저 네임 입력해주세요");
			String input2 = sc.next();
			
			
			if("e".equalsIgnoreCase(input)) {
				System.out.println("종료하겠습니다.");
				break; // break가 없으면 종료되지 않음 종료하겠습니다 말만 나몽
			}
			//select 출력하기
			
		try {
			Connection cc = DriverManager.getConnection(jdbcURL, dbUserName, dbPassWord);
			int userId = Integer.parseInt(input);
			String userName = input2;
			String sql = "SELECT * FROM USERINFO WHERE user_id = ? AND user_name = ?";
			PreparedStatement st = cc.prepareStatement(sql);
			st.setInt(1, userId);
			st.setString(2, userName);
			ResultSet rs = st.executeQuery();
			
			//selectOne if
			if(rs.next()) {
				System.out.println("user id :"+ rs.getInt("user_id"));
				System.out.println("user name :"+ rs.getString("user_name"));
				System.out.println("email :"+ rs.getString("email"));
				System.out.println("date :"+ rs.getDate("reg_date"));
			} else {
				boolean idTrue = checkId(userId);
				boolean nameTrue = checkName(userName);
				if(idTrue && nameTrue) {
					System.out.println("일치하지 않는 User ID입니다.");
				}else if(idTrue && !nameTrue) {
					System.out.println("일치하지 않는 user name입니다.");
					System.out.println();
					
				}else {
					System.out.println("일치하는 userid와 username을 찾을 수 없습니다.");
					System.out.println();
				}
				
			}

		}
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
}
		
	


/*		try {
Connection connection = DriverManager.getConnection(jdbcURL, dbUserName, dbPassWord);
UserDAO userDao = new UserDAO(connection);

Scanner sc = new Scanner(System.in);
System.out.println("User id :");
int userid = sc.nextInt();
System.out.println("ID를 입력 해주세요 :");
String userName = sc.next();
System.out.println("회원가입이 거의다 끝났습니다.");
System.out.println("마지막으로 이메일 작성해주세요");
String email = sc.next();
Date regDate = new Date(); //현재 날짜와 시간을 사용한다는 의미

//db에 담기위해 인스턴스 생성 후 작성받은 정보 저장하기
UserVO newUser = new UserVO();
newUser.setUserId(userid);
newUser.setUserName(userName);
newUser.setEmail(email);
newUser.setRegDate(regDate);

//데이터가 정상적으로 들어갔는지 boolean을 사용해서 확인
if(userDao.createUser(newUser)) {//TRUE
	System.out.println("유저가 성공적으로 등록되었습니다.");
}else {							//false
	System.out.println("유저 등록에 실패하였습니다.");
}
//연결 닫기
connection.close();
} catch (SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}*/
