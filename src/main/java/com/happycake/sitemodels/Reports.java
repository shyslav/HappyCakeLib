package com.happycake.sitemodels;

import com.happycake.editablemodel.EditableField;
import com.happycake.editablemodel.EditableModel;
import com.shyslav.mysql.annotations.DBField;
import com.shyslav.mysql.annotations.DBModel;
import com.shyslav.mysql.interfaces.DBEntity;
import com.shyslav.utils.LazyDate;

/**
 * @author Shyshkin Vladyslav on 05.05.2016.
 */
@EditableModel(name = "Отзывы")
@DBModel(tableName = "reports")
public class Reports implements DBEntity {
    @DBField(fieldName = "id", isAutoIncrement = true)
    private int id;

    @EditableField(name = "Автор", type = EditableField.EditableFields.TEXTFIELD, pattern = "^[a-zA-Z]{1,50}")
    @DBField(fieldName = "author")
    private String author;

    @EditableField(name = "Текст новости", type = EditableField.EditableFields.TEXTAREA, pattern = "^[a-zA-Z]{1,500}")
    @DBField(fieldName = "text")
    private String text;

    @EditableField(name = "Дата", type = EditableField.EditableFields.CALENDAR, pattern = "\\d{1,20}")
    @DBField(fieldName = "date")
    private int date;

    @EditableField(name = "Электронная почта", type = EditableField.EditableFields.TEXTFIELD, pattern = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}$")
    @DBField(fieldName = "mail")
    private String mail;

    @EditableField(name = "Номер мобильного телефона", type = EditableField.EditableFields.NUMBERFIELD, pattern = "^((\\\\+380|0)([0-9]{9}))?$")
    @DBField(fieldName = "phone")
    private String phone;

    @EditableField(name = "Видим на сайте", type = EditableField.EditableFields.CHECKBOX)
    @DBField(fieldName = "vision")
    private boolean vision;

    public Reports() {
        this.date = LazyDate.getUnixDate();
        this.vision = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isVision() {
        return vision;
    }

    public void setVision(boolean vision) {
        this.vision = vision;
    }

    @Override
    public String toString() {
        return "Reports{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", text='" + text + '\'' +
                ", date=" + date +
                ", mail='" + mail + '\'' +
                ", phone='" + phone + '\'' +
                ", vision=" + vision +
                '}';
    }
}
