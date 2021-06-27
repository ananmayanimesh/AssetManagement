package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GenericQuery implements GenericQueryTemplate {

	static Connection connection = ConnectionManager.getConnection();
	PreparedStatement pstmt = null;

	
	 

	public GenericQuery() {
	}

	

	@Override
	public Object selectAll(String table) {

		Object result = null;
		pstmt = null;
		String strQuery = "SELECT * FROM  $tableName ";
		strQuery = strQuery.replace("$tableName", table);

		try {
			pstmt = connection.prepareStatement(strQuery);
			result = (Object) pstmt.executeQuery();

		} catch (SQLException e) {
			System.out.println("Exception occured while executing query");
			e.printStackTrace();
		}
		return result;

	}

	@Override
	public Object select(String table, HashMap<String, Object> parameters) {

		pstmt = null;
		Object result = null;
		String query = new String("Select * from $tableName where ");
		query = query.replace("$tableName", table);

		try {
			query = makeQuery(query, parameters);

			pstmt = connection.prepareStatement(query.toString());
			result = pstmt.executeQuery();

		} catch (Exception e) {
			System.out.println("Exception occured while executing query");
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public Object select(String table, ArrayList<String> values, HashMap<String, Object> parameters) {
		pstmt = null;

		Object result = null;
		String query = new String("Select ");

		try {
			int listsize = values.size();
			for (String item : values) {
				query += item;
				listsize--;

				if (listsize > 0)
					query += ",";
			}
			query += "  from $tableName where ";
			query = query.replace("$tableName", table);
			query = makeQuery(query, parameters);
			pstmt = connection.prepareStatement(query.toString());
			result = pstmt.executeQuery();

		} catch (Exception e) {
			System.out.println("Exception while creating query");
			e.printStackTrace();
		}
		return result;

	}

	@Override
	public int insert(String table, HashMap<String, Object> parameters) {

		// insert into tablename(_,_,----) values(-,-)
		int size = parameters.size();
		int rows_inserted = 0;
		ArrayList<Object> values = new ArrayList<Object>();
		String query = new String("insert into $tableName (");
		query = query.replace("$tableName", table);
		try {
			for (Map.Entry<String, Object> item : parameters.entrySet()) {

				query += (item.getKey());
				values.add(item.getValue());

				size--;
				if (size > 0)
					query += ",";

			}
			query += ") values(";
			query = makeInsertQuery(query, values);
			pstmt = connection.prepareStatement(query);
			rows_inserted = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("Exception while inserting data");
			e.printStackTrace();
		}

		return rows_inserted;
	}

	@Override
	public int delete(String table, HashMap<String, Object> parameters) {
		// delete from tablename where --=--- and ---=---;

		int rows_deleted = 0;

		String query = "delete from $tableName where ";
		query = query.replace("$tableName", table);

		try {
			query = makeQuery(query, parameters);
			pstmt = connection.prepareStatement(query);
			rows_deleted = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("Exception while deleting data");
			e.printStackTrace();
		}

		return rows_deleted;
	}

	@Override
	public int update(String table, HashMap<String, Object> parameters, HashMap<String, Object> whereparameters) {

		int rows_updated = 0;

		String query = "update $tableName set  ";
		query = query.replace("$tableName", table);

		try {
			query = makeUpdateQuery(query, parameters);
			query += " where ";
			query = makeQuery(query, whereparameters);
			pstmt = connection.prepareStatement(query);
			rows_updated = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("Exception while deleting data");
			e.printStackTrace();
		}

		return rows_updated;

	}

	public void close() {
		try {
			if (connection != null)
				connection.close();
			if (pstmt != null)
				pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String makeQuery(String query, HashMap<String, Object> parameters) {
		int size = parameters.size();

		for (Map.Entry<String, Object> item : parameters.entrySet()) {

			query += (item.getKey());
			query += "=";
			Object value = (item.getValue());
			if (value instanceof Integer) {
				query += (Integer) value;

			} else if (value instanceof Float) {
				query += (Float) value;
			} else if (value instanceof Double) {
				query += (Double) value;
			} else if (value instanceof String) {
				query = query + "'";
				query += (String) value;
				query = query + "'";
			}

			size--;
			if (size > 0)
				query += " and ";
		}
		return query;
	}

	public String makeInsertQuery(String query, ArrayList<Object> list) {
		int size = list.size();

		for (Object value : list) {
			if (value instanceof Integer) {
				query += (Integer) value;

			} else if (value instanceof Float) {
				query += (Float) value;
			} else if (value instanceof Double) {
				query += (Double) value;
			} else if (value instanceof String) {
				query = query + "'";
				query += (String) value;
				query = query + "'";
			}
			size--;
			if (size > 0)
				query += ",";
		}
		query += ")";
		return query;

	}
	
	public String makeUpdateQuery(String query, HashMap<String, Object> parameters) {
		int size = parameters.size();

		for (Map.Entry<String, Object> item : parameters.entrySet()) {

			query += (item.getKey());
			query += "=";
			Object value = (item.getValue());
			if (value instanceof Integer) {
				query += (Integer) value;

			} else if (value instanceof Float) {
				query += (Float) value;
			} else if (value instanceof Double) {
				query += (Double) value;
			} else if (value instanceof String) {
				query = query + "'";
				query += (String) value;
				query = query + "'";
			}

			size--;
			if (size > 0)
				query += " , ";
		}
		return query;
	}

}
