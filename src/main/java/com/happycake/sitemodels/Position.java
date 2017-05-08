package com.happycake.sitemodels;

import com.happycake.editablemodel.EditableField;
import com.happycake.editablemodel.EditableModel;
import com.shyslav.mysql.annotations.DBField;
import com.shyslav.mysql.annotations.DBModel;
import com.shyslav.mysql.interfaces.DBEntity;

/**
 * @author Shyshkin Vladyslav on 16.05.2016.
 */
@EditableModel(name = "Должность")
@DBModel(tableName = "positions")
public class Position implements DBEntity {
    @DBField(fieldName = "id", isAutoIncrement = true)
    private int id;

    @EditableField(name = "Название должности", type = EditableField.EditableFields.TEXTFIELD, pattern = "^[a-zA-Z]{1,15}")
    @DBField(fieldName = "name")
    private String name;

    @EditableField(name = "Заработная плата", type = EditableField.EditableFields.NUMBERFIELD, pattern = "\\d{1,20}")
    @DBField(fieldName = "salary")
    private double salary;

    public Position() {
    }

    public Position(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Positions{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
