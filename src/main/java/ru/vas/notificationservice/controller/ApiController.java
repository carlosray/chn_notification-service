package ru.vas.notificationservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class ApiController {

    @GetMapping
    public ResponseEntity<String> getMessage(@Value("${greeting.message}") String message) {
        return ResponseEntity.ok(message);
    }

}
