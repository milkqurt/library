package com.example.samgau_test.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "author")
    private String author;
    @Column(name = "price")
    private Double price;
    @Column(name = "genre")
    private Genre genre;
    @Column(name = "status")
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
}
