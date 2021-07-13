package project.furama.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "services")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String code;
    private String name;
    private int area;
    private double cost;
    private int maxPeople;
    private String standard;
    private String decription;
    private double areaPool;
    private int numberFloor;
    @ManyToOne
    @JoinColumn(name = "type_id",referencedColumnName ="typeId" )
    private ServiceType serviceType;

    @ManyToOne
    @JoinColumn(name = "rent_id",referencedColumnName ="rentId" )
    private RentType rentType;

    @OneToMany(mappedBy = "service")
    private List<Contract> contractList;

    public Service() {
    }

    public Service(String code,String name, int area, double cost, int maxPeople, String standard, String decription, double areaPool, int numberFloor, ServiceType serviceType, RentType rentType) {
        this.code= code;
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.standard = standard;
        this.decription = decription;
        this.areaPool = areaPool;
        this.numberFloor = numberFloor;
        this.serviceType = serviceType;
        this.rentType = rentType;
    }

    public Service(Integer id,String code, String name, int area, double cost, int maxPeople, String standard, String decription, double areaPool, int numberFloor, ServiceType serviceType, RentType rentType) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.standard = standard;
        this.decription = decription;
        this.areaPool = areaPool;
        this.numberFloor = numberFloor;
        this.serviceType = serviceType;
        this.rentType = rentType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public double getAreaPool() {
        return areaPool;
    }

    public void setAreaPool(double areaPool) {
        this.areaPool = areaPool;
    }

    public int getNumberFloor() {
        return numberFloor;
    }

    public void setNumberFloor(int numberFloor) {
        this.numberFloor = numberFloor;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public List<Contract> getContractList() {
        return contractList;
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
    }
}
