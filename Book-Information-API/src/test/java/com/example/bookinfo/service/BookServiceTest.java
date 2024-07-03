package com.example.bookinfo.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import java.net.URI;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import com.example.bookinfo.model.BookResponse;

class BookServiceTest {

	@InjectMocks
    private BookService bookService;

    @Mock
    private RestTemplate restTemplate;

    public BookServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetBookDetails() {
        String isbn = "1234567";
        String response = "{...}"; // Sample JSON response from API

        when(restTemplate.getForObject(any(URI.class), eq(String.class))).thenReturn(response);

        BookResponse bookResponse = bookService.getBookDetails(isbn);

        // Add assertions to verify the response
    }

}
