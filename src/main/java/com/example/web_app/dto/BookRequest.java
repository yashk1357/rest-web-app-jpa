package com.example.web_app.dto;
//import jakarta.validation.constraints.NotBlank;


public class BookRequest {
    private String title;
    private String writtenBy;

    public BookRequest(String title, String writtenBy) {
        if (title.isEmpty() || writtenBy.isEmpty()) {
            throw new IllegalArgumentException("title or wrritenBY cannot be empty");
        }

        this.title = title;
        this.writtenBy = writtenBy;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWrittenBy() {
        return writtenBy;
    }

    public void setWrittenBy(String writtenBy) {
        this.writtenBy = writtenBy;
    }
}
