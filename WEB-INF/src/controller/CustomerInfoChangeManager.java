package controller;

import java.util.ArrayList;
import java.util.List;

public class CustomerInfoChangeManager {

	public CustomerInfoChangeManager(){}
	
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
		else if( userInfo.get(1).isEmpty() ){
			errors.add("クレジットカード番号をご入力下さい。");
		}
		// customerIdのvalidation
		if( userInfo.get(4).length() > 12 ){
			errors.add("お客様IDは12文字以内でご入力下さい。");
		}
		else if( userInfo.get(4).isEmpty() ){
			errors.add("お客様IDをご入力下さい。");
		}
		else if( new CustomerManager().check( userInfo.get(4) ) != 0 ){
			errors.add("ご入力されたお客様IDは既に利用されています。");
		}
		
		// customerPasswordのvalidation
		if( userInfo.get(5).length() < 8 || userInfo.get(5).length() > 12 ){
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
