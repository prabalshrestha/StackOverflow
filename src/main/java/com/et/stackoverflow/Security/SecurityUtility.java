package com.et.stackoverflow.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.security.SecureRandom;

@Component
public class SecurityUtility {
    private static final String SALT = "salt"; // Salt should be protected carefully

    @Bean

    public static BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12, new SecureRandom( SALT.getBytes()))	;

    }

}
