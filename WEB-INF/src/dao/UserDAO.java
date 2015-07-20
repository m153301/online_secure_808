package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.User;
import utility.DriverAccessor;

public class UserDAO extends DriverAccessor{

	public int check(String user_id, Connection connection) {
		// TODO Auto-generated method stub
		try{
			String sql = "select count(1) from user where user_id =?;";

			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, user_id);

			ResultSet rs = stmt.executeQuery();
			rs.first();

			int check = rs.getInt("count(1)");

			stmt.close();
			rs.close();

			return check;


		}catch(SQLException e){
			e.printStackTrace();
			return 0;

		}finally{
		}
	}

	public String Regist(User user, Connection connection) {
		// TODO Auto-generated method stub

		try{
			String sql = "insert into user values (?,?,?,?)";

			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1,user.getUserId());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getUserName());
			stmt.setString(4, user.getRole());

			stmt.executeUpdate();
			stmt.close();

			return user.getUserId();

		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}finally{
		}
	}

	public void updateUserInfo(String userId, String userName, String userPass, Connection connection) {
		try{
			String sql = "update user set user_name = ?,  password = ? where user_id = ?";

			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, userName);
			stmt.setString(2, userPass);
			stmt.setString(3, userId);
			stmt.executeUpdate();
			stmt.close();

		}catch(SQLException e){
			e.printStackTrace();
		}finally{
		}
	}
}