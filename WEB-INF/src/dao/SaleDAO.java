package dao;

/*****************************************************************************/
//売上を出すためのDAO
/*****************************************************************************/

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import utility.DriverAccessor;
import beans.Sale;

public class SaleDAO extends DriverAccessor{


	//売上を出すために商品名、購入日付、購入数、値段を検索する
	public static ArrayList<Sale> saleBrowseDAO(Connection connection){
		try{

			String sql="SELECT purchace.buy_date, purchace.purchase_quantity, item.item_name, item.item_price FROM purchace INNER JOIN item ON purchace.item_id = item.item_id;";

			PreparedStatement stmt = connection.prepareStatement(sql);
			//Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery();

			ArrayList<Sale> list = new ArrayList<Sale>();

			while(rs.next())
		    {
			Sale sale = new Sale(null, null, 0, 0);

			sale.setItemName(rs.getString("item.item_name"));
			sale.setBuyDate(rs.getDate("purchace.buy_date"));
			sale.setPurchaceQuantity(rs.getInt("purchace.purchase_quantity"));
			sale.setItemPrice(rs.getInt("item.item_price"));

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
