package com.snapsquads.api.controllers;

import com.snapsquads.api.domains.user.User;
import com.snapsquads.api.domains.user.UserDTO;
import com.snapsquads.api.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody UserDTO userDTO){
        User newUser = this.userService.insert(userDTO);
        return ResponseEntity.ok().body(newUser);
    }
}
