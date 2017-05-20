package com.happycake.sitemodels;

import com.happycake.editablemodel.EditableField;
import com.happycake.editablemodel.EditableModel;
import com.shyslav.mysql.annotations.DBField;
import com.shyslav.mysql.annotations.DBModel;
import com.shyslav.mysql.interfaces.DBEntity;
import com.shyslav.utils.LazyDate;

import java.util.Date;

/**
 * @author Shyshkin Vladyslav on 28.03.2016.
 */
@EditableModel(name = "Сотрудники")
@DBModel(tableName = "employees")
public class Employees implements DBEntity {
    @DBField(fieldName = "id", isAutoIncrement = true)
    private int id;

    @EditableField(name = "Должность", type = EditableField.EditableFields.TEXTFIELD)
    @DBField(fieldName = "position")
    private String position;

    @EditableField(name = "ID заведения", type = EditableField.EditableFields.SELECTFIELD, pattern = "\\d{1,10}", pathToSelectClass = "com.happycake.sitemodels.CafeCoordinateList")
    @DBField(fieldName = "id_cafe")
    private int cafeID;

    @EditableField(name = "Имя сотрудника", type = EditableField.EditableFields.TEXTFIELD, pattern = "^[a-zA-Z]{1,15}")
    @DBField(fieldName = "name")
    private String name;

    @EditableField(name = "Фамилия сотрудника", type = EditableField.EditableFields.TEXTFIELD, pattern = "^[a-zA-Z]{1,15}")
    @DBField(fieldName = "lastname")
    private String lastname;

    @EditableField(name = "Адресс сотрудника", type = EditableField.EditableFields.TEXTFIELD, pattern = "^[a-zA-Z]{1,15}")
    @DBField(fieldName = "address")
    private String address;

    @EditableField(name = "Дата дня рождения сотрудника", type = EditableField.EditableFields.CALENDAR, pattern = "\\d{1,20}")
    @DBField(fieldName = "birthday")
    private int birthday;

    @EditableField(name = "Логин для входа в систему", type = EditableField.EditableFields.TEXTFIELD, pattern = "^[a-zA-Z]{1,15}")
    @DBField(fieldName = "login")
    private String login;

    @EditableField(name = "Пароль для входа в систему", type = EditableField.EditableFields.TEXTFIELD, pattern = "^[a-zA-Z]{1,15}")
    @DBField(fieldName = "password")
    private String password;

    public Employees() {
        this.birthday = LazyDate.getUnixDate();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public HappyCakeRoles getPosition() {
        return HappyCakeRoles.valueOf(position);
    }

    public void setPosition(HappyCakeRoles position) {
        this.position = position.toString();
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

    public Date getDateFromUnix() {
        return LazyDate.getDateFromUnixTimeStaimp(birthday);
    }

    @Override
    public String toString() {
        return "Employees{" +
                "id=" + id +
                ", position='" + position + '\'' +
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
