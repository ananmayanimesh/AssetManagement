package entity;

import dao.AdminAssetDAO;

public class AdminAssetService {

    static AdminAssetDAO adminAssetDAO = new AdminAssetDAO();

    public boolean addAsset(final Asset asset) {
        boolean result = adminAssetDAO.addAsset(asset);
        return result;
    }

    public String overdueMessage() {
        String message = adminAssetDAO.overdueMessage();
        return message;
    }

}