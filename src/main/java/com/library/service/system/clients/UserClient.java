package com.library.service.system.clients;

import com.library.service.system.clients.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "user-service", url = "http://host.docker.internal:8081/users/")
public interface UserClient {
    @GetMapping("/")
    ResponseEntity<Result> getAllUsers();

    @GetMapping("/{id}")
    ResponseEntity<Result> getUserById(@PathVariable("id") int id);

    @PostMapping("/")
    ResponseEntity<Result> addUser(@RequestBody UserDTO userDTO);

    @DeleteMapping("/{id}")
    ResponseEntity<Result> deleteUser(@PathVariable("id") int id);

    @PutMapping("/{id}")
    ResponseEntity<Result> updateUser(@PathVariable("id") int id, @RequestBody UserDTO userDTO);

}
