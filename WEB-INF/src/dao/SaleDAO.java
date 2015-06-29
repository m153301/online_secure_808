package dao;

/*****************************************************************************/
//売上を出すためのDAO
/*****************************************************************************/

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import utility.DriverAccessor;
import beans.Sale;

public class SaleDAO extends DriverAccessor{


	//売上を出すために商品名、購入日付、購入数、値段を検索する
	public static ArrayList<Sale> saleBrowseDAO(Connection connection){
		try{

			String sql="SELECT purchace.buyDate, purchace.purchaceQuantity, item.itemName, item.itemPrice FROM purchace INNER JOIN item ON purchace.itemId = item.itemId;";

			PreparedStatement stmt = connection.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery(sql);

			ArrayList<Sale> list = new ArrayList<Sale>();

			while(rs.next())
		    {
			Sale sale = new Sale(null, null, 0, 0);

			sale.setItemName(rs.getString("item.itemName"));
			sale.setBuyDate(rs.getDate("purchace.buyDate"));
			sale.setPurchaceQuantity(rs.getInt("purchace.purchaceQuantity"));
			sale.setItemPrice(rs.getInt("item.itemPrice"));

			list.add(sale);
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
