package Models;

public abstract class Services {
    protected String id;
    protected String nameServices;
    protected double areaUser;
    protected double rentFee;
    protected int numberOfPeople;
    protected String typeRent;

    public Services() {
    }

    public Services(String id, String nameServices, double areaUser, double rentFee, int numberOfPeople, String typeRent) {
        this.id = id;
        this.nameServices = nameServices;
        this.areaUser = areaUser;
        this.rentFee = rentFee;
        this.numberOfPeople = numberOfPeople;
        this.typeRent = typeRent;
    }
    public  abstract void showInfor();

    @Override
    public String toString() {
        return "Services{" +
                "id='" + id + '\'' +
                ", nameServices='" + nameServices + '\'' +
                ", areaUser=" + areaUser +
                ", rentFee=" + rentFee +
                ", numberOfPeople=" + numberOfPeople +
                ", typeRent='" + typeRent + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameServices() {
        return nameServices;
    }

    public void setNameServices(String nameServices) {
        this.nameServices = nameServices;
    }

    public double getAreaUser() {
        return areaUser;
    }

    public void setAreaUser(double areaUser) {
        this.areaUser = areaUser;
    }

    public double getRentFee() {
        return rentFee;
    }

    public void setRentFee(double rentFee) {
        this.rentFee = rentFee;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public String getTypeRent() {
        return typeRent;
    }

    public void setTypeRent(String typeRent) {
        this.typeRent = typeRent;
    }
}
