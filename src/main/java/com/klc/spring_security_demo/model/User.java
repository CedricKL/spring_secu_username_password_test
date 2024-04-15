package com.klc.spring_security_demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
@Data
@Table(name = "app_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotEmpty
    private final String firstName;

    @NotEmpty
    private final String lastName;

    @Email
    @Column(unique = true)
    private final String email;

    @Size(min = 12)
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=]).+$",
             message = "The password should have at least: a capital letter, a special character and a number!")
    private final String password;

    @NotNull
    private final boolean active;

}
