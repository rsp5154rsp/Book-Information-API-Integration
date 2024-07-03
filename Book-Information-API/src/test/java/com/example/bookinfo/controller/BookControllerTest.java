package com.example.bookinfo.controller;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.bookinfo.model.BookRequest;
import com.example.bookinfo.model.BookResponse;
import com.example.bookinfo.service.BookService;

@WebMvcTest(BookController.class)
class BookControllerTest {

	@InjectMocks
	private BookController bookController;

	@MockBean
	private BookService bookService;

	@Mock
	private MockMvc mockMvc;

	public BookControllerTest() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testGetBookDetails() throws Exception {
		String isbn = "1234567";
		BookRequest bookRequest = BookRequest.builder().bookIsbn(isbn).build();
		BookResponse bookResponse = BookResponse.builder().bookIsbn(isbn).title("Example Book").build();

		when(bookService.getBookDetails(anyString())).thenReturn(bookResponse);

		mockMvc.perform(MockMvcRequestBuilders.post("/book").contentType("application/json")
				.content("{\"bookIsbn\":\"1234567\"}")).andExpect(status().isOk());
	}

}
