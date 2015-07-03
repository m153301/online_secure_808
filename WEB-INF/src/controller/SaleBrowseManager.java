
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


		//多分quantitylistに何も入ってないから
		Sale sale = new Sale(null, null, 0, 0);
		quantitylist.add(0, sale);

		//日付と商品ごとの売上数を合算
		for(int i=0; i!=alllist.size(); i++){
			System.out.println(alllist.get(i).getBuyDate());
			for(int j= 0; j!=quantitylist.size(); j++){
				System.out.println(quantitylist.get(j).getBuyDate());
				if(alllist.get(i).getBuyDate().equals(quantitylist.get(j).getBuyDate()) && alllist.get(i).getItemName() == quantitylist.get(j).getItemName()){
					int quantity = alllist.get(i).getPurchaceQuantity() + quantitylist.get(j).getPurchaceQuantity();
					quantitylist.get(j).setPurchaceQuantity(quantity);
				}
				else{
					quantitylist.add(alllist.get(i));
				}
			}
		}

		this.connection = null;
		return quantitylist;
	}
}
