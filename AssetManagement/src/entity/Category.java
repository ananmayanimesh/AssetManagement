package entity;

public class Category {


    private static long categoryId = 22220000;
    private long id;
    private String categoryName;
    private int lendingPeriod;
    private int daysBanned;
    private float lateFeePerDay;

    private static long generateCategoryId() {
        Category.categoryId++;
        return Category.categoryId;
    }


    public Category(final String name, final int lendingPeriod, final int daysBanned, final float lateFeePerDay) {
        super();
        this.categoryName = name;
        this.lendingPeriod = lendingPeriod;
        this.daysBanned = daysBanned;
        this.lateFeePerDay = lateFeePerDay;
        this.id = generateCategoryId();
    }


    public String getName() {
        return this.categoryName;
    }


    public void setName(final String name) {
        this.categoryName = name;
    }


    public int getLendingPeriod() {
        return this.lendingPeriod;
    }


    public void setLendingPeriod(final int lendingPeriod) {
        this.lendingPeriod = lendingPeriod;
    }


    public int getDaysBanned() {
        return this.daysBanned;
    }


    public void setDaysBanned(final int daysBanned) {
        this.daysBanned = daysBanned;
    }


    public float getLateFeePerDay() {
        return this.lateFeePerDay;
    }


    public void setLateFeePerDay(final float lateFeePerDay) {
        this.lateFeePerDay = lateFeePerDay;
    }


    public long getId() {
        return this.id;
    }

}