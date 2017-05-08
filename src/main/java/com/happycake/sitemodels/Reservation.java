package com.happycake.sitemodels;

import com.happycake.editablemodel.EditableField;
import com.happycake.editablemodel.EditableModel;
import com.shyslav.mysql.annotations.DBField;
import com.shyslav.mysql.annotations.DBModel;
import com.shyslav.mysql.interfaces.DBEntity;
import com.shyslav.utils.LazyDate;

/**
 * @author Shyshkin Vladyslav on 22.04.16.
 */
@EditableModel(name = "Бронирование столика")
@DBModel(tableName = "reservation")
public class Reservation implements DBEntity {
    @DBField(fieldName = "id", isAutoIncrement = true)
    private int id;

    @EditableField(name = "ID заведения", type = EditableField.EditableFields.SELECTFIELD, pattern = "\\d{1,10}", pathToSelectClass = "com.happycake.sitemodels.CafeCoordinateList")
    @DBField(fieldName = "id_cafe")
    private int cafeId;

    @EditableField(name = "Имя клиента", type = EditableField.EditableFields.TEXTFIELD, pattern = "^[a-zA-Z]{1,15}")
    @DBField(fieldName = "client_name")
    private String clientName;

    @EditableField(name = "Номер мобильного телефона", type = EditableField.EditableFields.NUMBERFIELD, pattern = "^((\\\\+380|0)([0-9]{9}))?$")
    @DBField(fieldName = "client_phone")
    private String clientPhone;

    @EditableField(name = "Дата", type = EditableField.EditableFields.CALENDAR, pattern = "\\d{1,20}")
    @DBField(fieldName = "date")
    private int date;
    @DBField(fieldName = "confirm")
    private boolean confirm;

    @EditableField(name = "Количество людей", type = EditableField.EditableFields.NUMBERFIELD, pattern = "\\d{1,20}")
    @DBField(fieldName = "amount_peoples")
    private int amountPeople;

    @EditableField(name = "Описание", type = EditableField.EditableFields.TEXTAREA, pattern = "^[a-zA-Z]{1,500}")
    @DBField(fieldName = "description")
    private String description;

    public Reservation() {
        this.date = LazyDate.getUnixDate();
        this.confirm = false;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCafeId() {
        return cafeId;
    }

    public void setCafeId(int cafeId) {
        this.cafeId = cafeId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientPhone() {
        return clientPhone;
    }

    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }

    public boolean isConfirm() {
        return confirm;
    }

    public void setConfirm(boolean confirm) {
        this.confirm = confirm;
    }

    public int getAmountPeople() {
        return amountPeople;
    }

    public void setAmountPeople(int amountPeople) {
        this.amountPeople = amountPeople;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", cafeId=" + cafeId +
                ", clientName='" + clientName + '\'' +
                ", clientPhone='" + clientPhone + '\'' +
                ", date=" + date +
                ", confirm=" + confirm +
                ", amountPeople=" + amountPeople +
                ", description='" + description + '\'' +
                '}';
    }
}
