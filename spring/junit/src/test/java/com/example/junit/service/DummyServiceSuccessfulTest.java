package com.example.junit.service;

import com.example.junit.model.Dummy;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Tag("DummyService")
public class DummyServiceSuccessfulTest {

  @Autowired
  DummyService dummyService;

  @ParameterizedTest
  @ValueSource(ints = {1, 2})
  void testGettingDummySuccessfully(int id) {
    Dummy dummy = dummyService.getDummyById(id);
    assertEquals(id, dummy.getId());
  }
}
