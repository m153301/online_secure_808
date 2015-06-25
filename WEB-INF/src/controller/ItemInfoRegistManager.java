
package controller;

/*****************************************************************************/
//		商品登録、発注ログを同時に格納するManager
/*****************************************************************************/


import java.sql.Connection;
import java.util.Date;

import javax.servlet.http.HttpSession;

import dao.ItemDAO;
import dao.OrderedDAO;
import beans.Item;
import beans.Ordered;
import beans.User;

public class ItemInfoRegistManager {

	private Connection connection = null;


	//Itemテーブルに発注した商品を格納
	//item_idを検索し、返り値として返す
	public int registItemInfo(Item item){
		ItemDAO itemDAO = new ItemDAO();
		this.connection = itemDAO.createConnection();

		itemDAO.registItemInfoDAO(item, connection);
		itemDAO.closeConnection(this.connection);

		int item_id = itemDAO.selectItemIdDAO(item.getItemName(),connection);

		this.connection = null;

		return item_id;
	}

	public void registItemLog(Ordered ordered) {
		OrderedDAO orderedDAO = new OrderedDAO();
		this.connection = orderedDAO.createConnection();

		orderedDAO.registItemLog(ordered, connection);

		this.connection = null;

	}

}
