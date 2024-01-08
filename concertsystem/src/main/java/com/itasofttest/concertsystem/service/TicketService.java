package com.itasofttest.concertsystem.service;

import com.itasofttest.concertsystem.model.Ticket;

import java.util.List;

public interface TicketService {
    //method untuk menyimpan ticket baru
    public Ticket saveTicket(Ticket ticket);
    //method untuk mendapatkan semua ticket
    public List<Ticket> getAllTickets();
    //method untuk menghapus ticket
    void deleteTicket(int id);
    //method untuk mengupdate ticket
    public Ticket updateTicket(int id, Ticket ticket);

    public Ticket getTicketById(int id);



}
