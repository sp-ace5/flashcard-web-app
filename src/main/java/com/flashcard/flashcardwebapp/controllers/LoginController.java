package com.flashcard.flashcardwebapp.controllers;

import com.flashcard.flashcardwebapp.dto.UserDto;
import com.flashcard.flashcardwebapp.entity.User;
import com.flashcard.flashcardwebapp.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class LoginController {
    private UserService userService;

    @PostMapping("api/login")
    public List<String> userLogin(@RequestBody UserDto userDto){
        return userService.userLogin(userDto);
    }
}
