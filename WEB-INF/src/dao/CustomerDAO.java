package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import beans.Creditcard;
import beans.Customer;
import beans.User;
import utility.DriverAccessor;

public class CustomerDAO extends DriverAccessor{

	public void Regist(Customer customer, Connection connection) {
		// TODO Auto-generated method stub
		try{
			String sql = "insert into customer (user_id, tel) values (?,?);";
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, customer.getUserId());
			stmt.setString(2, customer.getTel());
			
			stmt.executeUpdate();
			stmt.close();
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			
		}
	}

	public String user_rel_regist(User customer, Connection connection) {
		// TODO Auto-generated method stub
		try{
			String sql = "insert into user values (?,?,?,?)";
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1,customer.getUserId());
			stmt.setString(2, customer.getPassword());
			stmt.setString(3, customer.getUserName());
			stmt.setString(4, customer.getRole());
			
			stmt.executeUpdate();
			stmt.close();
			
			return customer.getUserId();
			
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}finally{
			
		}
	}

	public void credit_rel_regist(Creditcard customer, Connection connection) {
		// TODO Auto-generated method stub
		try{
			String sql = "insert into creditcard (creditcard_type, creditcard_number)"
					+ "values (?,?);";
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, customer.getCreditcardType());
			stmt.setString(2, customer.getCreditcardNumber());
			
			stmt.executeUpdate();
			stmt.close();
			
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			
		}
	}

	public int customer_rel_regist(String credit_number, Connection connection) {
		// TODO Auto-generated method stub
		try{
			String sql = "select creditcard_id from creditcard where creditcard_number = ?;";
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, credit_number);
			
			ResultSet rs = stmt.executeQuery();
			rs.first();
			
			int id = rs.getInt("creditcard_id");
			stmt.close();
			rs.close();
			
			return id;
			
			
			
		}catch(SQLException e){
			e.printStackTrace();
			return 0;
		}finally{
			
		}
	}


	public void CardRegist(int creditcard_id, String user_id,
			Connection connection) {
		// TODO Auto-generated method stub
		try{
			String sql = "update customer set creditcard_id  = ? where user_id = ?";
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, creditcard_id);
			stmt.setString(2, user_id);
			
			stmt.executeUpdate();
			stmt.close();
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			
		}
	}


}