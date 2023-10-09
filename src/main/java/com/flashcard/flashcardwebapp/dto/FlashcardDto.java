package com.flashcard.flashcardwebapp.dto;

import com.flashcard.flashcardwebapp.entity.Flashcard;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlashcardDto implements Serializable {
    private Long id;
    private String question;
    private String answer;
    private UserDto userDto;

    public FlashcardDto(Flashcard flashcard) {
        if (flashcard.getFlashcard_id() != null) {
            this.id = flashcard.getFlashcard_id();
        }
        if (flashcard.getQuestion() != null) {
            this.question = flashcard.getQuestion();
        }
        if (flashcard.getAnswer() != null) {
            this.answer = flashcard.getAnswer();
        }
    }

}
