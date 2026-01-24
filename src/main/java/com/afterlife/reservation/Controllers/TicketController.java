package com.afterlife.reservation.Controllers;


import com.afterlife.reservation.DataTransferObjects.TicketRequest;
import com.afterlife.reservation.DataTransferObjects.TicketResponse;
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
    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    //buy ticket
    @PostMapping("/buy")
    public TicketResponse buyTicket(@Valid @RequestBody TicketRequest request) {
        return ticketService.buyTicket(request);
    }


    @GetMapping("/all")
    public List<TicketEntity> fetchTickets() {return ticketService.fetchTickets(); }





}
