package appmodels;

import java.io.Serializable;

/**
 * Created by Shyshkin Vladyslav on 23.05.2016.
 */
public class _GraphReport implements Serializable{
    private String name;
    private int amount;

    public _GraphReport(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
