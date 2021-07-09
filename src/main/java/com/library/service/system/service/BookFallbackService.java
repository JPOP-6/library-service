package com.library.service.system.service;

import com.library.service.system.clients.BookClient;
import com.library.service.system.clients.Result;
import com.library.service.system.clients.dto.BookDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class BookFallbackService implements BookClient {

    @Override
    public ResponseEntity<Result<BookDTO>> getAllBooks() {
        log.debug("Fallback called for getAllBooks");
        Result<BookDTO> bookDTOResult = new Result<>();
        bookDTOResult.setSuccess(false);
        bookDTOResult.setError("Server is down");
        return ResponseEntity.ok().body(bookDTOResult);
    }

    @Override
    public ResponseEntity<Result<BookDTO>> getBookById(int id) {
        log.debug("Fallback called for getBookById");
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Result<BookDTO>> addBook(BookDTO book) {
        log.debug("Fallback called for addBook");
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Result<BookDTO>> deleteBook(int id) {
        log.debug("Fallback called for deleteBook");
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Result<BookDTO>> updateBook(int id, BookDTO bookDTO) {
        log.debug("Fallback called for updateBook");
        return ResponseEntity.ok().build();
    }
}
