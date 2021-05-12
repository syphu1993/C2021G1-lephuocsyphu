package Models;

public class VietNamCustomer extends Customer {
    private String typeOfCustomer;
    private double consumeRate;

    public VietNamCustomer() {
    }

    public VietNamCustomer(String codeCustomer, String fullNameCustomer, String typeOfCustomer, double consumeRate) {
        super(codeCustomer, fullNameCustomer);
        this.typeOfCustomer = typeOfCustomer;
        this.consumeRate = consumeRate;
    }

    public String getTypeOfCustomer() {
        return typeOfCustomer;
    }

    public void setTypeOfCustomer(String typeOfCustomer) {
        this.typeOfCustomer = typeOfCustomer;
    }

    public double getConsumeRate() {
        return consumeRate;
    }

    public void setConsumeRate(double consumeRate) {
        this.consumeRate = consumeRate;
    }

    @Override
    public String toString() {
        return super.toString() + typeOfCustomer + "," + consumeRate;
    }
}
