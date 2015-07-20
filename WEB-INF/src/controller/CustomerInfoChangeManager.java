package controller;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;

import beans.Creditcard;
import dao.CreditcardDAO;
import dao.CustomerDAO;
import dao.UserDAO;

public class CustomerInfoChangeManager {

	private Connection connection = null;

	public CustomerInfoChangeManager(){}

	public void updateCustomerInfo(String userId, String userName, String userPass, String tel, String cardNum, String cardType){
		updateUserInfo(userId, userName, userPass);
		updateCustomerTel(tel, userId);
		Creditcard cr = selectCreditcard(cardNum, cardType);
		if(  cr != null ){
			updateCustomerCardId( cr.getCreditcardId(), userId );
		}
		else {
			int key = insertCreditcard(cardNum, cardType);
			updateCustomerCardId( key, userId );
		}
	}

	private  Creditcard selectCreditcard(String cardNum, String cardType) {
		CreditcardDAO cd = new CreditcardDAO();
		this.connection = cd.createConnection();
		Creditcard cr = cd.selectCreditcardByCardNumAndCardType(cardNum, cardType, this.connection);
		cd.closeConnection(this.connection);
		this.connection = null;
		return cr;
	}

	private void updateUserInfo(String userId, String userName, String userPass) {
		UserDAO ud = new UserDAO();
		this.connection = ud.createConnection();
		ud.updateUserInfo(userId, userName, userPass, connection);
		ud.closeConnection(this.connection);
		this.connection = null;
	}

	private void updateCustomerCardId(int cardId, String userId) {
		CustomerDAO cd = new CustomerDAO();
		this.connection = cd.createConnection();
		cd.updateCardId(userId, cardId, this.connection);
		cd.closeConnection(this.connection);
		this.connection = null;
	}

	private void updateCustomerTel(String tel, String userId) {
		CustomerDAO cd = new CustomerDAO();
		this.connection = cd.createConnection();
		cd.updateTel(userId, Integer.parseInt(tel), this.connection);
		cd.closeConnection(this.connection);
		this.connection = null;
	}
	
	private int insertCreditcard(String cardNum, String cardType){
		CreditcardDAO cd = new CreditcardDAO();
		this.connection = cd.createConnection();
		int key = cd.insertCreditcard(cardNum, cardType, this.connection);
		cd.closeConnection(this.connection);
		this.connection = null;
		return key;
	}

	public List<String> validator(List<String> userInfo){

		List<String> errors = new ArrayList<String>();

		// user_nameのvalidation
		if( userInfo.get(0).length() > 50 ){
			errors.add("お名前は50文字以内でご入力下さい。");
		}
		else if( userInfo.get(0).isEmpty() ){
			errors.add("お名前をご入力下さい。");
		}

		// telのvalidation
		if( !isNumber(userInfo.get(1)) ){
			errors.add("電話番号は半角数字でご入力下さい。");
		}
		else if( userInfo.get(1).length() > 12 ){
			errors.add("電話番号は12桁以内でご入力下さい。");
		}
		else if( userInfo.get(1).isEmpty() ){
			errors.add("電話番号をご入力下さい。");
		}

		// creditcardのvalidation
		if( !isNumber(userInfo.get(2)) ){
			errors.add("クレジットカード番号は半角数字でご入力下さい。");
		}
		else if( userInfo.get(2).length() > 16 ){
			errors.add("クレジットカード番号は16桁以内でご入力下さい。");
		}
		else if( userInfo.get(2).isEmpty() ){
			errors.add("クレジットカード番号をご入力下さい。");
		}

		/*
		if( userInfo.get(4).length() > 12 ){
			errors.add("お客様IDは12文字以内でご入力下さい。");
		}
		else if( userInfo.get(4).isEmpty() ){
			errors.add("お客様IDをご入力下さい。");
		}
		else if( new CustomerManager().check( userInfo.get(4) ) != 0 ){
			errors.add("ご入力されたお客様IDは既に利用されています。");
		}
		 */

		// customerPasswordのvalidation
		if( userInfo.get(3).length() < 8 || userInfo.get(3).length() > 12 ){
			errors.add("パスワードは8文字以上12文字以内でご入力下さい。");
		}

		return errors;
	}

	private boolean isNumber(String num){
		try {
			Integer.parseInt(num);
			return true;
		} catch (NumberFormatException nfex) {
			return false;
		}	
	}

}
