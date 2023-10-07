package com.skyline.library.service;

import com.skyline.library.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllMembers();

    User getAllMembers(User user);

    Optional<User> getUserById(Long userId);

    void deleteUser(Long userId);

    User updateUser(Long userId, User user);
}
