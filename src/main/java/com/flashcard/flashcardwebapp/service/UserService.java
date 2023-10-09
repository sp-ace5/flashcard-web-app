package com.flashcard.flashcardwebapp.service;

import com.flashcard.flashcardwebapp.dto.UserDto;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface UserService {
    @Transactional
    List<String> addUser(UserDto userDto);

    List<String> userLogin(UserDto userDto);
}
