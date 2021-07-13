package project.furama.model;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "rent_type")
public class RentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rentId;
    private String name;
    private double cost;
    @OneToMany(mappedBy = "rentType")
    private List<Service> services;

    public RentType() {
    }

    public RentType(Integer rentId, String name, double cost, List<Service> services) {
        this.rentId = rentId;
        this.name = name;
        this.cost = cost;
        this.services = services;
    }

    public Integer getRentId() {
        return rentId;
    }

    public void setRentId(Integer rentId) {
        this.rentId = rentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }
}
