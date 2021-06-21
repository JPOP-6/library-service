package com.library.service.system;

import com.library.service.system.clients.UserClient;
import com.library.service.system.clients.UserResult;
import com.library.service.system.clients.dto.UserDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

@SpringBootTest
@AutoConfigureStubRunner(ids = {"com:user-service:+:stubs:8081"},
        stubsMode = StubRunnerProperties.StubsMode.LOCAL)
class UserClientContractTest {
    @Autowired
    private UserClient userClient;

    @Test
    void getAllUsers() {
        ResponseEntity<UserResult> result = userClient.getAllUsers();
        Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());
        Assertions.assertNotNull(result.getBody());
        UserResult body = result.getBody();
        Assertions.assertNull(body.getError());
        Assertions.assertTrue(body.isSuccess());
        Assertions.assertNotNull(body.getUsers());
        Assertions.assertEquals(2, body.getUsers().size());
        Assertions.assertEquals(getUserDTO1(), body.getUsers().get(0));
        Assertions.assertEquals(getUserDTO2(), body.getUsers().get(1));
    }

    @Test
    void getUserById() {
        ResponseEntity<UserResult> result = userClient.getUserById(1);
        Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());
        Assertions.assertNotNull(result.getBody());
        UserResult body = result.getBody();
        Assertions.assertNull(body.getError());
        Assertions.assertTrue(body.isSuccess());
        Assertions.assertNotNull(body.getUsers());
        Assertions.assertEquals(1, body.getUsers().size());
        Assertions.assertEquals(getUserDTO1(), body.getUsers().get(0));
    }

    @Test
    void updateUser() {
        ResponseEntity<UserResult> result = userClient.updateUser(1, getUserDTO1());
        Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());
        Assertions.assertNotNull(result.getBody());
        UserResult body = result.getBody();
        Assertions.assertNull(body.getError());
        Assertions.assertTrue(body.isSuccess());
        Assertions.assertNotNull(body.getUsers());
        Assertions.assertEquals(1, body.getUsers().size());
        Assertions.assertEquals(getUserDTO1(), body.getUsers().get(0));
    }

    @Test
    void deleteUser() {
        ResponseEntity<UserResult> result = userClient.deleteUser(1);
        Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());
        Assertions.assertNotNull(result.getBody());
        UserResult body = result.getBody();
        Assertions.assertNull(body.getError());
        Assertions.assertTrue(body.isSuccess());
        Assertions.assertNull(body.getUsers());
    }

    @Test
    void addUser() {
        ResponseEntity<UserResult> result = userClient.addUser(getUserDTO1());
        Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());
        Assertions.assertNotNull(result.getBody());
        UserResult body = result.getBody();
        Assertions.assertNull(body.getError());
        Assertions.assertTrue(body.isSuccess());
        Assertions.assertNotNull(body.getUsers());
        Assertions.assertEquals(1, body.getUsers().size());
        Assertions.assertEquals(getUserDTO1(), body.getUsers().get(0));
    }


    private UserDTO getUserDTO1() {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1);
        userDTO.setEmail("email1");
        userDTO.setLocalDate(LocalDate.of(2021, 06, 18));
        userDTO.setName("name1");
        userDTO.setPassword("password1");
        userDTO.setUsername("username1");
        return userDTO;
    }

    private UserDTO getUserDTO2() {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(2);
        userDTO.setEmail("email2");
        userDTO.setLocalDate(LocalDate.of(2021, 06, 18));
        userDTO.setName("name2");
        userDTO.setPassword("password2");
        userDTO.setUsername("username2");
        return userDTO;
    }

}