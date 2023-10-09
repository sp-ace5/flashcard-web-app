package com.flashcard.flashcardwebapp.service;

import com.flashcard.flashcardwebapp.dto.FlashcardDto;
import jakarta.transaction.Transactional;
import java.util.List;

public interface FlashcardService {
    List<FlashcardDto> getAllFlashcardsByUserId(Long userId);

    @Transactional
    void addFlashcard(FlashcardDto flashcardDto, Long userId);

    @Transactional
    void deleteFlashcardById(Long FlashcardId);

    @Transactional
    void updateFlashcardById(FlashcardDto flashcardDto);

}
