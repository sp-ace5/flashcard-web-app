package com.flashcard.flashcardwebapp.repositories;

import com.flashcard.flashcardwebapp.entities.Flashcard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlashcardRepository extends JpaRepository<Flashcard, Long> {

}
