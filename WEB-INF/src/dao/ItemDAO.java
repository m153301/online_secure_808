package dao;

/*****************************************************************************/
//生徒を追加するDAO
/*****************************************************************************/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import beans.Item;
import beans.User;

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


	public void addStudent(User user, Connection connection){

		try{

			String sql = "insert into student values(?,?,?,?,?)";

			PreparedStatement stmt = connection.prepareStatement(sql);


			System.out.println(student.getStudentID());

			stmt.setString(1, student.getStudentID());
			stmt.setString(2, student.getPassword());
			stmt.setString(3, student.getName());
			stmt.setString(4, student.getStudentClass());
			stmt.setInt(5, student.getNumber());

			stmt.executeUpdate();

		}catch(SQLException e){

			e.printStackTrace();

		} finally {

		}
	}
}
