
package controller;

import java.sql.Connection;
import java.util.ArrayList;

import dao.PurchaseDAO;
import beans.Item;
import beans.User;

public class ItemPurchaseManager {

	private Connection connection = null;
	
    //引数をもたないコンストラクタ
	public ItemPurchaseManager(){
	}

	public void RegistPurchase(int item_id,int quant,User user){
	
		PurchaseDAO purchaseDAO = new PurchaseDAO();
		
		this.connection = purchaseDAO.createConnection();
		purchaseDAO.RegistPurchase(item_id,quant,user,connection);
		purchaseDAO.closeConnection(this.connection);

		this.connection = null;
		
	}
}
