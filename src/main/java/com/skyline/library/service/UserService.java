package com.skyline.library.service;

import com.skyline.library.entity.User;
import com.skyline.library.exception.NotFoundException;

import java.util.List;

public interface UserService {
    List<User> getAllMembers();

    User getAllMembers(User user);

    User getUserById(Long userId) throws NotFoundException;

    void deleteUser(Long userId) throws NotFoundException;

    User updateUser(Long userId, User user) throws NotFoundException;

    List<User> searchUsersByName(String name);
    User getUserByEmail(String email) throws NotFoundException;
}
