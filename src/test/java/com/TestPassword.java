package com;

import org.junit.Test;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class TestPassword {

    @Test
    public void getPass(){
        getPasswordHash();

    }

    @Bean
    public PasswordEncoder getPasswordHash(){
        PasswordEncoder pe = new BCryptPasswordEncoder();
        System.out.println(pe.encode("user"));
        return new BCryptPasswordEncoder();
    }
}
