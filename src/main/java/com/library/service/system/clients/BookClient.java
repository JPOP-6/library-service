package com.library.service.system.clients;

import com.library.service.system.clients.dto.BookDTO;
import com.library.service.system.service.BookFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "${feign.book.name}", url = "${feign.book.url}",
        fallback = BookFallbackService.class)
public interface BookClient {
    @GetMapping(value = "/", produces = "application/json", consumes = "application/json")
    ResponseEntity<BookResult> getAllBooks();

    @GetMapping(value = "/{id}", produces = "application/json", consumes = "application/json")
    ResponseEntity<BookResult> getBookById(@PathVariable("id") String id);

    @PostMapping(value = "/", produces = "application/json", consumes = "application/json")
    ResponseEntity<BookResult> addBook(@RequestBody BookDTO book);

    @DeleteMapping(value = "/{id}", produces = "application/json", consumes = "application/json")
    ResponseEntity<BookResult> deleteBook(@PathVariable("id") String id);

    @PutMapping(value = "/{id}", produces = "application/json", consumes = "application/json")
    ResponseEntity<BookResult> updateBook(@PathVariable("id") String id, @RequestBody BookDTO bookDTO);

}
