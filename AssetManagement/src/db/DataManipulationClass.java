package db;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * <b> TODO : Insert description of the class's responsibility/role. </b>
 * </p>
 */
public class DataManipulationClass {


    public boolean insert(final String table_name, final Map<String, Object> employeeObject) {
        System.out.println(employeeObject + table_name);
        return true;
    }

    public Map<String, Object> select(final String assetName, final Map<String, Object> employeeObject) {
        System.out.println(assetName + employeeObject);

        Map<String, Object> category = new HashMap<>();

        return category;
    }


    private int calculateDueAmount(final LocalDate borrowedDate, final LocalDate endDate) {
        System.out.println("calculateAmount Due");
        return 200;
    }
}

