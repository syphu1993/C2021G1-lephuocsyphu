package project.furama.dto;

import project.furama.model.Customer;
import project.furama.model.Employee;
import project.furama.model.Service;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ContractDto {
    private Integer id;
    private String startDay;
    private String endDay;
    @NotNull(message = "Deposit is empty!")
    @DecimalMin(value = "0.00",message = "Deposit is not decimal!")
    private Double deposit;
    private Double totalMoney;
    private int flag;
    private Employee employee;
    private Customer customer;
    private Service service;

    public ContractDto() {
    }

    public ContractDto(String startDay, String endDay, Double deposit, Double totalMoney, Employee employee, Customer customer, Service service) {
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

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
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
}
