package com.happycake.sitemodels;

import com.happycake.editablemodel.EditableField;
import com.happycake.editablemodel.EditableModel;
import com.shyslav.mysql.annotations.DBField;
import com.shyslav.mysql.annotations.DBModel;
import com.shyslav.mysql.interfaces.DBEntity;

/**
 * @author Shyshkin Vladyslav on 22.04.16.
 */
@EditableModel(name = "Категории блюда")
@DBModel(tableName = "category")
public class Category implements DBEntity {
    @DBField(fieldName = "id", isAutoIncrement = true)
    private int id;

    @EditableField(name = "Название категории", type = EditableField.EditableFields.TEXTFIELD, pattern = "[\\d\\w\\t\\n\\r\\f\\v\\W*.]{3,50}" )
    @DBField(fieldName = "name")
    private String name;

    @EditableField(name = "Описание категории", type = EditableField.EditableFields.TEXTAREA, pattern = "[\\d\\w\\t\\n\\r\\f\\v\\W*.]{3,300}")
    @DBField(fieldName = "description")
    private String description;

    @EditableField(name = "Рисунок категории", type = EditableField.EditableFields.FILEFIELD)
    @DBField(fieldName = "image")
    private byte[] image;

    public Category() {
        this.id = 0;
    }

    public Category(int id, String name, String description, byte[] image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
