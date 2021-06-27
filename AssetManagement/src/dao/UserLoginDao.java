package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import db.GenericQuery;

public class UserLoginDao {

	public HashMap<String,String> select(String table, ArrayList<String> values, HashMap<String, Object> parameters) {

		HashMap<String,String> result= new HashMap<String,String>();	
		ResultSet rs = (ResultSet)( new GenericQuery().select(table, values, parameters));
		try {
			if (rs != null) {
				while (rs.next()) {
					result.put("id",rs.getString(1));
					result.put("role",rs.getString(2));
				}
			}
		} catch (SQLException e) {
			System.out.println("exception while login");
			e.printStackTrace();
		}
		return result;
	}

}
