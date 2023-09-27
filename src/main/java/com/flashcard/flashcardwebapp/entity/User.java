package com.flashcard.flashcardwebapp.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.flashcard.flashcardwebapp.dto.UserDto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    @Column
    private String password;

    public User(UserDto userDto) {
        if (userDto.getUsername() != null) {
            this.username= userDto.getUsername();
        }
        if (userDto.getPassword() != null) {
            this.password = userDto.getPassword();
        }
    }

}


