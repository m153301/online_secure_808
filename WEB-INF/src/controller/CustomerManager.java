package controller;

import java.sql.Connection;

import dao.CustomerDAO;
import dao.UserDAO;
import beans.Creditcard;
import beans.Customer;
import beans.User;

public class CustomerManager{
	
	private Connection connection = null;
	
	public CustomerManager(){
		
	}
	
	public int Regist(String id, String tel, String type,
			String name, String password, String credit_number){
		
		//idのかぶりがないかチェックしに行く
		int check = check(id);
		
		if(check == 0){
			
			//とりあえずuserテーブルを埋めに行く
			//いくついでにid持って帰ってくる
			String user_id = user_rel_regist(id, name, password);
			
			//次にカードテーブル埋めに行く
			//とりあえずカードは一回格納する
			creditregist(type, credit_number);
			
			Customer customer = new Customer();
			customer.setUserId(id);
			customer.setTel(tel);
			
			CustomerDAO dao = new CustomerDAO();
			this.connection = dao.createConnection();
			
			//とりあえずcustomerテーブルを埋めに行く
			dao.Regist(customer, this.connection);
			dao.closeConnection(this.connection);
			
			this.connection = null;
			
			//customer.credit_idとcreditcard.credicard_idを関連づける
			//そのためにまずcreditcard_idをnumberをもとにもってくる
			int creditcard_id = cutomer_rel_regist(credit_number);
			//持ってきたidとuser_idをもとにクレジットカードの登録を終える。
			CardRegist(creditcard_id, user_id);
			
			dao.closeConnection(this.connection);
			
			this.connection = null;
			
			return 0;
			
		}
		
		else
			return check;
		
		
		
	}
	
	public int check(String user_id) {
		// TODO Auto-generated method stub
		UserDAO dao = new UserDAO();
		this.connection = dao.createConnection();
		
		int check = dao.check(user_id, this.connection);
		
		dao.closeConnection(this.connection);
		this.connection = null;
		return check;
	}


	private void CardRegist(int creditcard_id, String user_id) {
		// TODO Auto-generated method stub
		CustomerDAO dao = new CustomerDAO();
		this.connection = dao.createConnection();
		
		dao.CardRegist(creditcard_id, user_id, connection);
		
		dao.closeConnection(this.connection);
		this.connection = null;
	}

	private int cutomer_rel_regist(String credit_number) {
		// TODO Auto-generated method stub
		CustomerDAO dao = new CustomerDAO();
		this.connection = dao.createConnection();
		
		//customer.credit_idとcreditcard.credicard_idを関連づける
		int id = dao.customer_rel_regist(credit_number, this.connection);
		
		dao.closeConnection(this.connection);
		this.connection = null;
		
		return id;
		
	}

	private String user_rel_regist(String id, String name, String password) {
		// TODO Auto-generated method stub
		User customer = new User();
		customer.setUserId(id);
		customer.setUserName(name);
		customer.setPassword(password);
		customer.setRole("customer");
		
		UserDAO dao = new UserDAO();
		this.connection = dao.createConnection();
		
		String user_id = dao.Regist(customer,this.connection);
		
		dao.closeConnection(this.connection);
		
		this.connection = null;
		
		return user_id;
		
	}
	
	private void creditregist(String type, String credit_number) {
		// TODO Auto-generated method stub
		Creditcard customer = new Creditcard();
		customer.setCreditcardNumber(credit_number);
		customer.setCreditcardType(type);
		
		CustomerDAO dao = new CustomerDAO();
		this.connection = dao.createConnection();
		
		dao.credit_rel_regist(customer, this.connection);
		
		dao.closeConnection(this.connection);
		
		this.connection = null;
		
		
	}
}