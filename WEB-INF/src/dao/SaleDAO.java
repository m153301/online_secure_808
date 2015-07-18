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

			String sql="SELECT purchase.buy_date, purchase.purchase_quantity, item.item_name, item.item_price FROM purchase INNER JOIN item ON purchase.item_id = item.item_id;";

			PreparedStatement stmt = connection.prepareStatement(sql);
			//Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery();

			ArrayList<Sale> list = new ArrayList<Sale>();

			while(rs.next())
		    {
			Sale sale = new Sale(null, null, 0, 0);

			sale.setItemName(rs.getString("item.item_name"));
			sale.setBuyDate(rs.getDate("purchase.buy_date"));
			sale.setPurchaseQuantity(rs.getInt("purchase.purchase_quantity"));
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
