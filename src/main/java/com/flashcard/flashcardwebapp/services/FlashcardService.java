package com.flashcard.flashcardwebapp.services;
import com.flashcard.flashcardwebapp.dtos.FlashcardDto;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;


public interface FlashcardService {
    List<FlashcardDto> getAllFlashcardByUserId(Long userId);

    @Transactional
    void addFlashcard(FlashcardDto FlashcardDto, Long userId);

    @Transactional
    void deleteFlashcardById(Long noteId);

    @Transactional
    void updateFlashcardById(FlashcardDto flashcardDto);

    Optional<FlashcardDto> getFlashcardById(Long noteId);
}
