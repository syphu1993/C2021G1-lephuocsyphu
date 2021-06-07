package customer.model.service;

import customer.model.bean.Customer;

import java.util.List;

public interface ICustomer {
    List<Customer> findAll();
    Customer findById(int id);
    void save(Customer customer);
    boolean update(Customer customer);
    boolean delete(int id);
    List<Customer> findByName(String name);
    List<String> findAllTypeCustomer();
}
