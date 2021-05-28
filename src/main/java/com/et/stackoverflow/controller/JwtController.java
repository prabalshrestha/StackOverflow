package com.et.stackoverflow.controller;

import com.et.stackoverflow.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class JwtController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/")
    public String welcome()
    {
        return "Welcome to javatechie!!";
    }

/*    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest)
    {

    }*/
}
