package com.flashcard.flashcardwebapp.dtos;

import com.flashcard.flashcardwebapp.entities.Flashcard;
import lombok.*;
import java.io.Serializable;
import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlashcardDto implements Serializable {
    private Long flashcard_id;
    private String frontOfCard;
    private String backOfCard;
    private UserDto userDto;

    public FlashcardDto(Flashcard flashcard) {
        if(flashcard.getFlashcard_id() != null) {
            this.flashcard_id = flashcard.getFlashcard_id();
        }
        if (flashcard.getFrontOfCard() != null) {
            this.frontOfCard = flashcard.getFrontOfCard();
        }
        if (flashcard.getBackOfCard() != null) {
            this.backOfCard = flashcard.getBackOfCard();
        }
    }
}
