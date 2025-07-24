package com.AuthService.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDE {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_generator")
    @SequenceGenerator(name = "user_generator", sequenceName = "user_s", allocationSize = 1)
    private long userId;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "mobile", unique = true)
    private String mobile;

    @Column(name = "emailId", unique = true)
    private String emailId;

    @Column(name = "userType")
    private String userType;

    @Column(name = "password")
    private String password;
}
