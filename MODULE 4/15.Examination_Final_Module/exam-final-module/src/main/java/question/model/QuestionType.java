package question.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "question_type")
public class QuestionType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nameType;

    @OneToMany(mappedBy = "questionType")
    private List<Question> questions;

    public QuestionType() {
    }

    public QuestionType(Integer id, String nameType) {
        this.id = id;
        this.nameType = nameType;
    }

    public QuestionType(Integer id, String nameType, List<Question> questions) {
        this.id = id;
        this.nameType = nameType;
        this.questions = questions;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameType() {
        return nameType;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
