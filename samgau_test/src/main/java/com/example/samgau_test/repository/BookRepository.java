package com.example.samgau_test.repository;

import com.example.samgau_test.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    Book findByTitleAndAuthor(String title,String author);
}
