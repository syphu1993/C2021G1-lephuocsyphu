package project.furama.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import project.furama.model.Customer;
import project.furama.model.Employee;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee,Integer> {
    @Query(value="select * from employees where flag=1 and `name` like :keyPara",nativeQuery=true)
    Page<Employee> findAllEmployeeByNameContaining(Pageable pageable, @Param("keyPara") String key);
}
