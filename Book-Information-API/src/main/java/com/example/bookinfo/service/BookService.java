package com.example.bookinfo.service;

import java.net.URI;
import java.util.Collections;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.bookinfo.model.BookResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@Service
public class BookService {
	private static final String BOOK_API_URL = "https://openlibrary.org/api/books";

    public BookResponse getBookDetails(String isbn) {
        RestTemplate restTemplate = new RestTemplate();
        URI uri = UriComponentsBuilder.fromHttpUrl(BOOK_API_URL)
                .queryParam("bibkeys", "ISBN:" + isbn)
                .queryParam("format", "json")
                .queryParam("jscmd", "data")
                .build()
                .toUri();

        String response = restTemplate.getForObject(uri, String.class);
        
        return BookResponse.builder()
                .bookIsbn(isbn)
                .title("Example Book")
                .publishers(Collections.singletonList("Example Publisher"))
                .authors(Collections.singletonList(BookResponse.Author.builder().name("Example Author").build()))
                .totalPages(100)
                .publishedDate("01-01-2022")
                .build();
    }
}
