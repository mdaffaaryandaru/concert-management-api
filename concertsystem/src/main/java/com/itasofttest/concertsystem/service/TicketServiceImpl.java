package com.itasofttest.concertsystem.service;

import com.itasofttest.concertsystem.model.Ticket;
import com.itasofttest.concertsystem.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//ticketServieImpl terhubung dengan TicketService
//TicketServiceImpl terhubung dengan TicketRepository yang terhubung dengan database
@Service
public class TicketServiceImpl implements TicketService{
        //Hubungkan TicketServiceImpl dengan TicketRepository
        @Autowired
        private TicketRepository ticketRepository;
        //Buat method untuk menyimpan ticket baru
        @Override
        public Ticket saveTicket(Ticket ticket) {
            return ticketRepository.save(ticket);
        }
        //Buat method untuk mendapatkan semua ticket
        @Override
        public List<Ticket> getAllTickets() {
            return ticketRepository.findAll();
        }

        @Override
        public void deleteTicket(int id) {
            ticketRepository.deleteById(id);
        }

        @Override
        public Ticket updateTicket(int id, Ticket ticket) {
            Ticket existingTicket = ticketRepository.findById(id).orElse(null);
            existingTicket.setBuyer_name(ticket.getBuyer_name());
            existingTicket.setBuyer_email(ticket.getBuyer_email());
            existingTicket.setBuyer_phone(ticket.getBuyer_phone());
            existingTicket.setConcert_name(ticket.getConcert_name());
            return ticketRepository.save(existingTicket);
        }
        @Override
        public Ticket getTicketById(int id) {
            return ticketRepository.findById(id).orElse(null);
}
}
