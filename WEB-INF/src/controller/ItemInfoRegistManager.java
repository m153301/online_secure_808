
package controller;

/*****************************************************************************/
//		商品登録、発注ログを同時に格納するManager
/*****************************************************************************/


import java.sql.Connection;

import dao.ItemDAO;
import dao.OrderedDAO;
import beans.Item;
import beans.Ordered;

public class ItemInfoRegistManager {

	private Connection connection = null;


	//Itemテーブルに発注した商品を格納
	//格納した商品のitem_idを検索し、返り値として返す
	public int registItemInfo(Item item){
		ItemDAO itemDAO = new ItemDAO();
		this.connection = itemDAO.createConnection();

		itemDAO.registItemInfoDAO(item, connection);
		int item_id = itemDAO.selectItemIdDAO(item.getItemName(),connection);
		itemDAO.closeConnection(this.connection);

		this.connection = null;

		return item_id;
	}


	//登録した商品を発注ログに格納する
	public void registItemLog(Ordered ordered) {
		OrderedDAO orderedDAO = new OrderedDAO();
		this.connection = orderedDAO.createConnection();

		orderedDAO.registItemLog(ordered, connection);
		orderedDAO.closeConnection(this.connection);

		this.connection = null;

	}

}
