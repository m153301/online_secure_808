package dao;

/*****************************************************************************/
//商品を扱うDAO
/*****************************************************************************/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import beans.Item;

public class ItemDAO{

	private final static String DRIVER_URL =
		"jdbc:mysql://localhost:3306/secure?useUnicode=true&characterEncoding=UTF-8";

	private final static String DRIVER_NAME = "com.mysql.jdbc.Driver";

	private final static String USER_NAME = "mikoto";

	private final static String PASSWORD = "110hadoru";

	public Connection createConnection(){
		try{
			Class.forName(DRIVER_NAME);
			Connection con = DriverManager.getConnection(DRIVER_URL, USER_NAME, PASSWORD);
			return con;
		} catch(ClassNotFoundException e){
			System.out.println("Can't Find JDBC Driver.\n");

		} catch(SQLException e){
			System.out.println("Connect Error.\n");
		}
		return null;
	}

	public void closeConnection(Connection con){

		try{
			con.close();
		}catch(Exception ex){}
	}


	public void registItemInfoDAO(Item item, Connection connection){

		try{

			String sql = "insert into student values(?,?,?,?)";

			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setInt(1, item.getItemId());
			stmt.setString(2, item.getItemName());
			stmt.setInt(3, item.getItemPrice());
			stmt.setInt(4, item.getItemStock());


			stmt.executeUpdate();

		}catch(SQLException e){

			e.printStackTrace();

		} finally {

		}
	}
}
