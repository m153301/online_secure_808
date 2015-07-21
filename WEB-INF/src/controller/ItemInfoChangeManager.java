package controller;

import java.sql.Connection;
import java.util.List;

import dao.ItemDAO;
import beans.Item;

public class ItemInfoChangeManager {

	private Connection connection = null;
	
	public ItemInfoChangeManager(){}
	
	public List<Item> searchItemInfoAll(){
		ItemDAO itemDAO = new ItemDAO();
		this.connection = itemDAO.createConnection();

		List<Item> items = itemDAO.getItemInfoDAO(connection);
		itemDAO.closeConnection(this.connection);

		this.connection = null;

		return items;
	}
	
	public void updateItemInfo(int itemId, String itemName, int itemPrice, int itemStock){
		ItemDAO itemDAO = new ItemDAO();
		this.connection = itemDAO.createConnection();

		itemDAO.updateItemInfo(itemId, itemName, itemPrice, itemStock, connection);
		itemDAO.closeConnection(this.connection);

		this.connection = null;
	
	}
	
	
}
