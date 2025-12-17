package com.example.web_app.service;

import com.example.web_app.dto.BookResponse;

import java.util.List;

public interface BookService {
    public List<BookResponse> getAllBooks();
}
