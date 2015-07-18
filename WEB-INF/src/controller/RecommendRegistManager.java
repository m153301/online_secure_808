
package controller;

/*****************************************************************************/
//		おすすめ登録をするManager
/*****************************************************************************/


import java.sql.Connection;

import dao.RecommendDAO;
import beans.Recommend;

public class RecommendRegistManager {

	private Connection connection = null;

	//おすすめをrecommendテーブルに格納する
	public void setRecommend(Recommend recommend){
		
		RecommendDAO recommendDAO = new RecommendDAO();
		
		this.connection = recommendDAO.createConnection();
		recommendDAO.setRecommendDAO(recommend, connection);
		recommendDAO.closeConnection(this.connection);

		this.connection = null;
	}
}