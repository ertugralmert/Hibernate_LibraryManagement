package com.mert.service;

import com.mert.entity.User;
import com.mert.repository.UserRepository;

import java.util.Optional;

public class UserService {
    private final UserRepository userRepository;

    public UserService(){
        this.userRepository=new UserRepository();
    }

    public User save(User user){
        return userRepository.save(user);
    }

    public User findByUsernameAndPassword(String username, String password){
        Optional<User>  user = userRepository.findByUsernameAndPassword(username, password);
        if (user.isEmpty()) {
            throw new RuntimeException("Kullanıcı bulunnamadı");
        }
        return user.get();
    }
}
