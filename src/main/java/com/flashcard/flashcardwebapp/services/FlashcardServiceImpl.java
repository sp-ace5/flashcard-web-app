package com.flashcard.flashcardwebapp.services;

import com.flashcard.flashcardwebapp.dtos.FlashcardDto;
import com.flashcard.flashcardwebapp.repositories.FlashcardRepository;
import com.flashcard.flashcardwebapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class FlashcardServiceImpl implements FlashcardService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FlashcardRepository flashcardRepository;

    @Override
    public List<FlashcardDto> getAllFlashcardByUserId(Long userId) {
        return null;
    }

    @Override
    public void addFlashcard(FlashcardDto FlashcardDto, Long userId) {

    }

    @Override
    public void deleteFlashcardById(Long noteId) {

    }


    @Override
    public void updateFlashcardById(FlashcardDto flashcardDto) {

    }

    @Override
    public Optional<FlashcardDto> getFlashcardById(Long noteId) {
        return Optional.empty();
    }
}
