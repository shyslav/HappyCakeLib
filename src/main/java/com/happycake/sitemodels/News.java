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
@EditableModel(name = "Новости")
@DBModel(tableName = "news")
public class News implements DBEntity {
    @DBField(fieldName = "id", isAutoIncrement = true)
    private int id;

    @EditableField(name = "Автор", type = EditableField.EditableFields.SELECTFIELD, pattern = "^[1-9]\\d*$", pathToSelectClass = "com.happycake.sitemodels.EmployeesList")
    @DBField(fieldName = "id_author")
    private int authorID;

    @EditableField(name = "Заглавие", type = EditableField.EditableFields.TEXTFIELD, pattern = "[\\d\\w\\t\\n\\r\\f\\v\\W*.]{3,50}")
    @DBField(fieldName = "name")
    private String name;

    @EditableField(name = "Текст новости", type = EditableField.EditableFields.TEXTAREA, pattern = "[\\d\\w\\t\\n\\r\\f\\v\\W*.]{3,16777215}")
    @DBField(fieldName = "text")
    private String text;

    @EditableField(name = "Дата", type = EditableField.EditableFields.CALENDAR, pattern = "[\\d]{1,11}")
    @DBField(fieldName = "date")
    private int date;

    @EditableField(name = "Теги", type = EditableField.EditableFields.TEXTFIELD, pattern = "[\\d\\w\\t\\n\\r\\f\\v\\W*.]{3,50}")
    @DBField(fieldName = "tags")
    private String tags;

    @DBField(fieldName = "views")
    private int view;

    @DBField(fieldName = "image_link")
    private String imageLink;

    public News() {
        this.id = 0;
        this.date = LazyDate.getUnixDate();
        this.view = 0;
        this.imageLink = "";
    }

    public void increaseViews() {
        view++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAuthorID() {
        return authorID;
    }

    public void setAuthorID(int authorID) {
        this.authorID = authorID;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return LazyDate.getDateFromUnixTimeStaimp(date);
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getTags() {
        return tags;
    }

    public void setTegs(String tags) {
        this.tags = tags;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }
}
