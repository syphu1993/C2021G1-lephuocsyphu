package project.furama.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.furama.model.TypeCustomer;

public interface TypeCustomerRepository  extends JpaRepository<TypeCustomer,Integer> {
}
