package question.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import question.model.QuestionType;

@Repository
public interface QuestionTypeRepository extends JpaRepository<QuestionType,Integer> {
}
