package appmodels.localmodels;

import appmodels._Dish;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Shyshkin Vladyslav on 23.05.2016.
 */
public class LocalServerCassir implements Serializable {
    private int id;
    private String name;
    private String description;
    private String image;
    ArrayList<_Dish> dish;


    public LocalServerCassir(int id, String name, String description, String image, ArrayList<_Dish> dish) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.dish = dish;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
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

    public ArrayList<_Dish> getDish() {
        return dish;
    }

    public void setDish(ArrayList<_Dish> dish) {
        this.dish = dish;
    }
}
