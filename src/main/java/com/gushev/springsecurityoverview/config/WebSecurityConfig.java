package com.gushev.springsecurityoverview.config;

import com.gushev.springsecurityoverview.security.filters.EmailPasswordAuthFilter;
import com.gushev.springsecurityoverview.security.providers.EmailPasswordAuthenticationProvider;
import com.gushev.springsecurityoverview.security.providers.OtpAuthenticationProvider;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  private final EmailPasswordAuthenticationProvider emailPasswordAuthenticationProvider;
  private final OtpAuthenticationProvider otpAuthenticationProvider;

  @Bean
  @Override
  protected AuthenticationManager authenticationManager() throws Exception {
    return super.authenticationManager();
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.authenticationProvider(emailPasswordAuthenticationProvider)
        .authenticationProvider(otpAuthenticationProvider);
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.addFilterAt(emailPasswordAuthFilter(), BasicAuthenticationFilter.class);
  }

  @Bean
  @SneakyThrows
  public EmailPasswordAuthFilter emailPasswordAuthFilter() {
    return new EmailPasswordAuthFilter(authenticationManager());
  }
}
