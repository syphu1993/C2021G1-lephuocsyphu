package question.service;

import question.model.QuestionType;

public interface IQuestionTypeService {
    Iterable<QuestionType> findAll();
}
