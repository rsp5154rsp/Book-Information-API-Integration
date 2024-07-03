package com.example.bookinfo.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class BookResponse {
    private String bookIsbn;
    private String title;
    private List<String> publishers;
    private List<Author> authors;
    private int totalPages;
    private String publishedDate;

    @Data
    @Builder
    public static class Author {
        private String name;
    }
}
