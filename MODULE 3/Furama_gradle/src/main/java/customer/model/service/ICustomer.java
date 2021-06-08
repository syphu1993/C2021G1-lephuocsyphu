package customer.model.service;

import customer.model.bean.Customer;

import java.util.List;
import java.util.Map;

public interface ICustomer {
    List<Customer> findAll();
    Customer findById(int id);
    Map<String,String> save(Customer customer);
    boolean update(Customer customer);
    boolean delete(int id);
    List<Customer> findByName(String name);
    List<String> findAllTypeCustomer();
}
