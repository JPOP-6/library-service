package com.library.service.system.resource.impl;

import com.library.service.system.clients.BookClient;
import com.library.service.system.clients.BookResult;
import com.library.service.system.clients.Result;
import com.library.service.system.clients.UserClient;
import com.library.service.system.clients.UserResult;
import com.library.service.system.clients.dto.BookDTO;
import com.library.service.system.clients.dto.UserDTO;
import com.library.service.system.model.dto.Profile;
import com.library.service.system.resource.api.LibraryResource;
import com.library.service.system.service.LibraryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@Slf4j
public class LibraryResourceImpl implements LibraryResource {
    private final BookClient bookClient;
    private final UserClient userClient;
    private final LibraryService libraryService;

    public LibraryResourceImpl(BookClient bookClient, UserClient userClient, LibraryService libraryService) {
        this.bookClient = bookClient;
        this.userClient = userClient;
        this.libraryService = libraryService;
    }

    @Override
    public ResponseEntity<UserResult> login(int userId) {
        return userClient.getUserById(userId);
    }

    @Override
    public ResponseEntity<BookResult> getAllBooks() {
        return bookClient.getAllBooks();
    }

    @Override
    public ResponseEntity<BookResult> getBookDetails(String bookId) {
        return bookClient.getBookById(bookId);
    }

    @Override
    public ResponseEntity<UserResult> getAllUsers() {
        return userClient.getAllUsers();
    }

    @Override
    public ResponseEntity<Result> getAllBooksIssuedByTheUser(int userId) {
        ResponseEntity<UserResult> result = userClient.getUserById(userId);
        List<UserDTO> user = result.getBody().getUsers();
        List<String> bookIds = libraryService.getAllBooksForUser(userId);
        List<BookDTO> books = bookIds.stream()
                .map(bookClient::getBookById)
                .map(HttpEntity::getBody).filter(Objects::nonNull)
                .map(BookResult::getBooks)
                .map(data -> data.get(0))
                .collect(Collectors.toList());
        Result<Profile> finalResult = new Result<>();
        Profile profile = new Profile();
        profile.setBooks(books);
        profile.setUserDTO(user.get(0));
        finalResult.setData(Collections.singletonList(profile));
        return ResponseEntity.ok().body(finalResult);
    }

    @Override
    public ResponseEntity<UserResult> addAUser(UserDTO userDTO) {
        return userClient.addUser(userDTO);
    }

    @Override
    public ResponseEntity<UserResult> updateUserAccountDetails(int userId, UserDTO userDTO) {
        return userClient.updateUser(userId, userDTO);
    }

    @Override
    public ResponseEntity<Result> issueBookToUser(int userId, String bookId) {
        libraryService.issueBookToUser(userId, bookId);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Result> releaseBookForUserId(int userId, String bookId) {
        libraryService.releaseBookFromUser(userId, bookId);
        return ResponseEntity.ok().build();
    }
}
