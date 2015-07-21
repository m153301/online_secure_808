
package controller;

/*****************************************************************************/
//		商品一覧を取得するするManager
/*****************************************************************************/


import java.sql.Connection;
import java.util.ArrayList;

import dao.ItemDAO;
import beans.Item;

public class ItemInfoGetManager {

	private Connection connection = null;

	//Itemテーブルに発注した商品を格納
	//格納した商品のitem_idを検索し、返り値として返す
	public ArrayList<Item> getItemInfo(){

		ArrayList<Item> itemList = new ArrayList<Item>();
		
		ItemDAO itemDAO = new ItemDAO();
		
		this.connection = itemDAO.createConnection();
		itemList = itemDAO.getItemInfoDAO(connection);
		itemDAO.closeConnection(this.connection);

		this.connection = null;

		return itemList;
	}
}
