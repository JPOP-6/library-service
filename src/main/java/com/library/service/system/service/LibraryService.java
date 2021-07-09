package com.library.service.system.service;

import com.library.service.system.model.Library;
import com.library.service.system.repositories.LibraryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibraryService {

    private final LibraryRepository repository;

    public LibraryService(LibraryRepository repository) {
        this.repository = repository;
    }

    public List<Integer> getAllBooksForUser(int userId) {
         return repository.getByUserId(userId).stream()
                 .map(Library::getBookId)
                 .collect(Collectors.toList());
    }

    public Library issueBookToUser(int userId,int bookId) {
        Library library = new Library();
        library.setBookId(bookId);
        library.setUserId(userId);
        return repository.save(library);
    }

    public void releaseBookFromUser(int userId, int bookId) {
        Library library = repository.getByUserIdAndBookId(userId, bookId);
        repository.deleteById(library.getId());
    }
}
