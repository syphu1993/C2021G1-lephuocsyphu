package project.furama.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "type_customer")
public class TypeCustomer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nameType;
    private int flag;

    @OneToMany(mappedBy = "typeCustomer")
    private List<Customer> customers;

    public TypeCustomer() {
    }

    public TypeCustomer(String nameType) {
        this.nameType = nameType;
    }

    public TypeCustomer(Integer id, String nameType, int flag) {
        this.id = id;
        this.nameType = nameType;
        this.flag = flag;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameType() {
        return nameType;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}
