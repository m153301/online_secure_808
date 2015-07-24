package controller;

import java.sql.Connection;

import dao.AccLockDAO;
import dao.LoginDAO;
import beans.User;
import beans.Ip_lock;

//とりあえず作ったからあとで直す
public class LoginManager{
	private Connection connection = null;
	
	public LoginManager(){
	}
	
	public User certifyUser(String id, String pass){
		LoginDAO dao = new LoginDAO();
		
		this.connection = dao.createConnection();
		User user = dao.certifyUser(id, this.connection);
		
		dao.closeConnection(this.connection);
		
		this.connection = null;
		
		if(user==null)
			return null;
		
		else if(pass.equals(user.getPassword())){
			return user;
		}
		
		else
			return null;
		
	}
	
	//重複チェック
	public Ip_lock checkOverlap(String ip){
		AccLockDAO dao = new AccLockDAO();
		this.connection = dao.createConnection();
		int count = dao.overlap(ip, connection);
		dao.closeConnection(this.connection);
		this.connection = null;
		//ipアドレスの登録があった場合
		if(count != 0){
			incrementCount(ip);
			
		}
		
		//ipアドレスの登録がない場合
		else{
			ipRegist(ip);
		}
		
		//最後に失敗回数を持って帰る
		Ip_lock fail_count = getCount(ip);
		return fail_count;
		
	}
	
	private Ip_lock getCount(String ip){
		AccLockDAO dao = new AccLockDAO();
		this.connection = dao.createConnection();
		Ip_lock count = dao.getCount(ip, connection);
		this.connection = null;
		return count;
	}
	
	private void ipRegist(String ip){
		AccLockDAO dao = new AccLockDAO();
		this.connection = dao.createConnection();
		dao.ipRegist(ip, connection);
		dao.closeConnection(this.connection);
		this.connection = null;
	}
	

	public void incrementCount(String ip){
		AccLockDAO dao = new AccLockDAO();
		this.connection = dao.createConnection();
		dao.increment(ip,connection);
		dao.closeConnection(this.connection);
		this.connection = null;
	}
	
	public void resetCount(String ip){
		AccLockDAO dao = new AccLockDAO();
		this.connection = dao.createConnection();
		dao.reset(ip, connection);
		dao.closeConnection(this.connection);
		this.connection = null;
	}
}