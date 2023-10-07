package com.skyline.library.controller;

import com.skyline.library.entity.User;
import com.skyline.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/allmembers")
    public List<User> getAllMembers() {
        return userService.getAllMembers();
    }

    @PostMapping("/addmember/{user}")
    public User addMember(@RequestBody User user) {
        return userService.getAllMembers(user);

    }

    @GetMapping("/{userId}")
    public Optional<User> getUserById(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }

    // Update a user by ID
    @PutMapping("/{userId}")
    public User updateUser(@PathVariable Long userId, @RequestBody User user) {
        return userService.updateUser(userId, user);
    }

    // Delete a user by ID
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }
}
