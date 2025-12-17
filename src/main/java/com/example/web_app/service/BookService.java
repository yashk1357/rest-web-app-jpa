package com.example.web_app.service;

import com.example.web_app.dto.BookRequest;
import com.example.web_app.dto.BookResponse;

import java.util.List;

public interface BookService {
    public List<BookResponse> getAllBooks();
    public BookResponse findBook(int id);
    public BookResponse createBook(BookRequest request);
    public  BookResponse updateBook(BookRequest request, int id);
}
