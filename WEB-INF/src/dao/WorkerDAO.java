package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import beans.User;
import utility.DriverAccessor;

public class WorkerDAO extends DriverAccessor{


	public void Regist(String id, Connection connection) {
		// TODO Auto-generated method stub
		try{
			String sql ="insert into worker values (?);";
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, id);
			
			stmt.executeUpdate();
			stmt.close();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			
		}
	}
	
}