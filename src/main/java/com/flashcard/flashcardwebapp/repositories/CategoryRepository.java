package com.flashcard.flashcardwebapp.repositories;

import com.flashcard.flashcardwebapp.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
