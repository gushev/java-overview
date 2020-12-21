package com.gushev.springsecurityoverview.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Otp {

  @Id
  private String email;

  private String otp;
}
