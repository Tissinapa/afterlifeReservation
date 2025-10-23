package com.afterlife.reservation.Entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Table(name ="tickets" )
public class TicketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long ticketId;

    @ManyToOne
    @JoinColumn(name = "buyer_id", nullable = false)
    private UserEntity buyer;

    @ManyToOne
    @JoinColumn(name = "purchased_for_user_id")
    private UserEntity purchasedForUser;

    private String buyerName;
    private String buyerLastName;

    @ManyToOne
    @JoinColumn(name="seat_id", nullable = false)
    private SeatEntity seat;

    private Double price;
    private LocalDateTime purchaseDate;

    private boolean isPreorder;
    private LocalDate expectedDepartureDate;

    @Enumerated(EnumType.STRING)
    private TicketStatus status;



}
