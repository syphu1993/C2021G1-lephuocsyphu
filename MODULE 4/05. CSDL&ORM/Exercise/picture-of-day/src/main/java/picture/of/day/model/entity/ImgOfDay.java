package picture.of.day.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "img_of_day")
public class ImgOfDay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer point;
    private String author;
    @Column(name = "feed_back")
    private String feedBack;
    private int likes;

    public ImgOfDay() {
    }

    public ImgOfDay(Integer point, String author, String feedBack) {
        this.point = point;
        this.author = author;
        this.feedBack = feedBack;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFeedBack() {
        return feedBack;
    }

    public void setFeedBack(String feedBack) {
        this.feedBack = feedBack;
    }
}
