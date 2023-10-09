package com.flashcard.flashcardwebapp.repositories;

import com.flashcard.flashcardwebapp.entity.Flashcard;
import com.flashcard.flashcardwebapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlashcardRepository extends JpaRepository<Flashcard, Long> {
    List<Flashcard> findAllByUserEquals(User user);

}
