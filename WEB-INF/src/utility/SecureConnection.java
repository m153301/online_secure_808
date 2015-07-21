package utility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import beans.Mysql;

public class SecureConnection{
	
	public Mysql generateUser(){
	
		try{
			FileReader fr = new FileReader("/home/tomcat/mysql.txt");
			BufferedReader br = new BufferedReader(fr);
			
			Mysql mysql_user = new Mysql();
			//countは行数でしかない
			for(int count = 1; count <= 4; count++){
				if(count == 1)
					mysql_user.setDriver_url(br.readLine());
				else if(count == 2)
					mysql_user.setDriver_name(br.readLine());
				else if(count == 3)
					mysql_user.setUser_name(br.readLine());
				else if(count == 4)
					mysql_user.setPassword(br.readLine());
				else{
					br.close();
					fr.close();
				}
			}
			return mysql_user;
			
		}catch(IOException e){
			e.printStackTrace();
			return null;
		}
	}
	
}
