
package controller;

/*****************************************************************************/
//		商品登録、発注ログを同時に格納するManager
/*****************************************************************************/


import java.sql.Connection;
import java.util.ArrayList;

import dao.OrderedDAO;
import beans.Ordered;
import beans.Orderedlist;

public class OrderedBrowseManager {

	private Connection connection = null;

	public ArrayList<Orderedlist> orderedBrowse(){

		OrderedDAO orderedDAO = new OrderedDAO();
		this.connection = orderedDAO.createConnection();

		//全ての購入リストをとってくる
		ArrayList<Orderedlist> orderedlist = OrderedDAO.orderedBrowseDAO(connection);
		orderedDAO.closeConnection(this.connection);
		this.connection = null;

		return orderedlist;
	}
}
