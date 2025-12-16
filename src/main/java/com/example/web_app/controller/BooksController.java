package com.example.web_app.controller;

import com.example.web_app.model.Book;
import com.example.web_app.repository.BookRepository;
import jdk.swing.interop.SwingInterOpUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BooksController {

    //injection, this will inject the bean(obj) of BookRepository in our class;
    private final BookRepository repo;

    public BooksController(BookRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/books")
    public List<Book> index(){
        return repo.findAll();
    }

    @GetMapping("/books/{id}")
    public Optional<Book> show(@PathVariable int id){
      return repo.findById(id);
    }

    @PostMapping("/books")
    public Book create(@RequestBody Book book){
        return repo.save(book);
    }

    @PutMapping("/books")
    public Book update(@RequestBody Book book){
        return repo.save(book);
    }
    @PutMapping("/books/{id}")
    public ResponseEntity<Book> update(@PathVariable int id, @RequestBody Book book) {
        return repo.findById(id)
                .map(existingBook -> {
                    existingBook.setName(book.getName());
                    existingBook.setAuthor(book.getAuthor());
                    return ResponseEntity.ok(repo.save(existingBook));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        if (!repo.existsById(id)){
            return ResponseEntity.notFound().build();
        }

        repo.deleteById(id);
        return ResponseEntity.ok("Book deleted successfully!");
    }
}
