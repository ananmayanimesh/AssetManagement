package dao;

import java.util.HashMap;
import java.util.Map;

import db.DataManipulationClass;
import entity.Asset;

public class AdminAssetDAO {


    public boolean addAsset(final Asset asset) {
    	boolean result=false;
        Map<String, Object> asset_entities = new HashMap<>();
        asset_entities.put("asset_id", asset.getId());
        asset_entities.put("asset_name", asset.getName());
        asset_entities.put("category_id", asset.getCategoryId());
        asset_entities.put("isAvailable", (Boolean) true);
        asset_entities.put("date_added", asset.getDateOfAddition());

        DataManipulationClass dmc = new DataManipulationClass();
        String table_name = "asset";
        result=dmc.insert(table_name, asset_entities);
        return result;
    }

    public String overdueMessage() {
        return "Asset return kar jaldi , you have exceeded the time limit";
    }

}
   