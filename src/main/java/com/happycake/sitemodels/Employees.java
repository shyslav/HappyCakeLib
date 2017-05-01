package com.happycake.sitemodels;

import com.shyslav.mysql.annotations.DBField;
import com.shyslav.mysql.annotations.DBModel;
import com.shyslav.mysql.interfaces.DBEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Shyshkin Vladyslav on 28.03.2016.
 */
@DBModel(tableName = "employees")
public class Employees implements DBEntity {
    @DBField(fieldName = "id", isAutoIncrement = true)
    private int id;
    @DBField(fieldName = "id_position")
    private int positionID;
    @DBField(fieldName = "id_cafe")
    private int cafeID;
    @DBField(fieldName = "name")
    private String name;
    @DBField(fieldName = "lastname")
    private String lastname;
    @DBField(fieldName = "address")
    private String address;
    @DBField(fieldName = "birthday")
    private int birthday;
    @DBField(fieldName = "login")
    private String login;
    @DBField(fieldName = "password")
    private String password;

    public Employees() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPositionID() {
        return positionID;
    }

    public void setPositionID(int positionID) {
        this.positionID = positionID;
    }

    public int getCafeID() {
        return cafeID;
    }

    public void setCafeID(int cafeID) {
        this.cafeID = cafeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getBirthday() {
        return birthday;
    }

    public void setBirthday(int birthday) {
        this.birthday = birthday;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "id=" + id +
                ", positionID=" + positionID +
                ", cafeID=" + cafeID +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", address='" + address + '\'' +
                ", birthday=" + birthday +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
