
package controller;

/*****************************************************************************/
//		おすすめ一覧を取得するManager
/*****************************************************************************/

import java.sql.Connection;

import dao.RecommendDAO;
import dao.ItemDAO;
import beans.Recommend;
import beans.Item;
import java.util.ArrayList;

public class RecommendGetManager {

	private Connection connection = null;

	//おすすめをrecommendテーブルから取得し、おすすめされている商品一覧を返す
	public ArrayList<Item> getRecommendedItem(){
		
		ArrayList<Recommend> recommendList = new ArrayList<Recommend>();
		ArrayList<Item> recommendedItemList = new ArrayList<Item>();
		
		//おすすめテーブルから一覧を取得
		RecommendDAO recommendDAO = new RecommendDAO();
		this.connection = recommendDAO.createConnection();
		recommendList = recommendDAO.getRecommendDAO(connection);
		recommendDAO.closeConnection(this.connection);
		this.connection = null;
		
		//おすすめリストから、商品リストを取得
		ItemDAO itemDAO = new ItemDAO();
		this.connection = itemDAO.createConnection();
		recommendedItemList = itemDAO.getItemFromRecommend(recommendList, connection);
		this.connection = null;
		
		return recommendedItemList;
	}
}