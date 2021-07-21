package question.dto;

import question.model.QuestionType;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class QuestionDto {
    private Integer id;
    @NotEmpty(message = "Not empty!")
    @Size(min = 5,max = 100,message = "Wrong length!")
    private String title;
    @NotEmpty(message = "Not empty!")
    @Size(min = 10,max = 500,message = "Wrong length!")
    private String contentQuestion;
    @NotEmpty(message = "Not empty!")
    @Size(min = 10,max = 500,message = "Wrong length!")
    private String getContentAnswer;
    @NotEmpty(message = "Not empty!")
    private String dateMade;
    @NotEmpty(message = "Not empty!")
    private String statuses;
    private int flag;
    private QuestionType questionType;

    public QuestionDto() {
    }

    public QuestionDto(Integer id, String title, String contentQuestion, String getContentAnswer, String dateMade, String statuses, int flag, QuestionType questionType) {
        this.id = id;
        this.title = title;
        this.contentQuestion = contentQuestion;
        this.getContentAnswer = getContentAnswer;
        this.dateMade = dateMade;
        this.statuses = statuses;
        this.flag = flag;
        this.questionType = questionType;
    }

    public QuestionDto(String title, String contentQuestion, String getContentAnswer, String dateMade, String statuses, QuestionType questionType) {
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
