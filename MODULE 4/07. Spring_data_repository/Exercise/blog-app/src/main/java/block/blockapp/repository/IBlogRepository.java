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
    @Query(value="select * \n" +
            "from blogs join titles on blogs.title_id =titles.id\n" +
            "where titles.name like :keyParam",nativeQuery=true)
    Page<Blog> findByTitle(Pageable pageable, @Param("keyParam") String key);
}
