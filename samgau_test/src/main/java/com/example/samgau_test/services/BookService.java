package com.example.samgau_test.services;

import com.example.samgau_test.entity.Book;
import com.example.samgau_test.entity.Student;
import com.example.samgau_test.exceptions.UniversalError;
import com.example.samgau_test.models.MBook;
import com.example.samgau_test.repository.BookRepository;
import com.example.samgau_test.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private StudentRepository studentRepository;

    public Book addBookForLibrary(Book book) throws UniversalError {
        if (bookRepository.findByTitleAndAuthor(book.getTitle(), book.getAuthor()) != null) {
            throw new UniversalError("Such a book already exists");
        }
        return bookRepository.save(book);
    }

    public Book addBookForStudent(Book book, Long student_id) {
        Student student = studentRepository.findById(student_id).get();
        book.setStudent(student);
        return bookRepository.save(book);
    }

    public MBook get(Long id) throws UniversalError {
        Book verify = bookRepository.findById(id).get();
        if (verify == null) {
            throw new UniversalError("Book not found");
        }
        return MBook.toModel(verify);
    }

    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    public List<Book> genre(String genre) {
        List<Book> books = bookRepository.findAll();
        return books.stream().filter(book -> book.getGenre().equals(genre)).collect(Collectors.toList());
    }

    public MBook update(Long id) {
        Book book = bookRepository.findById(id).get();
        book.setStatus(!book.getStatus());
        return MBook.toModel(bookRepository.save(book));
    }

    public Long delete(Long id) {
        bookRepository.deleteById(id);
        return id;
    }
}
