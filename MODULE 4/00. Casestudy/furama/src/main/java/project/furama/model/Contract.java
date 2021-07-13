package project.furama.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "contracts")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String startDay;
    private String endDay;
    private double deposit;
    private double totalMoney;
    private int flag;
    @ManyToOne
    @JoinColumn(name = "employee_id",referencedColumnName ="id")
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "customer_id",referencedColumnName ="id")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "service_id",referencedColumnName ="id")
    private Service service;
    @OneToMany(mappedBy = "contract")
    private List<DetailContract> detailContracts;

    public Contract() {
    }

    public Contract(String startDay, String endDay, double deposit, double totalMoney, Employee employee, Customer customer, Service service) {
        this.startDay = startDay;
        this.endDay = endDay;
        this.deposit = deposit;
        this.totalMoney = totalMoney;
        this.employee = employee;
        this.customer = customer;
        this.service = service;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public List<DetailContract> getDetailContracts() {
        return detailContracts;
    }

    public void setDetailContracts(List<DetailContract> detailContracts) {
        this.detailContracts = detailContracts;
    }
}
