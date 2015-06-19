package dao;

/*****************************************************************************/
//商品を扱うDAO
/*****************************************************************************/

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import utility.DriverAccessor;
import beans.Item;

public class ItemDAO extends DriverAccessor{

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
