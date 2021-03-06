package model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "books")
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookId")
    private Integer bookId;
    private String bookName;
    private String genere;
    private String isbn;
    private LocalDateTime dateOfPublication;
    private String description;
    private Integer quantity;
    private Integer price;
    private String createdBy;
    private LocalDateTime createdOn;
    private String modifiedBy;

    @OneToMany(mappedBy = "book")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<CartelRecord> cartelRecords = new HashSet<>();

    public Book(String bookName, String genere, String isbn, String description, Integer quantity, Integer price, LocalDateTime createdOn) {
        this.bookName = bookName;
        this.genere = genere;
        this.isbn = isbn;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.createdOn = createdOn;
    }



    public Book() {

    }
}
