package com.gushev.springsecurityoverview.services;

import com.gushev.springsecurityoverview.entities.Otp;
import com.gushev.springsecurityoverview.repositories.OtpRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OtpService {

  private final OtpRepository otpRepository;

  public Otp findByEmail(String email) {
    return otpRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("cannot find otp"));
  }
}
