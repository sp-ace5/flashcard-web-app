package com.flashcard.flashcardwebapp.entity;

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

    public void setId(Long id) {
        this.flashcard_id = id;
    }

}
