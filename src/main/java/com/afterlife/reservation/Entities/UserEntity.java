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


    public UserEntity() {
    }
    public UserEntity(String username, String email, String passwordHash, boolean isAdmin){
        this.username = username;
        this.email = email;
        this.passwordHash = passwordHash;
        this.isAdmin = isAdmin;
        this.createdAt = LocalDateTime.now();
    }

    public Long getUserId(){
        return userId;
    }
    public void setUserId(Long userId){
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public boolean getIsAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        this.isAdmin = admin;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
