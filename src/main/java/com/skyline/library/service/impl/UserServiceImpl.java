package com.skyline.library.service.impl;

import com.skyline.library.Enum.Role;
import com.skyline.library.entity.User;
import com.skyline.library.repository.UserRepository;
import com.skyline.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllMembers() {
        return userRepository.findByRole(Role.USER);
    }

    @Override
    public User getAllMembers(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

    @Override
    public void deleteUser(Long userId) {
return;
    }

    @Override
    public User updateUser(Long userId, User user) {
        return null;
    }
}
