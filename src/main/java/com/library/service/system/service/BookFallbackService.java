package com.library.service.system.service;

import com.library.service.system.clients.BookClient;
import com.library.service.system.clients.BookResult;
import com.library.service.system.clients.dto.BookDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class BookFallbackService implements BookClient {

    @Override
    public ResponseEntity<BookResult> getAllBooks() {
        log.debug("Fallback called for getAllBooks");
        BookResult bookDTOResult = new BookResult();
        bookDTOResult.setSuccess(false);
        bookDTOResult.setError("Server is down");
        return ResponseEntity.ok().body(bookDTOResult);
    }

    @Override
    public ResponseEntity<BookResult> getBookById(String id) {
        log.debug("Fallback called for getBookById");
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<BookResult> addBook(BookDTO book) {
        log.debug("Fallback called for addBook");
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<BookResult> deleteBook(String id) {
        log.debug("Fallback called for deleteBook");
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<BookResult> updateBook(String id, BookDTO bookDTO) {
        log.debug("Fallback called for updateBook");
        return ResponseEntity.ok().build();
    }
}
