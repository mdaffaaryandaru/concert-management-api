package com.itasofttest.concertsystem.controller;

import com.itasofttest.concertsystem.model.Ticket;
import com.itasofttest.concertsystem.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/ticket")
public class TicketController {
    //Hubungkan TicketController dengan TicketService
    @Autowired
    private TicketService ticketService;
    //Buat method untuk membuat ticket baru
    @PostMapping("/create")
    public String createTicket(@RequestBody Ticket ticket){
    ticketService.saveTicket(ticket);
    return "Ticket created";
    }
    //Buat method untuk mendapatkan semua ticket
    @GetMapping("/getAll")
    public List<Ticket> getAllTickets(){
        return ticketService.getAllTickets();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTicket(@PathVariable int id){
        ticketService.deleteTicket(id);
        return ResponseEntity.ok("Ticket with id " + id + " has been deleted successfully.");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateTicket(@PathVariable int id, @RequestBody Ticket ticket){
        ticketService.updateTicket(id, ticket);
        return ResponseEntity.ok("Ticket with id " + id + " has been updated successfully.");
    }
    @GetMapping("/getById/{id}")
    public ResponseEntity<?> getTicketById(@PathVariable int id) {
        Ticket ticket = ticketService.getTicketById(id);
        if (ticket != null) {
            return ResponseEntity.ok(ticket);
        } else {
            return ResponseEntity.status(404).body("Ticket with id " + id + " not found.");
        }
    }
}
