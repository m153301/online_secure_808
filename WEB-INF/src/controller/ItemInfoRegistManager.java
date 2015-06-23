
package controller;

/*****************************************************************************/
//		商品登録、発注ログを同時に格納するManager
/*****************************************************************************/


import java.sql.Connection;
import java.util.Date;

import javax.servlet.http.HttpSession;

import dao.ItemDAO;
import beans.Item;
import beans.Ordered;
import beans.User;

public class ItemInfoRegistManager {

	private Connection connection = null;


	//Itemテーブルに発注した商品を格納。
	public void registItemInfo(Item item){
		ItemDAO itemDAO = new ItemDAO();
		this.connection = itemDAO.createConnection();

		itemDAO.registItemInfoDAO(item, connection);
		itemDAO.closeConnection(this.connection);

		this.connection = null;

	}

	//次に、誰が発注したかを記録する。
	//セッションからユーザIDを取得
	HttpSession session = request.getSession(true);
	User user = (User)session.getAttribute("user");

	Date date = new Date();
	Ordered ordered = new Ordered(0, user.getUserId(), 0, item_stock, date);

}
