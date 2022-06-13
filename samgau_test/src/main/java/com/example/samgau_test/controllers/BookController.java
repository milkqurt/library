package com.example.samgau_test.controllers;

import com.example.samgau_test.entity.Book;
import com.example.samgau_test.exceptions.UniversalError;
import com.example.samgau_test.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/library-book")
    public ResponseEntity addBookForLibrary(@RequestBody Book book) {
        try {
            return ResponseEntity.ok(bookService.addBookForLibrary(book));
        } catch (UniversalError exist) {
            return ResponseEntity.badRequest().body(exist.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body("An error has occurred");
        }
    }

    @PostMapping("/student-book")
    public ResponseEntity addBookForStudent(@RequestBody Book book, @RequestParam Long id) {
        try {
            return ResponseEntity.ok(bookService.addBookForStudent(book, id));
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body("An error has occurred");
        }
    }

    @PutMapping("/book")
    public ResponseEntity update(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(bookService.update(id));
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body("An error has occurred");
        }
    }

    @GetMapping("/genre")
    public ResponseEntity BookByGenre(@RequestParam String genre) {
        try {
            return ResponseEntity.ok(bookService.genre(genre));
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body("An error has occurred");
        }
    }

    @GetMapping("/book")
    public ResponseEntity showBook(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(bookService.get(id));
        } catch (UniversalError exist) {
            return ResponseEntity.badRequest().body(exist.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body("An error has occurred");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(bookService.delete(id));
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body("An error has occurred");
        }
    }

    @GetMapping("/all")
    public ResponseEntity showAll() {
        try {
            return ResponseEntity.ok(bookService.getAll());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body("An error has occurred");
        }
    }
}
