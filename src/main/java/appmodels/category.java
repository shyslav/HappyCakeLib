package appmodels;

import java.io.Serializable;

/**
 * Created by shyshkin_vlad on 22.04.16.
 */
public class category implements Serializable{
    private int id;
    private String name;
    private String description;
    private byte[] image;

    public category(int id, String name, String description, byte[] image) {
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
