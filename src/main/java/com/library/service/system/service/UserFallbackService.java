package com.library.service.system.service;

import com.library.service.system.clients.UserClient;
import com.library.service.system.clients.UserResult;
import com.library.service.system.clients.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class UserFallbackService implements UserClient {

    @Override
    public ResponseEntity<UserResult> getAllUsers() {
        log.debug("Fallback called for getAllUsers");
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<UserResult> getUserById(int id) {
        log.debug("Fallback called for getUserById");
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<UserResult> addUser(UserDTO userDTO) {
        log.debug("Fallback called for addUser");
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<UserResult> deleteUser(int id) {
        log.debug("Fallback called for deleteUser");
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<UserResult> updateUser(int id, UserDTO userDTO) {
        log.debug("Fallback called for updateUser");
        return ResponseEntity.ok().build();
    }
}
