package Models;

public abstract class Customer {
    private String codeCustomer;
    private String fullNameCustomer;

    public Customer() {
    }

    public Customer(String codeCustomer, String fullNameCustomer) {
        this.codeCustomer = codeCustomer;
        this.fullNameCustomer = fullNameCustomer;
    }

    public String getCodeCustomer() {
        return codeCustomer;
    }

    public void setCodeCustomer(String codeCustomer) {
        this.codeCustomer = codeCustomer;
    }

    public String getFullNameCustomer() {
        return fullNameCustomer;
    }

    public void setFullNameCustomer(String fullNameCustomer) {
        this.fullNameCustomer = fullNameCustomer;
    }

    @Override
    public String toString() {
        return codeCustomer + "," + fullNameCustomer + ",";
    }
}
