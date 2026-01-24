package com.afterlife.reservation.Services;

import com.afterlife.reservation.DataTransferObjects.TicketRequest;
import com.afterlife.reservation.DataTransferObjects.TicketResponse;
import com.afterlife.reservation.Entities.SeatEntity;
import com.afterlife.reservation.Entities.TicketEntity;
import com.afterlife.reservation.Entities.UserEntity;
import com.afterlife.reservation.Repositories.SeatRepository;
import com.afterlife.reservation.Repositories.TicketRepository;
import com.afterlife.reservation.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TicketServiceImpl implements TicketService{

    private final TicketRepository ticketRepository;
    private final PriceService priceService;
    private final SeatRepository seatRepository;
    private final UserRepository userRepository;

    @Autowired
    public TicketServiceImpl(
            TicketRepository ticketRepository,
            PriceService priceService, SeatRepository seatRepository, UserRepository userRepository
    ) {
        this.ticketRepository = ticketRepository;
        this.priceService = priceService;
        this.seatRepository = seatRepository;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public TicketResponse buyTicket(TicketRequest request) {
        UserEntity buyer  = userRepository.findById(request.getBuyerId())
                .orElseThrow(() -> new RuntimeException("User not found"));


        SeatEntity seat = seatRepository.findById(request.getSeatId())
                .orElseThrow(() -> new RuntimeException("Seat not found"));

        if (seat.isReserved()) {
            throw new RuntimeException("Seat already reserved");
        }


        BigDecimal price = priceService.calculatePrice(
                seat.getRealm(),
                seat.getSection(),
                request.getDepartureDate()
        );


        seat.setReserved(true);

        TicketEntity ticket = new TicketEntity();
        ticket.setBuyer(buyer);
        ticket.setSeat(seat);
        ticket.setPrice(price.doubleValue());
        ticket.setPurchaseDate(LocalDateTime.now());
        //ticket.setPreorder(request.isPreorder());
        ticket.setExpectedDepartureDate(request.getDepartureDate());
        //ticket.setStatus(TicketStatus.PURCHASED);



        TicketEntity saved = ticketRepository.save(ticket);

        return new TicketResponse(saved.getTicketId(), price);
    }

    @Override
    public TicketEntity buyTicketForOther(TicketEntity ticket) {
        return ticketRepository.save(ticket);
    }

    @Override
    public List<TicketEntity> fetchTickets() {
        return (List<TicketEntity>) ticketRepository.findAll();
    }

    @Override
    public void deleteTicket(Long ticketId) {
        ticketRepository.deleteById(ticketId);
    }





}
