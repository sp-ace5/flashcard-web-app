package com.flashcard.flashcardwebapp.service;

import com.flashcard.flashcardwebapp.entity.Flashcard;
import com.flashcard.flashcardwebapp.repositories.FlashcardRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface FlashcardService {
    private final FlashcardRepository flashcardRepository;

    @Autowired
    public FlashcardService(FlashcardRepository flashcardRepository) {
        this.flashcardRepository = flashcardRepository;
    }

    public List<Flashcard> getAllFlashcards() {
        return flashcardRepository.findAll();
    }
}
