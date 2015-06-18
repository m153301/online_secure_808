package controller;

import java.sql.Connection;

import dao.UserDAO;
import dao.WorkerDAO;
import beans.User;

public class WorkerManager{
	
	private Connection connection = null;
	
	public WorkerManager(){
		
	}

	public int Regist(String user_name, String user_id, String password) {
		// TODO Auto-generated method stub
		
		//idがpkだからかぶったらエラーを返す必要あり
		int check = check(user_id);
		
		if(check == 0){
			
			//まずはuserテーブルを埋めに行く
			//user_idは持って帰ってくる
			String id = user_rel_regist(user_name, user_id, password);
			
			//workerテーブルも存在するから持って帰ってきたidを登録しに行く
			//1つだし値だけもっていく
			WorkerDAO dao = new WorkerDAO();
			this.connection = dao.createConnection();
			
			dao.Regist(id, this.connection);
			dao.closeConnection(this.connection);
			this.connection = null;
			
			return 0;
			
		}
		
		else
			return check;
		
	}
		
		

	private int check(String user_id) {
		// TODO Auto-generated method stub
		UserDAO dao = new UserDAO();
		this.connection = dao.createConnection();
		
		int check = dao.check(user_id, this.connection);
		
		dao.closeConnection(this.connection);
		this.connection = null;
		return check;
	}

	private String user_rel_regist(String user_name, String user_id,
			String password) {
		// TODO Auto-generated method stub
		User worker = new User();
		worker.setUserName(user_name);
		worker.setUserId(user_id);
		worker.setPassword(password);
		worker.setRole("worker");
		
		UserDAO dao = new UserDAO();
		this.connection = dao.createConnection();
		
		String id = dao.Regist(worker, this.connection);
		
		
		return id;
	}
	
	
}