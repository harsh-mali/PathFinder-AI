package com.Pathfinder.AI.Pathfinder.controller;

import com.Pathfinder.AI.Pathfinder.controller.auth.AuthenticationRequest;
import com.Pathfinder.AI.Pathfinder.controller.auth.AuthenticationResponse;
import com.Pathfinder.AI.Pathfinder.controller.auth.RegisterRequest;
import com.Pathfinder.AI.Pathfinder.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(service.authenticate(request));
    }
}