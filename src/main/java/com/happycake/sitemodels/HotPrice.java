package com.happycake.sitemodels;

import com.happycake.editablemodel.EditableField;
import com.happycake.editablemodel.EditableModel;
import com.shyslav.mysql.annotations.DBField;
import com.shyslav.mysql.annotations.DBModel;
import com.shyslav.mysql.interfaces.DBEntity;
import com.shyslav.utils.LazyDate;

import java.util.Date;

/**
 * @author Shyshkin Vladyslav on 22.04.16.
 */
@EditableModel(name = "Скидки")
@DBModel(tableName = "hotprice")
public class HotPrice implements DBEntity {
    @DBField(fieldName = "id", isAutoIncrement = true)
    private int id;

    @EditableField(name = "ID блюда", type = EditableField.EditableFields.SELECTFIELD, pattern = "[\\d]{1,11}", pathToSelectClass = "com.happycake.sitemodels.DishesList")
    @DBField(fieldName = "id_dish")
    private int dishId;

    @EditableField(name = "Процент скидки", type = EditableField.EditableFields.NUMBERFIELD, pattern = "[\\d]{1,11}")
    @DBField(fieldName = "percent")
    private int percent;

    @EditableField(name = "Описание", type = EditableField.EditableFields.TEXTAREA, pattern = "[\\d\\w\\t\\n\\r\\f\\v\\W*.]{3,300}")
    @DBField(fieldName = "description")
    private String description;

    @EditableField(name = "Дата начала действия скидки", type = EditableField.EditableFields.CALENDAR, pattern = "[\\d]{1,11}")
    @DBField(fieldName = "dateStart")
    private int dateStart;

    @EditableField(name = "Дата конца действия скидки", type = EditableField.EditableFields.CALENDAR, pattern = "[\\d]{1,11}")
    @DBField(fieldName = "dateEnd")
    private int dateEnd;

    public HotPrice() {
    }

    public HotPrice(int id, int dishId, int percent, String description, int dateStart, int dateEnd) {
        this.id = id;
        this.dishId = dishId;
        this.percent = percent;
        this.description = description;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateStart() {
        return LazyDate.getDateFromUnixTimeStaimp(dateStart);
    }

    public void setDateStart(int dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return LazyDate.getDateFromUnixTimeStaimp(dateEnd);
    }

    public void setDateEnd(int dateEnd) {
        this.dateEnd = dateEnd;
    }
}
