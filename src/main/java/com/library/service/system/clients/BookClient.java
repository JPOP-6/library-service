package com.library.service.system.clients;

import com.library.service.system.clients.dto.BaseDTO;
import com.library.service.system.clients.dto.BookDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "book-service", url = "http://host.docker.internal:8080/books/")
public interface BookClient{
    @GetMapping("/")
    ResponseEntity<Result<BookDTO>> getAllBooks();

    @GetMapping("/{id}")
    ResponseEntity<Result<BookDTO>> getBookById(@PathVariable("id") int id);

    @PostMapping("/")
    ResponseEntity<Result<BookDTO>> addBook(@RequestBody BookDTO book);

    @DeleteMapping("/{id}")
    ResponseEntity<Result<BookDTO>> deleteBook(@PathVariable("id") int id);

    @PutMapping("/{id}")
    ResponseEntity<Result<BookDTO>> updateBook(@PathVariable("id") int id, @RequestBody BookDTO bookDTO);

}
