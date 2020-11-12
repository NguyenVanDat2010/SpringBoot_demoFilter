package com.example.filter.controller;

import com.example.filter.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/users")
public class UserController {
    private final static Logger LOG = LoggerFactory.getLogger(UserController.class);

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(@ModelAttribute User user){
        LOG.info("-----Fetching all users-----");
        List<User> users = Arrays.asList(
                new User(UUID.randomUUID().toString(), "User1", "John"),
                new User(UUID.randomUUID().toString(), "User2", "Smith"),
                new User(UUID.randomUUID().toString(), "User3", "Anna")
        );
        System.out.println(users.size());
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
