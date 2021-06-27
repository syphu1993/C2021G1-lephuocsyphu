package management.product.repository;

import management.product.model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IproductRepository extends PagingAndSortingRepository<Product,Integer> {
}
