package project.furama.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import project.furama.model.Customer;
import project.furama.repository.CustomerRepository;

import java.util.Optional;
@Service
public class CustomerService implements ICustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Optional<Customer> findById(Integer id) {
        return customerRepository.findById(id);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void remove(Integer id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Page<Customer> findAllByName(Pageable pageable, String key1,String key2) {
        return customerRepository.findAllCustomerByNameContaining(pageable, "%"+key1+"%","%"+key2+"%");
    }

    @Override
    public Iterable<Customer> findAllNoPage() {
        return customerRepository.findAll();
    }
}
