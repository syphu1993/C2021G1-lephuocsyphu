package book.manager.model;

import javax.persistence.*;

@Entity
@Table(name = "borow_book")
public class BorowBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int codeBook;
    @ManyToOne
    @JoinColumn(name = "book_id",referencedColumnName ="id" )
    private Book book;

    public BorowBook() {
    }

    public BorowBook(Integer id, int codeBook, Book book) {
        this.id = id;
        this.codeBook = codeBook;
        this.book = book;
    }

    public BorowBook(int codeBook, Book book) {
        this.codeBook = codeBook;
        this.book = book;
    }

    public BorowBook(Integer id, int codeBook) {
        this.id = id;
        this.codeBook = codeBook;
    }

    public BorowBook(int codeBook) {
        this.codeBook = codeBook;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCodeBook() {
        return codeBook;
    }

    public void setCodeBook(int codeBook) {
        this.codeBook = codeBook;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
