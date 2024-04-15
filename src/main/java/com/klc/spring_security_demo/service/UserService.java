package com.klc.spring_security_demo.service;

import com.klc.spring_security_demo.Repository.UserRepository;
import com.klc.spring_security_demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    final
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public int save(User user){
        return userRepository.save(user).getId();
    }
}
