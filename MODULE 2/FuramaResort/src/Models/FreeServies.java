package Models;

public class FreeServies {
    private String freeServiesName;
    private String unit;
    private double money;

    public FreeServies(String freeServiesName, String unit, double money) {
        this.freeServiesName = freeServiesName;
        this.unit = unit;
        this.money = money;
    }

    public String getFreeServiesName() {
        return freeServiesName;
    }

    public void setFreeServiesName(String freeServiesName) {
        this.freeServiesName = freeServiesName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "FreeServies{" +
                "freeServiesName='" + freeServiesName + '\'' +
                ", unit='" + unit + '\'' +
                ", money=" + money +
                '}';
    }
}
