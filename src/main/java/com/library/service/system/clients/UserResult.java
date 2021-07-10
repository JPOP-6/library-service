package com.library.service.system.clients;

import com.library.service.system.clients.dto.UserDTO;
import lombok.Data;

import java.util.List;

@Data
public class UserResult {
    private boolean success;
    private String error;
    private List<UserDTO> users;
}
