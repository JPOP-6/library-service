package com.library.service.system;

import com.library.service.system.clients.BookClient;
import com.library.service.system.clients.BookResult;
import com.library.service.system.clients.dto.BookDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;

@SpringBootTest
@AutoConfigureStubRunner(ids = {"com:book-service:+:stubs:8080"},
        stubsMode = StubRunnerProperties.StubsMode.LOCAL)
class BookClientContractTest {
    @Autowired
    private BookClient bookClient;

    @Test
    void getAllBooks() {
        ResponseEntity<BookResult> result = bookClient.getAllBooks();
        Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());
        Assertions.assertNotNull(result.getBody());
        BookResult body = result.getBody();
        Assertions.assertNull(body.getError());
        Assertions.assertTrue(body.isSuccess());
        Assertions.assertNotNull(body.getBooks());
        Assertions.assertEquals(2, body.getBooks().size());
        Assertions.assertEquals(getBookDTO(), body.getBooks().get(0));
        Assertions.assertEquals(getBookDTO2(), body.getBooks().get(1));
    }

    @Test
    void getBookById() {
        ResponseEntity<BookResult> result = bookClient.getBookById("1");
        Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());
        Assertions.assertNotNull(result.getBody());
        BookResult body = result.getBody();
        Assertions.assertNull(body.getError());
        Assertions.assertTrue(body.isSuccess());
        Assertions.assertNotNull(body.getBooks());
        Assertions.assertEquals(1, body.getBooks().size());
        Assertions.assertEquals(getBookDTO(), body.getBooks().get(0));
    }

    @Test
    void updateBook() {
        ResponseEntity<BookResult> result = bookClient.updateBook("1", getBookDTO());
        Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());
        Assertions.assertNotNull(result.getBody());
        BookResult body = result.getBody();
        Assertions.assertNull(body.getError());
        Assertions.assertTrue(body.isSuccess());
        Assertions.assertNotNull(body.getBooks());
        Assertions.assertEquals(1, body.getBooks().size());
        Assertions.assertEquals(getBookDTO(), body.getBooks().get(0));
    }

    @Test
    void deleteBook() {
        ResponseEntity<BookResult> result = bookClient.deleteBook("1");
        Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());
        Assertions.assertNotNull(result.getBody());
        BookResult body = result.getBody();
        Assertions.assertNull(body.getError());
        Assertions.assertTrue(body.isSuccess());
        Assertions.assertNull(body.getBooks());
    }

    @Test
    void addBook() {
        ResponseEntity<BookResult> result = bookClient.addBook(getBookDTO());
        Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());
        Assertions.assertNotNull(result.getBody());
        BookResult body = result.getBody();
        Assertions.assertNull(body.getError());
        Assertions.assertTrue(body.isSuccess());
        Assertions.assertNotNull(body.getBooks());
        Assertions.assertEquals(1, body.getBooks().size());
        Assertions.assertEquals(getBookDTO(), body.getBooks().get(0));
    }

    private BookDTO getBookDTO() {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId("1");
        bookDTO.setTitle("title1");
        bookDTO.setCategory("category1");
        bookDTO.setPublisher("publisher1");
        bookDTO.setPrice(BigDecimal.valueOf(100));
        bookDTO.setAuthor("author1");
        return bookDTO;
    }

    private BookDTO getBookDTO2() {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId("2");
        bookDTO.setTitle("title2");
        bookDTO.setCategory("category2");
        bookDTO.setPublisher("publisher2");
        bookDTO.setPrice(BigDecimal.valueOf(200));
        bookDTO.setAuthor("author2");
        return bookDTO;
    }
}