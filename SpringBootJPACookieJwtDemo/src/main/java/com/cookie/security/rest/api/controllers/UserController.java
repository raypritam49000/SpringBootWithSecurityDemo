package com.cookie.security.rest.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cookie.security.rest.api.models.UserProfile;
import com.cookie.security.rest.api.services.UserService;

@RestController
@RequestMapping("/profile")
public class UserController {
	
    @Autowired
    private UserService userService;

    @GetMapping("/me")
    public ResponseEntity<UserProfile> me() {
        return ResponseEntity.ok(userService.getUserProfile());
    }
}
