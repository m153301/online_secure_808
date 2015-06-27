
package controller;

/*****************************************************************************/
//		商品登録、発注ログを同時に格納するManager
/*****************************************************************************/


import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

import dao.ItemDAO;
import dao.OrderedDAO;
import dao.PurchaceDAO;
import beans.Item;
import beans.Ordered;
import beans.Purchace;

public class SaleBrowseManager {

	private Connection connection = null;

	public ResultSet saleBrowse(){
		PurchaceDAO purchaceDAO = new PurchaceDAO();
		this.connection = purchaceDAO.createConnection();

		ArrayList<Purchace> alllist = purchaceDAO.saleBrowseDAO(connection);
		purchaceDAO.closeConnection(this.connection);

		ArrayList<Purchace> quantitylist = new ArrayList<>();

		for(int i=0; i!=alllist.size(); i++){
			for(int j= 0; j!=quantitylist.size(); j++){
				if(alllist.get(i).equals(quantitylist.get(j))){


				}
			}

		}

		this.connection = null;

		return item_id;
	}


}
