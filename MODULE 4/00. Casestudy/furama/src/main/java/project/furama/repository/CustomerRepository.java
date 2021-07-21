package project.furama.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import project.furama.model.Customer;


@Repository
public interface CustomerRepository extends PagingAndSortingRepository<Customer,Integer> {
   @Query(value="select * from customers where flag=1 and `name` like :keyPara1 and type_id like :keyPara2",nativeQuery=true)
   Page<Customer> findAllCustomerByNameContaining(Pageable pageable,@Param("keyPara1") String key1,@Param("keyPara2") String key2);
}
