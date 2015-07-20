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
import beans.Item;

public class ItemDAO extends DriverAccessor{


	//商品を登録する
	public void registItemInfoDAO(Item item, Connection connection){
		try{

			String sql = "insert into item values(?,?,?,?)";

			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setInt(1, item.getItemId());
			stmt.setString(2, item.getItemName());
			stmt.setInt(3, item.getItemPrice());
			stmt.setInt(4, item.getItemStock());

			stmt.executeUpdate();

			stmt.close();
		}catch(SQLException e){

			e.printStackTrace();

		} finally {

		}
	}

	//登録した商品の商品IDを検索する
	public int selectItemIdDAO(String item_name, Connection connection){

		int item_id=0;
		try{

			String sql = "select item_id from item where item_name = '"+ item_name +"'";
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			rs.next();
			item_id = rs.getInt("item_id");

			stmt.close();
			rs.close();
		}catch(SQLException e){

			e.printStackTrace();

		} finally {

		}
		return item_id;
	}
	
	//商品一覧を取得する
	public ArrayList<Item> getItemInfoDAO(Connection connection){
		
		ArrayList<Item> itemList = new ArrayList<Item>();
		
		try{
			String sql = "select * from item;";
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while( rs.next() )
			{

				Item item = new Item( 
						rs.getInt( "item_id" ), 
						rs.getString( "item_name" ),
						rs.getInt( "item_price"  ), 
						rs.getInt( "item_stock"  ) );
				itemList.add( item );
			}

			stmt.close();
			rs.close();
		}
		catch(SQLException e){
				e.printStackTrace();
		}
		finally {
			
			}
			return itemList;
		}

	public void updateItemInfo(int itemId, String itemName, int itemPrice, int itemStock, Connection connection){
		try{
			String sql = "update item set item_name = ?, item_price = ?, item_stock = ? where item_id = ?;";

			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, itemName);
			stmt.setInt(2, itemPrice);
			stmt.setInt(3, itemStock);
			stmt.setInt(4, itemId);

			stmt.executeUpdate();
		
			stmt.close();
		}
		catch(SQLException e){
				e.printStackTrace();
		}
		finally {
			
			}
	}

}
