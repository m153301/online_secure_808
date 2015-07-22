package controller;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

import dao.ItemDAO;
import dao.OrderedDAO;
import beans.Item;
import beans.Ordered;

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
	
	public void orderItem(String workerId, int itemId, String itemName, int itemPrice, int itemStock, Date date){

		int presentItemStock = selectItemStock(itemId);

		int orderQuantity  = itemStock - presentItemStock;
		
		System.out.println(presentItemStock);
		System.out.println(itemStock);
		System.out.println(orderQuantity);
		
		updateOrderHistory(workerId ,itemId, orderQuantity, date);
		
		updateItemInfo(itemId, itemName, itemPrice, itemStock);

	}
	
	private int selectItemStock(int itemId){

		ItemDAO itemDAO = new ItemDAO();
		
		this.connection = itemDAO.createConnection();
		
		int presentItemStock = itemDAO.selectItemStock(itemId, this.connection);
		
		this.connection = null;

		return presentItemStock;
		
	}

	private void updateOrderHistory(String workerId, int itemId, int orderQuantity, Date date){
		OrderedDAO orderedDAO = new OrderedDAO();
		Ordered order = new Ordered();
		
		order.setUserId(workerId);
		order.setItemId(itemId);
		order.setOrderQuantity(orderQuantity);
		order.setOrderDate(date);
		
		this.connection = orderedDAO.createConnection();

		
		orderedDAO.registItemLog(order, connection);
		
		this.connection = null;
		
	}
	
	private void updateItemInfo(int itemId, String itemName, int itemPrice, int itemStock){
		ItemDAO itemDAO = new ItemDAO();
		this.connection = itemDAO.createConnection();

		itemDAO.updateItemInfo(itemId, itemName, itemPrice, itemStock, connection);
		itemDAO.closeConnection(this.connection);

		this.connection = null;
	
	}
	
	
}
