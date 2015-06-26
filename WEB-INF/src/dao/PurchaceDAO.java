package dao;

/*****************************************************************************/
//商品を扱うDAO
/*****************************************************************************/

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import utility.DriverAccessor;
import beans.Purchace;

public class PurchaceDAO extends DriverAccessor{


	//商品を登録する
	public ArrayList<Purchace> saleBrowseDAO(Connection connection){
		try{

			String sql="select * from purchace";

			PreparedStatement stmt = connection.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery(sql);

			ArrayList<Purchace> list = new ArrayList<Purchace>();

			while(rs.next())
		    {
			Purchace purchace = new Purchace(0, 0, null, 0, null);

			purchace.setPurchaceId(rs.getInt("purchace_id"));
			purchace.setItemId(rs.getInt("item_id"));
			purchace.setBuyDate(rs.getDate("buy_date"));
			purchace.setPurchaceQuantity(rs.getInt("purchace_quantity"));
			purchace.setUserId(rs.getString("user_id"));

			list.add(purchace);
			}

			stmt.close();
			rs.close();

			return list;

		}catch(SQLException e){

			e.printStackTrace();
			return null;

		} finally {

		}
	}

}
