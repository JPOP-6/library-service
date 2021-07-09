package com.library.service.system.clients;

import com.library.service.system.clients.dto.UserDTO;
import com.library.service.system.service.UserFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "${feign.user.name}", url = "${feign.user.url}",
        fallback = UserFallbackService.class)
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
