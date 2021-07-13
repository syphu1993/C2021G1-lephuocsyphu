package project.furama.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "attach_services")
public class AttachService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private double cost;
    private int units;
    private boolean statusAtt;
    @OneToMany(mappedBy = "contract")
    private List<DetailContract> detailContracts;

    public AttachService() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public boolean isStatusAtt() {
        return statusAtt;
    }

    public void setStatusAtt(boolean statusAtt) {
        this.statusAtt = statusAtt;
    }

    public List<DetailContract> getDetailContracts() {
        return detailContracts;
    }

    public void setDetailContracts(List<DetailContract> detailContracts) {
        this.detailContracts = detailContracts;
    }
}
