package management.product.repository;

import management.product.model.Type;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITypePrository extends PagingAndSortingRepository<Type,Integer> {
}
