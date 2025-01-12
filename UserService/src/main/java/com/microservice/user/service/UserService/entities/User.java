package com.microservice.user.service.UserService.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "ID", nullable = false, length = 36)
    private String userId;

    @Column(name = "NAME", nullable = false, length = 100) 
    private String name;

    @Column(name = "EMAIL", nullable = false, unique = true, length = 150) 
    private String email;

    @Column(name = "ABOUT", length = 500)
    private String about;
    
    //this will not save in database
    @Transient
    private List<Rating> ratings = new ArrayList<>();
    
}
