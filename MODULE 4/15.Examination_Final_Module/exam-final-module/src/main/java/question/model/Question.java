package question.model;

import javax.persistence.*;

@Entity
@Table(name = "questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String contentQuestion;
    private String getContentAnswer;
    private String dateMade;
    private String statuses;
    private int flag;
    @ManyToOne
    @JoinColumn(name = "question_type_id",referencedColumnName ="id" )
    private QuestionType questionType;

    public Question() {
    }

    public Question(Integer id, String title, String contentQuestion, String getContentAnswer, String dateMade, String statuses, int flag, QuestionType questionType) {
        this.id = id;
        this.title = title;
        this.contentQuestion = contentQuestion;
        this.getContentAnswer = getContentAnswer;
        this.dateMade = dateMade;
        this.statuses = statuses;
        this.flag = flag;
        this.questionType = questionType;
    }

    public Question(String title, String contentQuestion, String getContentAnswer, String dateMade, String statuses, QuestionType questionType) {
        this.title = title;
        this.contentQuestion = contentQuestion;
        this.getContentAnswer = getContentAnswer;
        this.dateMade = dateMade;
        this.statuses = statuses;
        this.questionType = questionType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContentQuestion() {
        return contentQuestion;
    }

    public void setContentQuestion(String contentQuestion) {
        this.contentQuestion = contentQuestion;
    }

    public String getGetContentAnswer() {
        return getContentAnswer;
    }

    public void setGetContentAnswer(String getContentAnswer) {
        this.getContentAnswer = getContentAnswer;
    }

    public String getDateMade() {
        return dateMade;
    }

    public void setDateMade(String dateMade) {
        this.dateMade = dateMade;
    }

    public String getStatuses() {
        return statuses;
    }

    public void setStatuses(String statuses) {
        this.statuses = statuses;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }
}
