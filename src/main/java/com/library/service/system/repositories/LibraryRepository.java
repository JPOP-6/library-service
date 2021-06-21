package com.library.service.system.repositories;

import com.library.service.system.model.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Integer> {
    List<Library> getByUserId(int userId);

    Library getByUserIdAndBookId(int userId, String bookId);
}
