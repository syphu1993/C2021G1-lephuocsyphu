package question.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import question.model.Question;
import question.repository.QuestionRepository;

import java.util.Optional;

@Service
public class QuestionService implements IQuestionService {
    @Autowired
    private QuestionRepository questionRepository;
    @Override
    public Page<Question> findAll(Pageable pageable) {
        return questionRepository.findAll(pageable);
    }

    @Override
    public Optional<Question> findById(Integer id) {
        return questionRepository.findById(id);
    }

    @Override
    public void save(Question question) {
        questionRepository.save(question);
    }

    @Override
    public void remove(Integer id) {
        questionRepository.deleteById(id);
    }

    @Override
    public Page<Question> findAllByName(Pageable pageable, String key1, String key2) {
        return questionRepository.findAllQuestionByNameContaining(pageable, "%"+key1+"%","%"+key2+"%" );
    }
}
