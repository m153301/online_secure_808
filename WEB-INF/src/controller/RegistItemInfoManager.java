
package controller;

/*****************************************************************************/
//		商品登録、発注ログを同時に格納するManager
/*****************************************************************************/


import java.sql.Connection;

import dao.ItemDAO;
import beans.Item;

public class RegistItemInfoManager {

	private Connection connection = null;


	public void registItemInfo(Item item){
		ItemDAO itemDAO = new ItemDAO();
		this.connection = itemDAO.createConnection();

		itemDAO.registItemInfoDAO(item, connection);
		itemDAO.closeConnection(this.connection);

		this.connection = null;

	}

}
