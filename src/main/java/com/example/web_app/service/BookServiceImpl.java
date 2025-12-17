package com.example.web_app.service;

import com.example.web_app.dto.BookRequest;
import com.example.web_app.dto.BookResponse;
import com.example.web_app.model.Book;
import com.example.web_app.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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

    @Override
    public BookResponse findBook(int id){
        return bookRepository.findById(id).map(this::toBookResponse).orElse(null);
    }

    @Override
    public BookResponse createBook(BookRequest request){
        Book book = new Book();
        book.setAuthor(request.getWrittenBy());
        book.setName(request.getTitle());
        bookRepository.save(book);

        return toBookResponse(book);
    }

    @Override
    public BookResponse updateBook(BookRequest request, int id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        if (StringUtils.hasText(request.getWrittenBy())) {
            book.setAuthor(request.getWrittenBy());
        }

        if (StringUtils.hasText(request.getTitle())) {
            book.setName(request.getTitle());
        }
         bookRepository.save(book);
         return toBookResponse(book);
    }


    private BookResponse toBookResponse(Book book){
        // this the mapping
        return new BookResponse(
                book.getId(),
                book.getName()
        );
    }
}
