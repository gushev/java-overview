package com.gushev.springsecurityoverview.services;

import com.gushev.springsecurityoverview.entities.User;
import com.gushev.springsecurityoverview.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;

  public User findByEmail(String email) {
    return userRepository
        .findUserByEmail(email)
        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
  }
}
