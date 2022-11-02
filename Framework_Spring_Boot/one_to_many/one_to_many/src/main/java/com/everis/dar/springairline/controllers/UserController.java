package com.everis.dar.springairline.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everis.dar.springairline.entities.User;
import com.everis.dar.springairline.services.UserService;



@RestController
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public List <User> findAll(){

        return userService.findAll();
    }
}