package servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.GenericQuery;

/**
 * Servlet implementation class FetchUserData
 */
@WebServlet("/FetchUserData")
public class FetchUserData extends HttpServlet {
    private static final long serialVersionUID = 1L;


    public FetchUserData() {
        super();
        // TODO Auto-generated constructor stub
    }


    protected void doGet(final HttpServletRequest request, final HttpServletResponse response)
        throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }


    protected void doPost(final HttpServletRequest request, final HttpServletResponse response)
        throws ServletException, IOException {

 

        ArrayList<String> allCategories = new ArrayList<String>();
        ArrayList<String> queryRequestValues = new ArrayList<>();

        GenericQuery genericQuery = new GenericQuery();

        Object cateogories = genericQuery.selectAll("category");
        ResultSet cateogoriesResultSet = (ResultSet) cateogories;

        try {
			while (cateogoriesResultSet.next()) {
			    try {
					allCategories.add(cateogoriesResultSet.getString("category_name"));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

        String userid = request.getParameter("id");
        queryRequestValues.add("id");

        HashMap<String, Object> queryConditionParams = new HashMap<>();

        queryConditionParams.put("id", userid);
        Object name = genericQuery.select( "user",queryRequestValues, queryConditionParams);

        @SuppressWarnings("resource")
		ResultSet usernameResultSet = (ResultSet) name;
        String username=null;
        try {
			while (usernameResultSet.next()) {
			    username = cateogoriesResultSet.getString("name");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        request.setAttribute("category_list", allCategories);
        request.setAttribute("username", username);

        RequestDispatcher rd = request.getRequestDispatcher("addAsset.jsp");
        rd.forward(request, response);


    }

}

              
              
              
