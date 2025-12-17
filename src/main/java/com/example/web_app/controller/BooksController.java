package com.example.web_app.controller;
import com.example.web_app.dto.BookResponse;
import com.example.web_app.service.BookService;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class BooksController {

    //injection, this will inject the bean(obj) of Boo in our class;
    private final BookService service;

    public BooksController(BookService service) {
        this.service = service;
    }

    @GetMapping("/books")
    public List<BookResponse> index(){
        return service.getAllBooks();
    }
//
//    @GetMapping("/books/{id}")
//    public Optional<Book> show(@PathVariable int id){
//      return repo.findById(id);
//    }
//
//    @PostMapping("/books")
//    public Book create(@RequestBody Book book){
//        return repo.save(book);
//    }
//
//    @PutMapping("/books")
//    public Book update(@RequestBody Book book){
//        return repo.save(book);
//    }
//    @PutMapping("/books/{id}")
//    public ResponseEntity<Book> update(@PathVariable int id, @RequestBody Book book) {
//        return repo.findById(id)
//                .map(existingBook -> {
//                    existingBook.setName(book.getName());
//                    existingBook.setAuthor(book.getAuthor());
//                    return ResponseEntity.ok(repo.save(existingBook));
//                })
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    @DeleteMapping("/books/{id}")
//    public ResponseEntity<?> delete(@PathVariable int id) {
//        if (!repo.existsById(id)){
//            return ResponseEntity.notFound().build();
//        }
//
//        repo.deleteById(id);
//        return ResponseEntity.ok("Book deleted successfully!");
//    }
}
