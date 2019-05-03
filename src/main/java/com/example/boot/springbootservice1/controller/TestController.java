package com.example.boot.springbootservice1.controller;

import com.example.boot.springbootservice1.dto.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

  @GetMapping("/")
  public User getUser() {
    return new User("name");
  }
}
