package com.afterlife.reservation.Services;

import com.afterlife.reservation.Entities.TicketEntity;
import com.afterlife.reservation.Repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TicketServiceImpl implements TicketService{

    private final TicketRepository ticketRepository;
    //private final PriceService priceService;

    @Autowired
    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
        //this.priceService = priceService;
    }


    @Override
    public TicketEntity buyTicket(TicketEntity ticket){

        /*BigDecimal calculatePrice = priceService.calculatePrice(

        )*/

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
