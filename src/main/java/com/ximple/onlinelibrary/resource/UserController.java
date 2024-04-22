package com.ximple.onlinelibrary.resource;

import com.ximple.onlinelibrary.dto.UserDto;
import com.ximple.onlinelibrary.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getUsers() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{name}")
    public ResponseEntity<UserDto> getUserByName(@PathVariable String name) {
        return ResponseEntity.ok(userService.findByUsername(name));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserByName(@PathVariable Long id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @PostMapping
    public ResponseEntity<String> createUser(UserDto userDto) {
        userService.save(userDto);
        return ResponseEntity.ok("User created successfully!");
    }
}
