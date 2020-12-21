package com.gushev.springsecurityoverview.security.filters;

import com.gushev.springsecurityoverview.security.authentications.EmailOtpAuthentication;
import com.gushev.springsecurityoverview.security.authentications.EmailPasswordAuthentication;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
public class EmailPasswordAuthFilter extends OncePerRequestFilter {

  private final AuthenticationManager authenticationManager;

  @Override
  protected void doFilterInternal(
      HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {

    String email = request.getHeader("email");
    String password = request.getHeader("password");
    String otp = request.getHeader("otp");
    Authentication auth = null;

    if (otp == null) {
      auth = new EmailPasswordAuthentication(email, password);
      auth = authenticationManager.authenticate(auth);
    } else {
      auth = new EmailOtpAuthentication(email, otp);
      auth = authenticationManager.authenticate(auth);
      SecurityContextHolder.getContext().setAuthentication(auth);
    }

  }

  @Override
  protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
    return !request.getServletPath().equals("/login");
  }
}
