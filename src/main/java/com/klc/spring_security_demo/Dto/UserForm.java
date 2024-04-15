package com.klc.spring_security_demo.Dto;

public record  UserForm (String firstName,
                         String lastName,
                         boolean active,
                         String password,
                         String email){
}
