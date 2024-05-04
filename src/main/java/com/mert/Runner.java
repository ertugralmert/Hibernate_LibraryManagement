package com.mert;

import com.mert.controller.UserController;
import com.mert.entity.User;

public class Runner {
    public static void main(String[] args) {
        UserController userController = new UserController();
        System.out.println(userController.save());
        System.out.println(userController.login());
    }
}
