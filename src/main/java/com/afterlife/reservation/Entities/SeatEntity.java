package com.afterlife.reservation.Entities;

import jakarta.persistence.*;


import java.util.List;

@Entity
@Table(name ="seats" )
public class SeatEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seatId;

    @Enumerated(EnumType.STRING)
    private RealmType realm;
    private String section;
    private String seatNumber;
    private boolean isReserved;

    @OneToMany(mappedBy = "seat")
    private List<TicketEntity> tickets;





}
