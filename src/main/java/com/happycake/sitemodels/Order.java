package com.happycake.sitemodels;

import com.happycake.editablemodel.EditableModel;
import com.shyslav.mysql.annotations.DBField;
import com.shyslav.mysql.annotations.DBModel;
import com.shyslav.mysql.interfaces.DBEntity;
import com.shyslav.utils.LazyDate;

import java.util.Date;

/**
 * @author Shyshkin Vladyslav on 22.04.16.
 */
@EditableModel(name = "Заказы")
@DBModel(tableName = "orders")
public class Order implements DBEntity {
    @DBField(fieldName = "id", isAutoIncrement = true)
    private int id;
    @DBField(fieldName = "id_employee")
    private int employeeId;
    @DBField(fieldName = "full_price")
    private double fullPrice;
    @DBField(fieldName = "date")
    private int date;
    @DBField(fieldName = "complite")
    private boolean complite;

    private OrderDetailsList orderDetails;

    public Order() {
        this.id = 0;
        this.complite = false;
        this.date = LazyDate.getUnixDate();
        this.orderDetails = new OrderDetailsList();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public double getFullPrice() {
        return fullPrice;
    }

    public void setFullPrice(double fullPrice) {
        this.fullPrice = fullPrice;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public boolean isComplite() {
        return complite;
    }

    public void setComplite(boolean complite) {
        this.complite = complite;
    }

    public OrderDetailsList getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(OrderDetailsList orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Date getDateFromUnix() {
        return LazyDate.getDateFromUnixTimeStaimp(date);
    }

    public void calcFullPrice() {
        double fullPrice = 0;
        for (OrderDetails orderDetail : orderDetails) {
            fullPrice += orderDetail.getPrice();
        }
        this.fullPrice = fullPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", employeeId=" + employeeId +
                ", fullPrice=" + fullPrice +
                ", date=" + date +
                ", complite=" + complite +
                '}';
    }
}
