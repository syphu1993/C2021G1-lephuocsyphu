package block.blockapp.repository;

import block.blockapp.model.Title;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITitleRepository extends PagingAndSortingRepository<Title,Integer> {
}
