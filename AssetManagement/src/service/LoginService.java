package service;

import java.util.ArrayList;
import java.util.HashMap;

import dao.UserLoginDao;

public class LoginService {

	public HashMap<String,String> select(String table, ArrayList<String> values, HashMap<String, Object> parameters) {

		
		UserLoginDao dao= new UserLoginDao();
		 return dao.select(table, values, parameters);
	}	

}
