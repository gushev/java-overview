package com.example.junit.service;

import com.example.junit.model.Dummy;
import org.springframework.stereotype.Service;

@Service
public class DummyService {

  public Dummy getDummyById(Integer id) {
    return new Dummy(id, "Test Dummy");
  }
}
