package com.itasofttest.concertsystem.repository;

import com.itasofttest.concertsystem.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
//Hubungkan TicketRepository dengan database
public interface TicketRepository extends JpaRepository<Ticket, Integer> {

}
