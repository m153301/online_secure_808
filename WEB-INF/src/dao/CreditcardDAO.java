package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utility.DriverAccessor;
import beans.Creditcard;

public class CreditcardDAO extends DriverAccessor{

	public Creditcard selectCreditcardByCardNumAndCardType(String cardNum, String cardType, Connection connection){
		try{
			String sql = "select * from creditcard where creditcard_number = '" + cardNum + "' and creditcard_type = '" + cardType + "';";

			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			if( rs.next() ){
				Creditcard cd = new Creditcard();
				cd.setCreditcardId(rs.getInt("creditcard_id"));
				cd.setCreditcardNumber(rs.getString("creditcard_number"));
				cd.setCreditcardType(rs.getString("creditcard_type"));
				stmt.close();
				rs.close();
				return cd;
			}
			stmt.close();
			rs.close();
			return null;


		}catch(SQLException e){
			e.printStackTrace();
			return null;
		} finally {
		}
	}

	public int insertCreditcard(String cardNum, String cardType, Connection connection){
		try{
			String sql = "insert into creditcard (creditcard_number, creditcard_type) values (?,?)";

			PreparedStatement stmt = connection.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS);

			stmt.setString(1, cardNum);
			stmt.setString(2, cardType);
			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			int key = -1;
			  if (rs.next()) {
			   key =  rs.getInt(1);
			  }
			stmt.close();
			return key;

		}catch(SQLException e){
			e.printStackTrace();
			return -1;
		}finally{
		}
	}
}
