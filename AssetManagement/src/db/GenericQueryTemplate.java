package db;

import java.util.ArrayList;
import java.util.HashMap;

public interface GenericQueryTemplate {
	// select queries
	public Object selectAll(String table);

	public Object select(String table, HashMap<String,Object> parameters);
	public Object select(String table,ArrayList<String> values, HashMap<String,Object> parameters );

	// insert queries
	public int insert(String table, HashMap<String,Object> parameters);

	// delete queries
	public int delete(String table, HashMap<String,Object> parameters);

	// update queries
	public int update(String table, HashMap<String,Object> parameters,HashMap<String,Object> whereparameters);

}
