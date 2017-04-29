package sitemodels;

import com.shyslav.mysql.annotations.DBField;
import com.shyslav.mysql.annotations.DBModel;
import com.shyslav.mysql.interfaces.DBEntity;

/**
 * @author Shyshkin Vladyslav on 22.04.16.
 */
@DBModel(tableName = "dish")
public class Dish implements DBEntity {
    @DBField(fieldName = "id", isAutoIncrement = true)
    private int id;
    @DBField(fieldName = "id_category")
    private int categoryId;
    @DBField(fieldName = "name")
    private String name;
    @DBField(fieldName = "description")
    private String description;
    @DBField(fieldName = "amount")
    private int amount;
    @DBField(fieldName = "price")
    private double price;
    @DBField(fieldName = "image")
    private byte[] image;
    @DBField(fieldName = "readyOrNot")
    private String readyORnot;

    private int discount;

    public Dish() {
    }

    public Dish(int id, int categoryId, String name, String description, int amount, double price, byte[] image, String readyORnot) {
        this.id = id;
        this.categoryId = categoryId;
        this.name = name;
        this.description = description;
        this.amount = amount;
        this.price = price;
        this.image = image;
        this.readyORnot = readyORnot;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getReadyORnot() {
        return readyORnot;
    }

    public void setReadyORnot(String readyORnot) {
        this.readyORnot = readyORnot;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}
