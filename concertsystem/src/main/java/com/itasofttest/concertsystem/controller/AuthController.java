package com.itasofttest.concertsystem.controller;

import com.itasofttest.concertsystem.jwt.JwtResponse;
import com.itasofttest.concertsystem.model.Auth;
import com.itasofttest.concertsystem.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;
    private static final String SECRET = "CONCERT_API"; // Add this line

    @PostMapping("/login")
public ResponseEntity<?> login(@RequestBody Auth auth) {
    Auth authenticatedUser = authService.authenticate(auth.getUsername(), auth.getPassword());
    if (authenticatedUser != null) {
        String token = Jwts.builder()
            .setSubject(authenticatedUser.getUsername())
            .setExpiration(new Date(System.currentTimeMillis() + 600000 ))
            .signWith(SignatureAlgorithm.HS512, SECRET)
            .compact();
        return ResponseEntity.ok(new JwtResponse(token));
    }
    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
}

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Auth auth) {
        Auth newUser = authService.register(auth);
        if (newUser != null) {
            return ResponseEntity.ok("User " + auth.getUsername() + " registered successfully.");
        }
        return ResponseEntity.badRequest().build();
    }
}
