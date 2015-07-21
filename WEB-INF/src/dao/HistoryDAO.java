package dao;

/*****************************************************************************/
//商品を扱うDAO
/*****************************************************************************/

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import utility.DriverAccessor;
import beans.Purchase;
import beans.User;

public class HistoryDAO extends DriverAccessor{
	
	//商品一覧を取得する
	public ArrayList<Purchase> getHistoryDAO(User user,Connection connection){
		
		ArrayList<Purchase> purchaseList = new ArrayList<Purchase>();
		
		try{
			String sql = "select * from purchase inner join item on purchase.item_id = item.item_id where purchase.user_id='" + user.getUserId() + "';";
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while( rs.next() )
			{

				Purchase purchase = new Purchase( 
						rs.getInt( "purchase_id" ),
						rs.getInt( "item_id" ),
						rs.getString( "item_name" ),
						rs.getDate( "buy_date" ),
						rs.getInt( "purchase_quantity"  ), 
						rs.getString( "user_id"  ) );
				purchaseList.add( purchase );
			}

			stmt.close();
			rs.close();
		}
		catch(SQLException e){
				e.printStackTrace();
		}
		finally {
			
			}
			return purchaseList;
		}

}

