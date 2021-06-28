package book.manager.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nameBook;
    private int quantity;
    @OneToMany(mappedBy = "book")
    private List<BorowBook> borowBooks;

    public Book() {
    }

    public Book(Integer id, String nameBook, int quantity) {
        this.id = id;
        this.nameBook = nameBook;
        this.quantity = quantity;
    }

    public Book(String nameBook, int quantity) {
        this.nameBook = nameBook;
        this.quantity = quantity;
    }

    public Book(Integer id, String nameBook, int quantity, List<BorowBook> borowBooks) {
        this.id = id;
        this.nameBook = nameBook;
        this.quantity = quantity;
        this.borowBooks = borowBooks;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<BorowBook> getBorowBooks() {
        return borowBooks;
    }

    public void setBorowBooks(List<BorowBook> borowBooks) {
        this.borowBooks = borowBooks;
    }
}
