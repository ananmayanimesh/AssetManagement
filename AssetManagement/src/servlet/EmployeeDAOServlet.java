package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeAssetDAO;






@WebServlet("/EmployeeDAOServlet")
public class EmployeeDAOServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    public EmployeeDAOServlet() {
        super();
    }


    protected void doGet(final HttpServletRequest request, final HttpServletResponse response)
        throws ServletException, IOException {

        System.out.println(request.getParameter("assetName"));
        System.out.println(request.getParameter("userId"));

        EmployeeAssetDAO empassetdao = new EmployeeAssetDAO();
        empassetdao.allocateAsset(request.getParameter("assetName"), request.getParameter("userId"));


        response.getWriter().append("Served at: ").append(request.getContextPath());
    }


    protected void doPost(final HttpServletRequest request, final HttpServletResponse response)
        throws ServletException, IOException {
        doGet(request, response);
    }

}

