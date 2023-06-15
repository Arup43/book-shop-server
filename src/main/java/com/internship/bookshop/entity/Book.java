package com.internship.bookshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookId;

    private String title;
    private Double price;
    private int yearOfPublish;
    private String genre;
    private String publisher;

    @Embedded
    private Author author;

    @ManyToOne(
            cascade = CascadeType.ALL,
            optional = false,
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "bookshop_id",
            referencedColumnName = "bookshopId"
    )
    private BookShop bookShop;
}
