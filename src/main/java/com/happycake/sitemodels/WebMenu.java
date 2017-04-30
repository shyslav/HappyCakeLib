package com.happycake.sitemodels;

import com.shyslav.mysql.annotations.DBField;
import com.shyslav.mysql.annotations.DBModel;
import com.shyslav.mysql.interfaces.DBEntity;

/**
 * @author Shyshkin Vladyslav on 22.04.16.
 */
@DBModel(tableName = "webmenu")
public class WebMenu implements DBEntity{
    @DBField(fieldName = "id", isAutoIncrement = true)
    private int id;
    @DBField(fieldName = "name")
    private String name;
    @DBField(fieldName = "link")
    private String link;
    @DBField(fieldName = "menusort")
    private int menuSort;

    public WebMenu() {
    }

    public WebMenu(int id, String name, String link, int menuSort) {
        this.id = id;
        this.name = name;
        this.link = link;
        this.menuSort = menuSort;
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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getMenuSort() {
        return menuSort;
    }

    public void setMenuSort(int menuSort) {
        this.menuSort = menuSort;
    }

    @Override
    public String toString() {
        return "WebMenu{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", link='" + link + '\'' +
                ", menuSort=" + menuSort +
                '}';
    }
}
