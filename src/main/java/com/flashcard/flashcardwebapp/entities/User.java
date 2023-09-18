package com.flashcard.flashcardwebapp.entities;

import com.flashcard.flashcardwebapp.dtos.UserDto;
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
    private Long userId;

    @Column(unique = true)
    private Long username;

    @Column
    private String password;

    public User(UserDto userDto) {
        if (userDto.getUsername() != null) {
            this.username = Long.valueOf(userDto.getUsername());
        }
        if (userDto.getPassword() != null) {
            this.password = userDto.getPassword();
        }
    }
}


