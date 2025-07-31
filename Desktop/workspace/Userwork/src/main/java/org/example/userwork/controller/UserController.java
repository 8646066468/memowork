package org.example.userwork.controller;

import lombok.RequiredArgsConstructor;
import org.example.userwork.dto.UserRequest;
import org.example.userwork.dto.UserResponse;
import org.example.userwork.repository.UserRepository;
import org.example.userwork.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    // 생성
    @PostMapping("/users")
    public UserResponse save(
            @RequestBody UserRequest userRequest
    ) {
        return userService.save(userRequest);
    }

    //단건 조회
    @GetMapping("/user/{userId}")
    public UserResponse getUser(@PathVariable("userId") Long userId) {
        return userService.getUser(userId);
    }
    //전체 조회
    @GetMapping("/users")
    public List<UserResponse> getAllUsers() {
        return userService.getUsers();
    }

    //단건 수정
    @PutMapping("/user/{userId}")
    public UserResponse updateUser(
            @PathVariable Long userId,
            @RequestBody UserRequest userRequest
    ) {
        return userService.updateUser(userId, userRequest);
    }

    @DeleteMapping("/user/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }


}



