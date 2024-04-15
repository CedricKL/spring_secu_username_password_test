package com.klc.spring_security_demo.Controller;

import com.klc.spring_security_demo.Converter.UserConverter;
import com.klc.spring_security_demo.Dto.UserForm;
import com.klc.spring_security_demo.model.User;
import com.klc.spring_security_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class SimpleController {

    private final String HOME_MESSAGE = "This is our home page :)";
    private final String WELCOME_MESSAGE = "Welcome to our app !";

    @Autowired
    UserService userService;

    @GetMapping("/home")
    public String home(){ return HOME_MESSAGE; }

    @GetMapping("/user")
    public String user(Principal principal){
        return "this is your email: " + principal.getName() + "\n" + WELCOME_MESSAGE;
    }

    @PostMapping("/createUser")
    public int createUser(@RequestBody UserForm user){
        return userService.save(UserConverter.toUser(user));
    }
}
