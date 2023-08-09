package com.MicroServiceArc.ticketservice.repository;

import com.MicroServiceArc.ticketservice.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,String> {
}
