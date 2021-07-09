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
