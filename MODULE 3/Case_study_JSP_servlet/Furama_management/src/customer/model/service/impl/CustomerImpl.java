package customer.model.service.impl;

import customer.model.bean.Customer;
import customer.model.repository.CustomerRepository;
import customer.model.service.ICustomer;

import java.util.List;

public class CustomerImpl implements ICustomer {
    CustomerRepository customerRepository  = new CustomerRepository();
    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public boolean update(Customer customer) {
        return customerRepository.update(customer);
    }

    @Override
    public boolean delete(int id) {
        return customerRepository.delete(id);
    }

    @Override
    public List<Customer> findByName(String name) {
        return customerRepository.findByName(name);
    }
}
