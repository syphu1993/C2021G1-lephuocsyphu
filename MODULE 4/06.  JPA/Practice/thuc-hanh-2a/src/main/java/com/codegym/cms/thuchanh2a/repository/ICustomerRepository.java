package com.codegym.cms.thuchanh2a.repository;


import com.codegym.cms.thuchanh2a.model.Customer;
import jdk.nashorn.internal.ir.CallNode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Long> {
    @Procedure("Insert_Customer")
    void insertWithStoredProcedure(String firstName,String lastName);
}
