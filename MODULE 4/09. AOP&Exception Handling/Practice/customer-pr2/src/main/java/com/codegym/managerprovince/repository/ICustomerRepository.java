package com.codegym.managerprovince.repository;


import com.codegym.managerprovince.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ICustomerRepository extends PagingAndSortingRepository<Customer,Long> {

    Page<Customer> findAllByFirstNameContaining(Pageable pageable,String key);
}
