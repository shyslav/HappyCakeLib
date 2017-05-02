package com.happycake.sitemodels;

import com.shyslav.mysql.annotations.DBField;
import com.shyslav.mysql.annotations.DBModel;
import com.shyslav.mysql.interfaces.DBEntity;
import com.shyslav.utils.LazyDate;

/**
 * @author Shyshkin Vladyslav on 05.05.2016.
 */
@DBModel(tableName = "reports")
public class Reports implements DBEntity {
    @DBField(fieldName = "id", isAutoIncrement = true)
    private int id;
    @DBField(fieldName = "author")
    private String author;
    @DBField(fieldName = "text")
    private String text;
    @DBField(fieldName = "date")
    private int date;
    @DBField(fieldName = "mail")
    private String mail;
    @DBField(fieldName = "phone")
    private String phone;
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
