package com.gushev.springsecurityoverview.repositories;

import com.gushev.springsecurityoverview.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
  Optional<User> findUserByEmail(String email);
}
