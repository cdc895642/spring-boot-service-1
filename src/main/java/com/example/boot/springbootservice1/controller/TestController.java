package com.example.boot.springbootservice1.controller;

import com.example.boot.springbootservice1.UserService;
import com.example.boot.springbootservice1.dto.User;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class TestController {

  @Autowired
  private UserService userService;

  @GetMapping("/")
  public User getUser() {
    log.info("main date - {}"+ new Date());
    return new User("name");
  }

  @GetMapping("/long")
  public User getLong() throws InterruptedException {
    log.info("main date - {}"+ new Date());
    return userService.getUser(Thread.currentThread().getName());
  }

  @GetMapping("/other")
  public User getOtherUser(){
    RestTemplate restTemplate = new RestTemplate();
    String fooResourceUrl
        = "http://demo-backend2:8092/";
    ResponseEntity<String> response
        = restTemplate.getForEntity(fooResourceUrl, String.class, new Object[0]);
    log.info("other time - {}"+new Date());
    throw new RuntimeException("this is an exception");
//    return new User(response.getBody());
  }
}
