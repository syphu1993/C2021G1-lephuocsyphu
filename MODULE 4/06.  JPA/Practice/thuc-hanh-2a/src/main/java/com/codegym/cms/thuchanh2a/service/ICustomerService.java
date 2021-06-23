package com.codegym.cms.thuchanh2a.service;


import com.codegym.cms.thuchanh2a.model.Customer;

public interface ICustomerService {
    void insertWithStoredProcedure(Customer customer);
}
