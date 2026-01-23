package com.afterlife.reservation.DataTransferObjects;

import com.afterlife.reservation.Entities.RealmType;
import com.afterlife.reservation.Entities.SeatClass;

import java.time.LocalDate;

public class PriceRequests {

    private RealmType realmType;
    private SeatClass seatClass;
    private LocalDate departureDate;

    public PriceRequests(RealmType realmType, SeatClass seatClass, LocalDate departureDate){
        this.realmType = realmType;
        this.seatClass =seatClass;
        this.departureDate = departureDate;
    }

    public RealmType getRealmType(){ return realmType ; }
    public SeatClass getSeatClass(){ return seatClass ; }
    public LocalDate getDepartureDate() {return departureDate; }

    public void setRealmType(RealmType realmType) {
        this.realmType = realmType;
    }

    public void setSeatClass(SeatClass seatClass) {
        this.seatClass = seatClass;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }
}
