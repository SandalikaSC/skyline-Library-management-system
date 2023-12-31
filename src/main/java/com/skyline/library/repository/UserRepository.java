package com.skyline.library.repository;

import com.skyline.library.Enum.Role;
import com.skyline.library.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository <User,Long> {


    List<User> findByRole(Role role);

    List<User> findByNameContainingIgnoreCase(String name);
    Optional<User> findByEmail(String email);
}
