package appmodels;

/**
 * @author Shyshkin Vladyslav on 23.05.2016.
 */
public class GraphReport {
    private String name;
    private int amount;

    public GraphReport(String name, int amount) {
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
