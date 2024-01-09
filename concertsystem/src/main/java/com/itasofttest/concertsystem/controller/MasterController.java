package com.itasofttest.concertsystem.controller;

import com.itasofttest.concertsystem.model.Master;
import com.itasofttest.concertsystem.service.MasterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;




@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/master")
public class MasterController {

    @Autowired
    private MasterService masterService;

    @GetMapping("/getAllMaster")
    public List<Master> getAllMaster() {
        return masterService.getAllMaster();
    }

     @PostMapping("/create")
    public String createTicket(@RequestBody Master master){
    masterService.saveMaster(master);
    return "Master Created";
    }
    
}
