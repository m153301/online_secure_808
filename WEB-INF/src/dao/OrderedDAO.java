
//　自分が格納されているフォルダ名
package dao;

//  自分が格納されているフォルダの外にある必要なクラス
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Ordered;
import beans.Orderedlist;
import utility.DriverAccessor;

public class OrderedDAO extends DriverAccessor{

	//発注した商品を格納する
	public void registItemLog(Ordered ordered, Connection connection){

		try{


			//  SQLコマンド
			String sql = "insert into ordered values(?, ?, ?, ?, ?)";

			//  SQLのコマンドを実行する
			PreparedStatement stmt = connection.prepareStatement(sql);

			java.util.Date d = new java.util.Date();
			java.sql.Date d2 = new java.sql.Date(d.getTime());

			/*
			System.out.println(ordered.getOrderId());
			System.out.println(ordered.getUserId());
			System.out.println(ordered.getItemId());
			System.out.println(ordered.getOrderQuantity());
			System.out.println(d2);
			*/

			stmt.setInt(1, ordered.getOrderId());
			stmt.setString(2, ordered.getUserId());
			stmt.setInt(3, ordered.getItemId());
			stmt.setDate(4, d2);
			stmt.setInt(5, ordered.getOrderQuantity());

			stmt.executeUpdate();

			//  終了処理
			stmt.close();

			}
			catch(SQLException e){

				//	エラーが発生した場合、エラーの原因を出力し、nullオブジェクトを返す
				e.printStackTrace();

			}
			finally{}
	}


	//発注履歴を検索する
	public static ArrayList<Orderedlist> orderedBrowseDAO(Connection connection){
		try{

			String sql="SELECT ordered.order_id, user.user_name, item.item_name, ordered.order_date, ordered.order_quantity FROM user INNER JOIN (item INNER JOIN ordered ON item.item_id = ordered.item_id) ON ordered.user_id = user.user_id;";

			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			ArrayList<Orderedlist> list = new ArrayList<Orderedlist>();

			while(rs.next())
		    {
			Orderedlist orderedlist = new Orderedlist(0, null, null, 0, null);

			orderedlist.setOrderId(rs.getInt("ordered.order_id"));
			orderedlist.setUserName(rs.getString("user.user_name"));
			orderedlist.setItemName(rs.getString("item.item_name"));
			orderedlist.setOrderDate(rs.getDate("ordered.order_date"));
			orderedlist.setOrderQuantity(rs.getInt("ordered.order_quantity"));

			list.add(orderedlist);
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