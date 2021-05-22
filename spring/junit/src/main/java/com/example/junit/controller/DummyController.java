package com.example.junit.controller;

import com.example.junit.model.Dummy;
import com.example.junit.service.DummyService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("dummy")
public class DummyController {

  DummyService dummyService;

  public DummyController(DummyService dummyService) {
    this.dummyService = dummyService;
  }

  @GetMapping("/{id}")
  public Dummy getDummy(@PathVariable Integer id) {
    return dummyService.getDummyById(id);
  }
}
