
//　自分が格納されているフォルダ名
package dao;

//  自分が格納されているフォルダの外にある必要なクラス
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import beans.Ordered;
import utility.DriverAccessor;

public class OrderedDAO extends DriverAccessor{

	//  検索する
	//  引数はLearningオブジェクトと、Connectionオブジェクト
	public void registItemLog(Ordered ordered, Connection connection){

		try{

			//  SQLコマンド
			String sql = "insert into ordered values(?, ?, ?, ?, ?)";

			//  SQLのコマンドを実行する
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setInt(1, ordered.getOrderId());
			stmt.setString(2, ordered.getUserId());
			stmt.setInt(3, ordered.getItemId());
			stmt.setInt(4, ordered.getOrderQuantity());
			stmt.setDate(5, ordered.getOrderDate());
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