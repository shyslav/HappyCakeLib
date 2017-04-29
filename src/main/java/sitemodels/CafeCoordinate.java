package sitemodels;

import com.shyslav.mysql.annotations.DBField;
import com.shyslav.mysql.annotations.DBModel;
import com.shyslav.mysql.interfaces.DBEntity;

/**
 * @author Shyshkin Vladyslav on 22.04.16.
 */
@DBModel(tableName = "cafecoordinate")
public class CafeCoordinate implements DBEntity {
    @DBField(fieldName = "id", isAutoIncrement = true)
    private int id;
    @DBField(fieldName = "address")
    private String address;
    @DBField(fieldName = "mobile_phone")
    private String mobilePhone;
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
