package project.furama.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import project.furama.model.Customer;

import java.util.Optional;

public interface ICustomerService {
    Page<Customer> findAll(Pageable pageable);

    Optional<Customer> findById(Integer id);

    void save(Customer customer);

    void remove(Integer id);

    Page<Customer> findAllByName(Pageable pageable,String key);

    Iterable<Customer> findAllNoPage();
}
