package com.afterlife.reservation.Entities;


import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name ="users" )
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String username;
    private String email;
    private String passwordHash;
    private boolean isAdmin;
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "buyer")
    private List<TicketEntity> purchasedTickets;

    @OneToMany(mappedBy = "purchasedForUser")
    private List<TicketEntity> giftedTickets;




}
