package com.library.service.system.clients;

import com.library.service.system.clients.dto.BookDTO;
import lombok.Data;

import java.util.List;

@Data
public class BookResult {
    private boolean success;
    private String error;
    private List<BookDTO> books;
}
