package question.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import question.model.Question;

@Repository
public interface QuestionRepository extends PagingAndSortingRepository<Question,Integer> {
    @Query(value="select * from questions where flag = 1 and  title like :keyPara1 and question_type_id like :keyPara2",nativeQuery=true)
    Page<Question> findAllQuestionByNameContaining(Pageable pageable, @Param("keyPara1") String key1, @Param("keyPara2") String key2);
}
