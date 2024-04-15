package com.klc.spring_security_demo.securityImpl.service;

import com.klc.spring_security_demo.model.User;
import com.klc.spring_security_demo.securityImpl.model.UserAuth;
import com.klc.spring_security_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserAuthService implements UserDetailsService {

   @Autowired
   UserService userService;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = userService.findByEmail(email);
        if(user.isEmpty()) throw new UsernameNotFoundException("Incorrect credentials");
        return new UserAuth(user.get());
    }
}
