package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	
	
	
}