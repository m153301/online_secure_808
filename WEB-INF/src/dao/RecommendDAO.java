package dao;

/*****************************************************************************/
//おすすめを扱うDAO
/*****************************************************************************/

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;

import utility.DriverAccessor;
import beans.Recommend;

public class RecommendDAO extends DriverAccessor{


	//おすすめを登録する
	public void setRecommendDAO(Recommend recommend, Connection connection){
		try{

			//Recommendオブジェクトに入っているDateはjava.util.Dateなのでjava.sql.dateに変換
			java.util.Date d = recommend.getDate();
			Calendar cal = Calendar.getInstance();
			cal.setTime(d);
			cal.set(Calendar.HOUR_OF_DAY, 0);
			cal.set(Calendar.MINUTE, 0);
			cal.set(Calendar.SECOND, 0);
			cal.set(Calendar.MILLISECOND, 0);
			java.sql.Date d2 = new java.sql.Date(cal.getTimeInMillis());
			
			//sql文の実行
			String sql = "insert into recommend values(?,?,?)";

			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setInt(1, recommend.getItemId());
			stmt.setString(2, recommend.getWorkerId());
			stmt.setDate(3, d2);

			stmt.executeUpdate();

			stmt.close();
		}
		catch(SQLException e){
			
			e.printStackTrace();
			
		}
		finally {

		}
	}
	
	//おすすめ一覧を取得する
	public ArrayList<Recommend> getRecommendDAO(Connection connection){
		
		ArrayList<Recommend> recommendList = new ArrayList<Recommend>();
		
		try{
			String sql = "select * from recommend;";
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while( rs.next() )
			{

				Recommend recommend = new Recommend( 
						rs.getInt( "item_id" ), 
						rs.getString( "uesr_id" ),
						rs.getDate( "recommend_date" ) );
				recommendList.add( recommend );
			}

			stmt.close();
			rs.close();
		}
		catch(SQLException e){
			
				e.printStackTrace();
				
		}
		finally {
			
			}
			return recommendList;
		}

}
