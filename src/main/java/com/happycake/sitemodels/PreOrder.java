package com.happycake.sitemodels;

import com.happycake.editablemodel.EditableField;
import com.happycake.editablemodel.EditableModel;
import com.shyslav.mysql.annotations.DBField;
import com.shyslav.mysql.annotations.DBModel;
import com.shyslav.mysql.interfaces.DBEntity;

/**
 * @author Shyshkin Vladyslav on 06.05.2016.
 */
@EditableModel(name = "Предзаказы")
@DBModel(tableName = "preorder")
public class PreOrder implements DBEntity {
    @DBField(fieldName = "id", isAutoIncrement = true)
    private int id;

    @EditableField(name = "ID блюда", type = EditableField.EditableFields.SELECTFIELD, pattern = "\\d{1,10}", pathToSelectClass = "com.happycake.sitemodels.DishesList")
    @DBField(fieldName = "id_dish")
    private int dishID;

    @EditableField(name = "ID брони", type = EditableField.EditableFields.SELECTFIELD, pattern = "\\d{1,10}", pathToSelectClass = "com.happycake.sitemodels.ReservationList")
    @DBField(fieldName = "id_reservation")
    private int reservationID;

    @EditableField(name = "Количество", type = EditableField.EditableFields.NUMBERFIELD, pattern = "\\d{1,20}")
    @DBField(fieldName = "amount")
    private int amount;

    @EditableField(name = "Цена", type = EditableField.EditableFields.NUMBERFIELD, pattern = "\\d{1,20}")
    @DBField(fieldName = "price")
    private double price;

    private String dishName;

    public PreOrder() {
    }

    public PreOrder(int dishID, String dishName, int amount, double price) {
        this.dishID = dishID;
        this.dishName = dishName;
        this.amount = amount;
        this.price = price;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public int getDishID() {
        return dishID;
    }

    public void setDishID(int dishID) {
        this.dishID = dishID;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getReservationID() {
        return reservationID;
    }

    public void setReservationID(int reservationID) {
        this.reservationID = reservationID;
    }

    @Override
    public String toString() {
        return "PreOrder{" +
                "id=" + id +
                ", dishID=" + dishID +
                ", reservationID=" + reservationID +
                ", amount=" + amount +
                ", price=" + price +
                ", dishName='" + dishName + '\'' +
                '}';
    }
}
