package com.example.web_app.controller;
import com.example.web_app.dto.BookRequest;
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

    @GetMapping("/books/{id}")
    public BookResponse show(@PathVariable int id){
      return service.findBook(id);
    }

    @PostMapping("/books")
    public BookResponse create(@RequestBody BookRequest bookRequest){
        return service.createBook(bookRequest);
    }


    @PutMapping("/books/{id}")
    public BookResponse update(@RequestBody BookRequest bookRequest, @PathVariable int id){
        return service.updateBook(bookRequest, id);
    }
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
