
//　自分が格納されているフォルダ名
package dao;

//  自分が格納されているフォルダの外にある必要なクラス
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import beans.Ordered;
import utility.DriverAccessor;

public class OrderedDAO extends DriverAccessor{

	public void registItemLog(Ordered ordered, Connection connection){

		try{


			//  SQLコマンド
			String sql = "insert into ordered values(?, ?, ?, ?, ?)";

			//  SQLのコマンドを実行する
			PreparedStatement stmt = connection.prepareStatement(sql);

			java.util.Date d = new java.util.Date();
			java.sql.Date d2 = new java.sql.Date(d.getTime());

			stmt.setInt(1, ordered.getOrderId());
			stmt.setString(2, ordered.getUserId());
			stmt.setInt(3, ordered.getItemId());
			stmt.setInt(4, ordered.getOrderQuantity());
			stmt.setDate(5, d2);

			//  終了処理
			stmt.close();

			}
			catch(SQLException e){

				//	エラーが発生した場合、エラーの原因を出力し、nullオブジェクトを返す
				e.printStackTrace();

			}
			finally{}
	}

}