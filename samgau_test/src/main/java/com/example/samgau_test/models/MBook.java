package com.example.samgau_test.models;

import com.example.samgau_test.entity.Book;
import com.example.samgau_test.entity.Genre;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MBook {
    private Long id;
    private String title;
    private String author;
    private Double price;
    private Genre genre;
    private Boolean status;

    public static MBook toModel(Book book) {
        MBook model = new MBook();
        model.setId(book.getId());
        model.setTitle(book.getTitle());
        model.setAuthor(book.getAuthor());
        model.setPrice(book.getPrice());
        model.setGenre(book.getGenre());
        model.setStatus(book.getStatus());
        return model;
    }
}
