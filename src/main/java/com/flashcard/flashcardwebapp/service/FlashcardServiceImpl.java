package com.flashcard.flashcardwebapp.service;

import com.flashcard.flashcardwebapp.dto.FlashcardDto;
import com.flashcard.flashcardwebapp.entity.Flashcard;
import com.flashcard.flashcardwebapp.entity.User;
import com.flashcard.flashcardwebapp.repositories.FlashcardRepository;
import com.flashcard.flashcardwebapp.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FlashcardServiceImpl implements FlashcardService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FlashcardRepository flashcardRepository;

    @Override
    public void addFlashcard(FlashcardDto flashcardDto, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User with ID " + userId + " not found"));
        Flashcard flashcard = new Flashcard();
        flashcard.setQuestion(flashcardDto.getQuestion());
        flashcard.setAnswer(flashcardDto.getAnswer());
        flashcard.setUser(user);
        flashcardRepository.save(flashcard);
    }

    @Override
    public List<FlashcardDto> getAllFlashcardsByUserId(Long userId) {
        return userRepository.findById(userId)
                .map(user -> flashcardRepository.findAllByUserEquals(user)
                        .stream()
                        .map(FlashcardDto::new)
                        .collect(Collectors.toList())
                )
                .orElse(Collections.emptyList());
    }

    @Override
    public void deleteFlashcardById(Long flashcardId) {
        if (!flashcardRepository.existsById(flashcardId)) {
            throw new EntityNotFoundException("Flashcard with ID " + flashcardId + " not found");
        }
        flashcardRepository.deleteById(flashcardId);
    }

    @Override
    public void updateFlashcardById(FlashcardDto flashcardDto) {
        Optional<Flashcard> flashcardOptional = flashcardRepository.findById(flashcardDto.getId());
        flashcardOptional.ifPresent(flashcard -> {
            flashcard.setQuestion(flashcardDto.getQuestion());
            flashcard.setAnswer(flashcardDto.getAnswer());
            flashcardRepository.saveAndFlush(flashcard);
        });
    }
}
