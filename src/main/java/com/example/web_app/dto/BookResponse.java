package com.example.web_app.dto;

public class BookResponse {
    private int bookId;
    private String bookName;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public BookResponse(int bookId, String bookName) {
        System.out.println("BOOK-RESPONSE instantiated");
        this.bookId = bookId;
        this.bookName = bookName;
    }
}
