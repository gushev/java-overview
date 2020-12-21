package com.gushev.springsecurityoverview.security.providers;

import com.gushev.springsecurityoverview.entities.Otp;
import com.gushev.springsecurityoverview.security.authentications.EmailOtpAuthentication;
import com.gushev.springsecurityoverview.services.OtpService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OtpAuthenticationProvider implements AuthenticationProvider {

  private final OtpService otpService;
  private final UserDetailsService userDetailsService;

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    String username = authentication.getName();
    String otp = (String) authentication.getCredentials();

    UserDetails userDetails = userDetailsService.loadUserByUsername(username);
    Otp otpEntity = otpService.findByEmail(username);

    if (otpEntity.getOtp().equals(otp)) {
      return new EmailOtpAuthentication(username, otp, userDetails.getAuthorities());
    }

    throw new BadCredentialsException("Bad credentials");
  }

  @Override
  public boolean supports(Class<?> aClass) {
    return EmailOtpAuthentication.class.equals(aClass);
  }
}
