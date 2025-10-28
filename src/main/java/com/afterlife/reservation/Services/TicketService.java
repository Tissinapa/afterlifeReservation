package com.afterlife.reservation.Services;

import com.afterlife.reservation.Entities.TicketEntity;

import java.util.List;

public interface TicketService {
    TicketEntity buyTicket(TicketEntity ticketEntity);
    TicketEntity buyTicketForOther(TicketEntity ticketEntity);
    List<TicketEntity> fetchTickets();
    void deleteTicket(Long ticketId);



}
