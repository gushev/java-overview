package com.gushev.springsecurityoverview.security.providers;

import com.gushev.springsecurityoverview.security.JpaUserDetailsService;
import com.gushev.springsecurityoverview.security.authentications.EmailPasswordAuthentication;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailPasswordAuthenticationProvider implements AuthenticationProvider {

  private final JpaUserDetailsService userDetailsService;
  private final PasswordEncoder passwordEncoder;

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    String username = authentication.getName();
    String password = (String) authentication.getCredentials();
    UserDetails user = userDetailsService.loadUserByUsername(username);

    if (passwordEncoder.matches(password, user.getPassword())) {
      return new EmailPasswordAuthentication(username, password, user.getAuthorities());
    }

    throw new BadCredentialsException("Bad creds");
  }

  @Override
  public boolean supports(Class<?> aClass) {
    return EmailPasswordAuthentication.class.isAssignableFrom(aClass);
  }
}
