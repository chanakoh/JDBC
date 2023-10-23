package com.kh.user.VODAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
	private Connection connection;
	public UserDAO(Connection connection) {
		this.connection = connection;
	}
	
	public boolean createUser(UserVO user) {
		String sql = "INSERT INTO USERINFO (user_id, user_name, email, reg_date)"
				+ "VALUES(?,?,?,?)";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1,user.getUserId() );
			st.setString(2,user.getUserName());
			st.setString(3,user.getUserName());
			st.setDate(4,new Date(user.getRegDate().getTime()));
			
			int rows = st.executeUpdate();
			return rows > 0; // 값이 들어오면 0보다 커지므로 true가 됨
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public List<UserVO>getAllUsers() throws SQLException {
		List<UserVO> users = new ArrayList<>();
		String sql = "SELECT * FROM USERINFO ";
		//try - with - resources
		//데이터베이스 리소스를 안전하게 사용하고 자동으로 닫아주기 위해서 사용되는 방법
			try(PreparedStatement st = connection.prepareStatement(sql)){
			ResultSet result = st.executeQuery();
			//selectOne = if, selectall = while
			while(result.next()) {
				UserVO user1 = new UserVO();
				user1.setUserId(result.getInt("user_id"));
				user1.setUserName(result.getString("user_name"));
				user1.setEmail(result.getString("email"));
				user1.setRegDate(result.getDate("reg_date"));
				users.add(user1);
			}
	}
		return users;
	}
}
