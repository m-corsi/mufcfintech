package com.mufcfintech.controller;

import com.mufcfintech.api.UserApi;
import com.mufcfintech.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserApi> createUser (@RequestBody UserApi userApi) {
        UserApi createdUser = userService.createUser(userApi);
        return ResponseEntity.ok(createdUser);
    }

    @GetMapping
    public ResponseEntity<List<UserApi>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserApi> getUser(@PathVariable("id") String id) {
        Optional<UserApi> userApi = userService.getUserById(id);
        if (userApi.isPresent()){
            return ResponseEntity.ok(userApi.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping
    public ResponseEntity<UserApi> upsertUser (@RequestBody UserApi userApi) {
        UserApi updatedUser = userService.upsertUser(userApi);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserApi> deleteUser (@PathVariable("id") String id) {
        Optional<UserApi> userApiOptional = userService.deleteUser(id);
        if(userApiOptional.isPresent()) {
            return ResponseEntity.ok(userApiOptional.get());
        } else  {
            return ResponseEntity.notFound().build();
        }
    }
}
