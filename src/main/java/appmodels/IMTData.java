package appmodels;

import com.shyslav.utils.LazyDate;

import java.util.Date;

/**
 * @author Shyshkin Vladyslav on 18.05.17.
 */
public class IMTData {
    private int date;
    private int id_dish;
    private int count;

    public IMTData(int date, int id_dish, int count) {
        this.date = date;
        this.id_dish = id_dish;
        this.count = count;
    }

    public Date getDate() {
        return LazyDate.getDateFromUnixTimeStaimp(date);
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getId_dish() {
        return id_dish;
    }

    public void setId_dish(int id_dish) {
        this.id_dish = id_dish;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
