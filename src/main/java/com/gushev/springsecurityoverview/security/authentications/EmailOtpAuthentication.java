package com.gushev.springsecurityoverview.security.authentications;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class EmailOtpAuthentication extends UsernamePasswordAuthenticationToken {
  public EmailOtpAuthentication(Object principal, Object credentials) {
    super(principal, credentials);
  }

  public EmailOtpAuthentication(
      Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
    super(principal, credentials, authorities);
  }
}
