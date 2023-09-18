package com.flashcard.flashcardwebapp.entities;

import com.flashcard.flashcardwebapp.dtos.FlashcardDto;
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
    private String frontOfCard;

    @Column(columnDefinition = "text")
    private String backOfCard;

    public Flashcard(FlashcardDto flashcardDto) {
        if(flashcardDto.getFrontOfCard() != null) {
            this.frontOfCard = flashcardDto.getFrontOfCard();
        }
        if(flashcardDto.getBackOfCard() != null) {
            this.backOfCard = flashcardDto.getBackOfCard();
        }
    }
}
