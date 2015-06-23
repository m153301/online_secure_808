package dao;

/*****************************************************************************/
//商品を扱うDAO
/*****************************************************************************/

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

import utility.DriverAccessor;
import beans.Item;

public class ItemDAO extends DriverAccessor{

	public int registItemInfoDAO(Item item, Connection connection){

		try{

			String sql = "insert into item values(?,?,?,?)";

			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setInt(1, item.getItemId());
			stmt.setString(2, item.getItemName());
			stmt.setInt(3, item.getItemPrice());
			stmt.setInt(4, item.getItemStock());

			String sql2 = "select item_id from item where item_name = '?'";
			Statement stmt2 = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql2);
			stmt.setString(1, item.getItemName());

			stmt.executeUpdate();

		}catch(SQLException e){

			e.printStackTrace();

		} finally {

		}
	}
}
