package service.model.bean;

public class Service {
    private int id;
    private String name;
    private int area;
    private double cost;
    private int maxPeople;
    private String rentType;
    private String serviceType;
    private String standard;
    private String decription;
    private double poorArea;
    private int numberFloor;

    public Service(int id, String name, int area, double cost, int maxPeople, String rentType, String serviceType, String standard, String decription, double poorArea, int numberFloor) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.rentType = rentType;
        this.serviceType = serviceType;
        this.standard = standard;
        this.decription = decription;
        this.poorArea = poorArea;
        this.numberFloor = numberFloor;
    }

    public Service(String name, int area, double cost, int maxPeople, String rentType, String serviceType, String standard, String decription, double poorArea, int numberFloor) {
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.rentType = rentType;
        this.serviceType = serviceType;
        this.standard = standard;
        this.decription = decription;
        this.poorArea = poorArea;
        this.numberFloor = numberFloor;
    }

    public Service(int id, String name, double cost, int maxPeople, String rentType, String serviceType) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.rentType = rentType;
        this.serviceType = serviceType;
    }

    public Service() {
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

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getRentType() {
        return rentType;
    }

    public void setRentType(String rentType) {
        this.rentType = rentType;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public double getPoorArea() {
        return poorArea;
    }

    public void setPoorArea(double poorArea) {
        this.poorArea = poorArea;
    }

    public int getNumberFloor() {
        return numberFloor;
    }

    public void setNumberFloor(int numberFloor) {
        this.numberFloor = numberFloor;
    }

    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", area=" + area +
                ", cost=" + cost +
                ", maxPeople=" + maxPeople +
                ", rentType='" + rentType + '\'' +
                ", serviceType='" + serviceType + '\'' +
                ", standard='" + standard + '\'' +
                ", decription='" + decription + '\'' +
                ", poorArea=" + poorArea +
                ", numberFloor=" + numberFloor +
                '}';
    }
}
