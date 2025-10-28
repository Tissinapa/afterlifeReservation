package com.afterlife.reservation.Services;

import com.afterlife.reservation.Entities.TicketEntity;
import com.afterlife.reservation.Repositories.TicketRepository;

import java.util.List;

public class TicketServiceImpl implements TicketService{

    private TicketRepository ticketRepository;

    @Override
    public TicketEntity buyTicket(TicketEntity ticket){
        return ticketRepository.save(ticket);
    }

    @Override
    public TicketEntity buyTicketForOther(TicketEntity ticket){
        return ticketRepository.save(ticket);
    }
    @Override
    public List<TicketEntity> fetchTickets(){
        return (List<TicketEntity>) ticketRepository.findAll();
    }

    @Override
    public void deleteTicket(Long ticketId){
        ticketRepository.deleteById(ticketId);
    }


}
