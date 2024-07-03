package com.example.bookinfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookinfo.model.BookRequest;
import com.example.bookinfo.model.BookResponse;
import com.example.bookinfo.model.ErrorResponse;
import com.example.bookinfo.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {
	@Autowired
	private BookService bookService;

	@PostMapping
	public ResponseEntity<?> getBookDetails(@RequestBody BookRequest bookRequest) {
		try {
			BookResponse bookResponse = bookService.getBookDetails(bookRequest.getBookIsbn());
			return ResponseEntity.ok(bookResponse);
		} catch (Exception e) {
			ErrorResponse errorResponse = ErrorResponse.builder().message("There was an error").details(e.getMessage())
					.build();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
		}
	}
}