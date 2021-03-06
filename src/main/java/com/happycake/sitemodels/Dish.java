package com.happycake.sitemodels;

import com.happycake.editablemodel.EditableField;
import com.happycake.editablemodel.EditableModel;
import com.shyslav.mysql.annotations.DBField;
import com.shyslav.mysql.annotations.DBModel;
import com.shyslav.mysql.interfaces.DBEntity;

/**
 * @author Shyshkin Vladyslav on 22.04.16.
 */
@EditableModel(name = "Блюда")
@DBModel(tableName = "dish")
public class Dish implements DBEntity {
    @DBField(fieldName = "id", isAutoIncrement = true)
    private int id;

    @EditableField(name = "ID категории", type = EditableField.EditableFields.SELECTFIELD, pattern = "^[1-9]\\d*$", pathToSelectClass = "com.happycake.sitemodels.CategoriesList")
    @DBField(fieldName = "id_category")
    private int categoryId;

    @EditableField(name = "Название блюда", type = EditableField.EditableFields.TEXTFIELD, pattern = "[\\d\\w\\t\\n\\r\\f\\v\\W*.]{3,50}")
    @DBField(fieldName = "name")
    private String name;

    @EditableField(name = "Описание", type = EditableField.EditableFields.TEXTAREA, pattern = "[\\d\\w\\t\\n\\r\\f\\v\\W*.]{3,300}")
    @DBField(fieldName = "description")
    private String description;

    @EditableField(name = "Вес", type = EditableField.EditableFields.NUMBERFIELD, pattern = "^[1-9]\\d*$")
    @DBField(fieldName = "amount")
    private int amount;

    @EditableField(name = "Цена за единицу", type = EditableField.EditableFields.NUMBERFIELD, pattern = "^[0-9]\\d*\\.?[1-9]\\d*$")
    @DBField(fieldName = "price")
    private double price;

    @EditableField(name = "Картинка", type = EditableField.EditableFields.IMAGEFIELD)
    @DBField(fieldName = "image")
    private byte[] image;

    @EditableField(name = "Необходимость приготовления", type = EditableField.EditableFields.CHECKBOX)
    @DBField(fieldName = "need_cook")
    private boolean needCook;

    private int discount;

    public Dish() {
        this.needCook = false;
    }

    public Dish(int id, int categoryId, String name, String description, int amount, double price, byte[] image, Boolean needCook) {
        this.id = id;
        this.categoryId = categoryId;
        this.name = name;
        this.description = description;
        this.amount = amount;
        this.price = price;
        this.image = image;
        this.needCook = needCook;
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

    public boolean isNeedCook() {
        return needCook;
    }

    public void setNeedCook(boolean needCook) {
        this.needCook = needCook;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}
