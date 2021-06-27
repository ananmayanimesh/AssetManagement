package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import db.GenericQuery;

public class CategoryManipulation {


    public long getCategoryId(final String category_name) {

        String categoryInString=null;
        GenericQuery genericQuery = new GenericQuery();

        HashMap<String, Object> queryConditionParams = new HashMap<>();
        queryConditionParams.put("categoryName", category_name);
        ArrayList<String> queryRequestValues = new ArrayList<>();
        queryRequestValues.add("categoryId");
        Object categoryId = genericQuery.select("category", queryRequestValues, queryConditionParams);

        ResultSet categoryIdResultSet = (ResultSet) categoryId;

        try {
			while (categoryIdResultSet.next()) {
			    categoryInString = categoryIdResultSet.getString("category_name");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        return Integer.parseInt(categoryInString);
    }


    public boolean checkCategory(final String category_name) {

        String categoryInString= null;
        GenericQuery genericQuery =  new GenericQuery();

        HashMap<String, Object> queryConditionParams = new HashMap<>();
        queryConditionParams.put("categoryName", category_name);
        ArrayList<String> queryValues = new ArrayList<>();
        queryValues.add("categoryId");
        Object categoryId = genericQuery.select("category", queryValues, queryConditionParams);

        ResultSet categoryIdResultSet = (ResultSet) categoryId;

        try {
			while (categoryIdResultSet.next()) {
			    categoryInString = categoryIdResultSet.getString("category_name");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        if (categoryInString == null) {
            return false;
        } else {
            return true;
        }
    }


}