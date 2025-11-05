package com.afterlife.reservation.Services;

import com.afterlife.reservation.Entities.TicketEntity;
import com.afterlife.reservation.Repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService{

    private final TicketRepository ticketRepository;

    @Autowired
    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }


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
