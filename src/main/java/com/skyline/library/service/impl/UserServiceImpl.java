package com.skyline.library.service.impl;

import com.skyline.library.Enum.Role;
import com.skyline.library.entity.User;
import com.skyline.library.exception.NotFoundException;
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
    public User getUserById(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        return userOptional.orElseThrow(() -> new NotFoundException("User Not Found with Id :"+userId));

    }

    @Override

        public void deleteUser(Long userId) throws NotFoundException {
            if (!userRepository.existsById(userId)) {
                throw new NotFoundException("User Not Found with Id :"+userId);
            }

            userRepository.deleteById(userId);
        }


    @Override
    public User updateUser(Long userId, User user) throws NotFoundException {
        if (!userRepository.existsById(userId)) {
            throw new NotFoundException("User Not Found with Id :"+userId);
        }

        user.setId(userId);
        return userRepository.save(user);
    }

    @Override
    public List<User> searchUsersByName(String name) {
        return userRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public User getUserByEmail(String email) throws NotFoundException {
        Optional<User> userOptional = userRepository.findByEmail(email);
        return userOptional.orElseThrow(() -> new NotFoundException("User not found with email: " + email));

    }

}
