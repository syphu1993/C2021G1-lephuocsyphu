package question.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import question.model.Question;

import java.util.Optional;

public interface IQuestionService {
    Page<Question> findAll(Pageable pageable);

    Optional<Question> findById(Integer id);

    void save(Question question);

    void remove(Integer id);

    Page<Question> findAllByName(Pageable pageable,String key1,String key2);

}
