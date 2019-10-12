package com.security;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class LoginUser {

    private String username;
    private String password;
}
