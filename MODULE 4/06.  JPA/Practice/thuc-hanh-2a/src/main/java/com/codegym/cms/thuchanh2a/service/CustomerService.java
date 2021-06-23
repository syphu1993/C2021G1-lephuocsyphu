package com.codegym.cms.thuchanh2a.service;


import com.codegym.cms.thuchanh2a.model.Customer;
import com.codegym.cms.thuchanh2a.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public void insertWithStoredProcedure(Customer customer) {
        customerRepository.insertWithStoredProcedure(customer.getFirstName(),customer.getLastName());
    }
}
