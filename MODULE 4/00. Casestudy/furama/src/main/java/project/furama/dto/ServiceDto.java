package project.furama.dto;

import project.furama.model.RentType;
import project.furama.model.ServiceType;

import javax.validation.constraints.*;

public class ServiceDto {
    private Integer id;
    @NotEmpty(message = "Input code please!")
    @Pattern(regexp="^DV-[\\d]{4}$",message = "Code is not format DV-0000")
    private String code;
    private String name;
    @Min(value = 1,message = "Area is empty or <1")
    private int area;
    @NotNull(message ="Cost is empty" )
    @DecimalMin(value = "0.00",message = "Cost is not decimal!")
    private Double cost;
    @Min(value = 1,message ="number people is empty or <1" )
    private int maxPeople;
    private String standard;
    private String decription;
    @NotNull(message = "Area pool is empty")
    @DecimalMin(value = "0.00",message = "Area pool is not decimal!")
    private Double areaPool;
    @Min(value = 1,message ="number floor is empty or <1" )
    private int numberFloor;
    private ServiceType serviceType;
    private RentType rentType;

    public ServiceDto() {
    }

    public ServiceDto(String code,String name, int area, Double cost, int maxPeople, String standard, String decription, Double areaPool, int numberFloor, ServiceType serviceType, RentType rentType) {
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

    public ServiceDto(Integer id,String code, String name, int area, Double cost, int maxPeople, String standard, String decription, Double areaPool, int numberFloor, ServiceType serviceType, RentType rentType) {
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

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
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

    public Double getAreaPool() {
        return areaPool;
    }

    public void setAreaPool(Double areaPool) {
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
}

