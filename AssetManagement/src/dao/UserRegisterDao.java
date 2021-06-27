package dao;

import java.util.HashMap;

import db.GenericQuery;

public class UserRegisterDao {
	
	public int insert(String table, HashMap<String, Object> parameters)
	{		
		return new GenericQuery().insert(table,parameters);
		
	}

}
