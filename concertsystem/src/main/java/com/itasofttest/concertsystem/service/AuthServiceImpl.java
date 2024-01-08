package com.itasofttest.concertsystem.service;

import com.itasofttest.concertsystem.model.Auth;
import com.itasofttest.concertsystem.repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthRepository authRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Auth register(Auth auth) {
        auth.setPassword(passwordEncoder.encode(auth.getPassword()));
        return authRepository.save(auth);
    }

    @Override
    public Auth authenticate(String username, String password) {
        Auth auth = authRepository.findByUsername(username);
        if (auth != null && passwordEncoder.matches(password, auth.getPassword())) {
            return auth;
        }
        return null;
    }
}