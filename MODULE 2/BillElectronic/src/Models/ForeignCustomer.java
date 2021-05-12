package Models;

public class ForeignCustomer extends Customer {
    private String nationalForeign;

    public ForeignCustomer() {
    }

    public ForeignCustomer(String codeCustomer, String fullNameCustomer, String nationalForeign) {
        super(codeCustomer, fullNameCustomer);
        this.nationalForeign = nationalForeign;
    }

    public String getNationalForeign() {
        return nationalForeign;
    }

    public void setNationalForeign(String nationalForeign) {
        this.nationalForeign = nationalForeign;
    }

    @Override
    public String toString() {
        return super.toString()+ nationalForeign;
    }
}
