package com.happycake.sitemodels;

import com.happycake.editablemodel.EditableField;
import com.happycake.editablemodel.EditableModel;
import com.shyslav.mysql.annotations.DBField;
import com.shyslav.mysql.annotations.DBModel;
import com.shyslav.mysql.interfaces.DBEntity;

/**
 * @author Shyshkin Vladyslav on 22.04.16.
 */
@EditableModel(name = "Контакты заведения")
@DBModel(tableName = "cafecoordinate")
public class CafeCoordinate implements DBEntity {
    @DBField(fieldName = "id", isAutoIncrement = true)
    private int id;

    @EditableField(name = "Адресс", type = EditableField.EditableFields.TEXTFIELD, pattern ="[\\d\\w\\t\\n\\r\\f\\v\\W*.]{3,50}")
    @DBField(fieldName = "address")
    private String address;

    @EditableField(name = "Номер мобильного телефона кафе", type = EditableField.EditableFields.NUMBERFIELD, pattern = "^((\\+380|0)([0-9]{9}))?$")
    @DBField(fieldName = "mobile_phone")
    private String mobilePhone;

    @EditableField(name = "Электронная почта кафе", type = EditableField.EditableFields.NUMBERFIELD, pattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")
    @DBField(fieldName = "cafe_mail")
    private String email;

    public CafeCoordinate() {
    }

    public CafeCoordinate(int id, String address, String mobilePhone, String cafeemail) {
        this.id = id;
        this.address = address;
        this.mobilePhone = mobilePhone;
        this.email = cafeemail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
