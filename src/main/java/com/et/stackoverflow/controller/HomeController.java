package com.et.stackoverflow.controller;

import com.et.stackoverflow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    @Autowired
    private UserService userService;


}
