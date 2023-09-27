package com.flashcard.flashcardwebapp.service;

import com.flashcard.flashcardwebapp.entity.Flashcard;
import com.flashcard.flashcardwebapp.repositories.FlashcardRepository;
import com.flashcard.flashcardwebapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlashcardServiceImpl implements FlashcardService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FlashcardRepository flashcardRepository;

    @Override
    public List<Flashcard> getAllFlashcards() {
        return null;
    }
}
