package com.itasofttest.concertsystem.service;

import com.itasofttest.concertsystem.model.Auth;

public interface AuthService {
    // Method to register a new user
    public Auth register(Auth auth);

    // Method to authenticate a user
    public Auth authenticate(String username, String password);
}