package com.afterlife.reservation.Controllers;


import com.afterlife.reservation.Entities.TicketEntity;
import com.afterlife.reservation.Services.TicketService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/ticket")
public class TicketController {


    @Autowired
    private TicketService ticketService;

    //buy ticket
    @PostMapping("/buy")
    public TicketEntity buyTicket(@Valid @RequestBody TicketEntity ticket){
        return ticketService.buyTicket(ticket);
    }


    @GetMapping("/all")
    public List<TicketEntity> fetchTickets() {return ticketService.fetchTickets(); }





}
