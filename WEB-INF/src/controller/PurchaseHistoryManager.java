
package controller;

/*****************************************************************************/
//		商品一覧を取得するするManager
/*****************************************************************************/


import java.sql.Connection;
import java.util.ArrayList;

import dao.HistoryDAO;
import beans.Purchase;
import beans.User;

public class PurchaseHistoryManager {

	private Connection connection = null;

	//Itemテーブルに発注した商品を格納
	//格納した商品のitem_idを検索し、返り値として返す
	public ArrayList<Purchase> getPurchaseHistory(User user){

		ArrayList<Purchase> purchaseList = new ArrayList<Purchase>();
		
		HistoryDAO historyDAO = new HistoryDAO();
		
		this.connection = historyDAO.createConnection();
		purchaseList = historyDAO.getHistoryDAO(user,connection);
		historyDAO.closeConnection(this.connection);

		this.connection = null;

		return purchaseList;
	}
}
