package block.blockapp.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "blogs")
public class Blog {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String author;
    private Date postDate;
    private String contents;

    @ManyToOne
    @JoinColumn(name = "title_id",referencedColumnName ="id" )
    @JsonManagedReference
    private Title title;

    public Blog() {
    }

    public Blog(String author, Date postDate, String contents) {
        this.author = author;
        this.postDate = postDate;
        this.contents = contents;
    }

    public Blog(Integer id, String author, Date postDate, String contents) {
        this.id = id;
        this.author = author;
        this.postDate = postDate;
        this.contents = contents;
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

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }
}