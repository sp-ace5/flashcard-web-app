package com.flashcard.flashcardwebapp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.flashcard.flashcardwebapp.dto.FlashcardDto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Flashcards")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Flashcard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long flashcard_id;

    @Column(columnDefinition = "text")
    private String question;

    @Column(columnDefinition = "text")
    private String answer;

    @ManyToOne
    @JsonBackReference
    private User user;

    public Flashcard(FlashcardDto flashcardDto) {
        if (flashcardDto.getQuestion() != null) {
            this.question = flashcardDto.getQuestion();
        }
    }

}
