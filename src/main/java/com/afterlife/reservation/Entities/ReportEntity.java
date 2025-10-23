package com.afterlife.reservation.Entities;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name ="reports" )
public class ReportEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reportId;

    @ManyToOne
    @JoinColumn(name = "ticket_id", nullable = false)
    private TicketEntity ticket;

    private String buyerName;
    private String recipientName;

    @Enumerated(EnumType.STRING)
    private RealmType realm;

    private String section;
    private String seatNumber;
    private Double price;
    private boolean isPreorder;
    private LocalDate expectedDepartureDate;

    @Enumerated(EnumType.STRING)
    private TicketStatus status;
    private LocalDateTime reportDate;





}
