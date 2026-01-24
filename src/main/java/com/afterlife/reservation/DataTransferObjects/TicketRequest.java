package com.afterlife.reservation.DataTransferObjects;

import com.afterlife.reservation.Entities.RealmType;
import com.afterlife.reservation.Entities.SeatClass;

import java.time.LocalDate;

public class TicketRequest {

    private Long seatId;
    private Long buyerId;
    private Long purchasedForUserId; // optional
    private LocalDate departureDate;
    private boolean preorder;

    public Long getSeatId() {
        return seatId;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public Long getPurchasedForUserId() {
        return purchasedForUserId;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setSeatId(Long seatId) {
        this.seatId = seatId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public void setPurchasedForUserId(Long purchasedForUserId) {
        this.purchasedForUserId = purchasedForUserId;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public boolean isPreorder() {
        return preorder;
    }
}
