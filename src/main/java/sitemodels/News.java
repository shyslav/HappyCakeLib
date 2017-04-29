package sitemodels;

import com.shyslav.mysql.annotations.DBField;
import com.shyslav.mysql.annotations.DBModel;
import com.shyslav.mysql.interfaces.DBEntity;
import com.shyslav.utils.LazyDate;

import java.util.Date;

/**
 * @author Shyshkin Vladyslav on 28.03.2016.
 */
@DBModel(tableName = "news")
public class News implements DBEntity {
    @DBField(fieldName = "id", isAutoIncrement = true)
    private int id;
    @DBField(fieldName = "id_author")
    private int authorID;
    @DBField(fieldName = "name")
    private String name;
    @DBField(fieldName = "text")
    private String text;
    @DBField(fieldName = "date")
    private int date;
    @DBField(fieldName = "tags")
    private String tags;
    @DBField(fieldName = "views")
    private int view;
    @DBField(fieldName = "image_link")
    private String imageLink;

    public News() {
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
