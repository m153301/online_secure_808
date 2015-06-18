package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import beans.User;
import utility.DriverAccessor;

public class WorkerDAO extends DriverAccessor{

	public String user_rel_regist(User worker, Connection connection) {
		// TODO Auto-generated method stub
		
		try{
			String sql = "insert into user values (?,?,?,?)";
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1,worker.getUserId());
			stmt.setString(2, worker.getPassword());
			stmt.setString(3, worker.getUserName());
			stmt.setString(4, worker.getRole());
			
			stmt.executeUpdate();
			stmt.close();
			
			return worker.getUserId();
			
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}finally{
			
		}
	}

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