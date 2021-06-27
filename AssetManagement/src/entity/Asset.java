package entity;

import java.sql.Date;
import java.time.LocalDate;

public class Asset {

    private static long assetId = 33330000;
    private long id;
    private long categoryId;
    private String assetName;
    private int isAvailable;
    private Date dateOfAddition;


    public Asset(final long categoryId, final String name, final int isAvailable) {
        super();
        this.categoryId = categoryId;
        this.assetName = name;
        this.isAvailable = 1;
        this.id = generateId();
        this.dateOfAddition = Date.valueOf(LocalDate.now());
    }


    public long getCategoryId() {
        return this.categoryId;
    }

    /**
     * @param categoryId
     *            the categoryId to set
     */
    public void setCategoryId(final long categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * @return the name
     */
    public String getName() {
        return this.assetName;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(final String name) {
        this.assetName = name;
    }

    /**
     * @return the isAvailable
     */
    public int isAvailable() {
        return this.isAvailable;
    }

    /**
     * @param isAvailable
     *            the isAvailable to set
     */
    public void setAvailable(final int isAvailable) {
        this.isAvailable = isAvailable;
    }

    /**
     * @return the id
     */
    public long getId() {
        return this.id;
    }

    /**
     * @return the dateOfAddition
     */
    public Date getDateOfAddition() {
        return this.dateOfAddition;
    }

    private long generateId() {
        Asset.assetId++;
        return Asset.assetId;
    }

}
