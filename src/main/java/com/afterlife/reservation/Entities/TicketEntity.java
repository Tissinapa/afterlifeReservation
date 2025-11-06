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

    private double price;
    private LocalDateTime purchaseDate;

    private boolean isPreorder;
    private LocalDate expectedDepartureDate;

    @Enumerated(EnumType.STRING)
    private TicketStatus status;

    public TicketEntity(){}

    public TicketEntity(Long ticketId, UserEntity buyer, UserEntity purchasedForUser, String buyerName, String buyerLastName, SeatEntity seat,
                        Double price, LocalDateTime purchaseDate, TicketStatus status, boolean isPreorder, LocalDate expectedDepartureDate){
        this.ticketId = ticketId;
        this.buyer = buyer;
        this.purchasedForUser = purchasedForUser;
        this.buyerName = buyerName;
        this.buyerLastName = buyerLastName;
        this.seat = seat;
        this.price = price;
        this.purchaseDate = purchaseDate;
        this.isPreorder = isPreorder;
        this.expectedDepartureDate = expectedDepartureDate;
        this.status = status;

    }

    public Long getTicketId() {
        return ticketId;
    }
    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public UserEntity getBuyer() {
        return buyer;
    }

    public void setBuyer(UserEntity buyer) {
        this.buyer = buyer;
    }

    public UserEntity getPurchasedForUser() {
        return purchasedForUser;
    }

    public void setPurchasedForUser(UserEntity purchasedForUser) {
        this.purchasedForUser = purchasedForUser;
    }

    public String getBuyerName() {
        return buyerName;
    }


    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public SeatEntity getSeat() {
        return seat;
    }

    public void setSeat(SeatEntity seat) {
        this.seat = seat;
    }

    public String getBuyerLastName() {
        return buyerLastName;
    }

    public void setBuyerLastName(String buyerLastName) {
        this.buyerLastName = buyerLastName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDateTime purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public boolean isPreorder() {
        return isPreorder;
    }

    public void setPreorder(boolean preorder) {
        isPreorder = preorder;
    }

    public LocalDate getExpectedDepartureDate() {
        return expectedDepartureDate;
    }

    public void setExpectedDepartureDate(LocalDate expectedDepartureDate) {
        this.expectedDepartureDate = expectedDepartureDate;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }

}
