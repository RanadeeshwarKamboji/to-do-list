package com.rk_group.springboot.to_do_list.services;

import org.springframework.stereotype.Service;

@Service
public class LoginAuthenticationService {

    public boolean AuthenticateUserNameAndPassword(String username, String password){
        boolean isNameValid = username.equalsIgnoreCase("Rana");
        boolean isPasswordValid = password.equalsIgnoreCase("admin");
        return isPasswordValid && isNameValid;
    }
}
