
package controller;

/*****************************************************************************/
//		商品登録、発注ログを同時に格納するManager
/*****************************************************************************/


import java.sql.Connection;
import java.util.ArrayList;

import dao.SaleDAO;
import beans.Sale;

public class SaleBrowseManager {

	private Connection connection = null;

	public ArrayList<Sale> saleBrowse(){

		SaleDAO saleDAO = new SaleDAO();
		this.connection = saleDAO.createConnection();

		//全ての購入リストをとってくる
		ArrayList<Sale> alllist = SaleDAO.saleBrowseDAO(connection);
		saleDAO.closeConnection(this.connection);

		ArrayList<Sale> quantitylist = new ArrayList<>();

		quantitylist.add(0, alllist.get(0));

		//System.out.println("size=" + alllist.size());

		//日付と商品ごとの売上数を合算
		for(int i=1; i<alllist.size(); i++){
			int c = 0;

			for(int j= 0; j<quantitylist.size(); j++){

				if(alllist.get(i).getBuyDate().equals(quantitylist.get(j).getBuyDate()) && alllist.get(i).getItemName().equals(quantitylist.get(j).getItemName())){
					int quantity = alllist.get(i).getPurchaseQuantity() + quantitylist.get(j).getPurchaseQuantity();
					quantitylist.get(j).setPurchaseQuantity(quantity);
					c = 1;
				}

			}
			if(c==0){
				quantitylist.add(alllist.get(i));
			}

		}

		this.connection = null;
		return quantitylist;
	}
}
