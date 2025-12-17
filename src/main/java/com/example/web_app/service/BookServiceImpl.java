package com.example.web_app.service;

import com.example.web_app.dto.BookResponse;
import com.example.web_app.model.Book;
import com.example.web_app.repository.BookRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository){
        this.bookRepository = bookRepository;
        System.out.println("BOOKSERVICE_IMPL instantiated");
    }

    @Override
    public List<BookResponse> getAllBooks(){
        return bookRepository.findAll()
                            .stream()
                            .map(this::toBookResponse)
                            .toList();
    }


    private BookResponse toBookResponse(Book book){
        // this the mapping
        return new BookResponse(
                book.getId(),
                book.getName()
        );
    }
}
