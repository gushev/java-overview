package com.gushev.springsecurityoverview.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String email;

  private String password;
}
