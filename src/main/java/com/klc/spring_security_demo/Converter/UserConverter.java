package com.klc.spring_security_demo.Converter;

import com.klc.spring_security_demo.Dto.UserForm;
import com.klc.spring_security_demo.model.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserConverter {

    static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    public static User toUser(UserForm userForm) {
        return new User(userForm.firstName(),
                        userForm.lastName(),
                        userForm.email(),
                        bCryptPasswordEncoder.encode(userForm.password()),
                        userForm.active());
    }
}
