package servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryManipulation;
import db.DataManipulationClass;
import entity.AdminAssetService;
import entity.Asset;
import entity.Category;


@WebServlet("/AssetServlet")
public class AssetServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    public AssetServlet() {
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


        String asset_name = request.getParameter("asset_name");
        String category_name = request.getParameter("asset_category");
        CategoryManipulation categoryManipulation = new CategoryManipulation();

        boolean existing_category = categoryManipulation.checkCategory(category_name); // check_for_presence_of_category
        AdminAssetService adminAssetService = new AdminAssetService();
        int temp_availability = 1;
        if (existing_category) {

            long category_id = categoryManipulation.getCategoryId(category_name);
            adminAssetService.addAsset(new Asset(category_id, asset_name, temp_availability));

        } else {
            int lendingPeriod = Integer.parseInt(request.getParameter("lendingPeriod"));
            float lateFeePerDay = Float.parseFloat(request.getParameter("lateFeePerDay"));
            int daysBanned = Integer.parseInt(request.getParameter("daysBanned"));
            Category category = new Category(category_name, lendingPeriod, daysBanned, lateFeePerDay);

            Map<String, Object> category_entities = new HashMap<>();
            category_entities.put("category_id", category.getId());
            category_entities.put("category_name", category_name);
            category_entities.put("lendingPeriod", lendingPeriod);
            category_entities.put("lateFeePerDay", lateFeePerDay);
            category_entities.put("daysBanned", daysBanned);

            DataManipulationClass dmc = new DataManipulationClass();
            dmc.insert("category", category_entities);
            adminAssetService.addAsset(new Asset(category.getId(), asset_name, temp_availability));

        }


        // doGet(request, response);
    }

}