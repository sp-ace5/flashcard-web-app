package com.flashcard.flashcardwebapp.dtos;

import com.flashcard.flashcardwebapp.entities.User;
import lombok.*;
import java.io.Serializable;
import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Serializable {
    private Long userId;
    private String username;
    private String password;
    private Set<FlashcardDto> flashcardDtoSet = new HashSet<>();

    public UserDto(User user) {
        if(user.getUserId() != null) {
            this.userId = user.getUserId();
        }
        if (user.getUsername() != null) {
            this.username = String.valueOf(user.getUsername());
        }
        if (user.getPassword() != null) {
            this.password = user.getPassword();
        }
    }
}
