package com.library.service.system.resource.api;

import com.library.service.system.clients.Result;
import com.library.service.system.clients.dto.BaseDTO;
import com.library.service.system.clients.dto.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/library")
public interface LibraryResource<T extends BaseDTO> {
    @GetMapping("/{user_id}")
    ResponseEntity<Result<T>> login(@PathVariable("user_id") int userId);

    @GetMapping("/books")
    ResponseEntity<Result<T>> getAllBooks();

    @GetMapping("/books/{book_id}")
    ResponseEntity<Result<T>> getBookDetails(@PathVariable("book_id") String bookId);

    @GetMapping("/users")
    ResponseEntity<Result<T>> getAllUsers();

    @GetMapping("/users/{user_id}")
    ResponseEntity<Result<T>> getAllBooksIssuedByTheUser(@PathVariable("user_id") int userId);

    @PostMapping("/users")
    ResponseEntity<Result<T>> addAUser(@RequestBody UserDTO userDTO);

    @PutMapping("/users/{user_id}")
    ResponseEntity<Result<T>> updateUserAccountDetails(@PathVariable("user_id") int userId,
                                                    @RequestBody UserDTO userDTO);

    @PostMapping("/users/{user_id}/books/{book_id}")
    ResponseEntity<Result<T>> issueBookToUser(@PathVariable("user_id") int userId,
                                           @PathVariable("book_id") String bookId);

    @DeleteMapping("/users/{user_id}/books/{book_id}")
    ResponseEntity<Result<T>> releaseBookForUserId(@PathVariable("user_id") int userId,
                                                @PathVariable("book_id") String bookId);
}
