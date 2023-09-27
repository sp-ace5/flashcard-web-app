package com.flashcard.flashcardwebapp.controllers;

import com.flashcard.flashcardwebapp.entity.Flashcard;
import com.flashcard.flashcardwebapp.repositories.FlashcardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FlashcardController {
    @Autowired
    private FlashcardRepository flashcardRepository;

    @PostMapping("/save-flashcards")
    public ResponseEntity<Flashcard> saveFlashcard(@RequestBody Flashcard flashcard) {
        Flashcard savedFlashcard = flashcardRepository.save(flashcard);
        return ResponseEntity.ok(savedFlashcard);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Flashcard>> getAllFlashcards() {
        List<Flashcard> flashcards = flashcardRepository.findAll();
        return ResponseEntity.ok(flashcards);
    }

}