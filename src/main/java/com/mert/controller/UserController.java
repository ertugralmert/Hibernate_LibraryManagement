package com.mert.controller;

import com.mert.entity.User;
import com.mert.service.UserService;
import com.mert.utility.ScannerQuestions;

public class UserController {

    private final UserService userService;

    public UserController() {
        this.userService = new UserService();
    }

    public User save(){
        String username = ScannerQuestions.stringDegerAlma("lütfen kullanıcı adınızı giriniz");
        String password = ScannerQuestions.stringDegerAlma("lütfen sifrenizi giriniz");
        User user = User.builder()
                .username(username)
                .password(password)
                .build();
        return userService.save(user);
    }

    public User login(){
        String username = ScannerQuestions.stringDegerAlma("lütfen kullanıcı adınızı giriniz");
        String password = ScannerQuestions.stringDegerAlma("lütfen sifrenizi giriniz");
        return userService.findByUsernameAndPassword(username, password);
    }

}
