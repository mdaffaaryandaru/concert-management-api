package com.itasofttest.concertsystem.repository;

import com.itasofttest.concertsystem.model.Auth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends JpaRepository <Auth, Integer> {
    Auth findByUsername(String username);
}
