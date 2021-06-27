package service;

import java.util.HashMap;

import dao.UserRegisterDao;

public class UserRegisterService {
	
	public int insert(String table, HashMap<String, Object> parameters)
	{
		UserRegisterDao dao = new UserRegisterDao();
		return dao.insert(table, parameters);
		}


}
