package book.manager.repository;

import book.manager.model.BorowBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorowBookRepository extends JpaRepository<BorowBook,Integer> {
}
