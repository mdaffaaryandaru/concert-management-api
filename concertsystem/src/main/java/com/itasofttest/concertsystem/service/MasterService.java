package com.itasofttest.concertsystem.service;

import com.itasofttest.concertsystem.model.Master;

import java.util.List;

public interface MasterService {
    // Method to register a new user
    public List<Master> getAllMaster();

    public Master saveMaster(Master master);

    // Method to authenticate a user
}