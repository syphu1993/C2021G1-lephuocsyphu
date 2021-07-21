package question.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import question.model.QuestionType;
import question.repository.QuestionTypeRepository;

@Service
public class QuestionTypeService implements IQuestionTypeService {
    @Autowired
    private QuestionTypeRepository questionTypeRepository;

    @Override
    public Iterable<QuestionType> findAll() {
        return questionTypeRepository.findAll();
    }
}
