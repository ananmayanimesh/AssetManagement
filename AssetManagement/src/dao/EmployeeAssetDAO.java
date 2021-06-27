package dao;

/*
 * COPYRIGHT. HSBC HOLDINGS PLC 2019. ALL RIGHTS RESERVED.
 *
 * This software is only to be used for the purpose for which it has been
 * provided. No part of it is to be reproduced, disassembled, transmitted,
 * stored in a retrieval system nor translated in any human or computer
 * language in any way or for any other purposes whatsoever without the prior
 * written consent of HSBC Holdings plc.
 */


import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import db.DataManipulationClass;
import entity.MyProfile;


public class EmployeeAssetDAO implements MyProfile {

    public void allocateAsset(final String assetName, final String userId) {
    	
        System.out.println(assetName + userId);
        System.out.println("Allocate asset");

        Map<String, Object> employeeObject = new HashMap<>();
        employeeObject.put("category_name", assetName);

        DataManipulationClass dmc = new DataManipulationClass();
        String table_name = "category";
        dmc.select(table_name, employeeObject);


        LocalDate borrowedDate = LocalDate.now();
        LocalDate endDate = LocalDate.now();

        int amtDue = calculateDueAmount(borrowedDate, endDate);

        Map<String, Object> resultset = new HashMap<>();
        employeeObject.put("asset_id", "101");
        employeeObject.put("u_id", "45063226");
        employeeObject.put("borrowed_time", "20-09-2019");
        employeeObject.put("end_time", "30-09-2019");
        employeeObject.put("amt_due", amtDue);

        table_name = "asset_history";
        dmc.insert(table_name, resultset);


    }

    /**
     * <p>
     * <b> TODO : Insert description of the method's responsibility/role. </b>
     * </p>
     *
     * @param borrowedDate
     * @param endDate
     * @return
     */
    private int calculateDueAmount(final LocalDate borrowedDate, final LocalDate endDate) {
        // TODO Auto-generated method stub
        return 0;
    }

    public void returnAsset() {
        System.out.println("Return asset");
    }

    public void getMyProfile() {
        System.out.println("Name: Sachin \n Asset Allocated: Laptop \nReturn Date: 30-Aug-2019");

    }


}

