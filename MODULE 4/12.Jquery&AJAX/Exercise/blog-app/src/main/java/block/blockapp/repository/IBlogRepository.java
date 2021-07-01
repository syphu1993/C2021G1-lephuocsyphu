package block.blockapp.repository;

import block.blockapp.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IBlogRepository extends PagingAndSortingRepository<Blog,Integer> {
    @Query(value="select * from blogs inner join titles on blogs.title_id =titles.id where titles.`name` like :keyPara",nativeQuery=true)

    Page<Blog> findAllByTitle_NameContaining(Pageable pageable,@Param("keyPara") String  key);
}
