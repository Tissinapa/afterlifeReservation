package com.afterlife.reservation.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;


import java.util.List;

@Entity
@Table(name ="seats" )
public class SeatEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seatId;

    @Enumerated(EnumType.STRING)
    private RealmType realm;
    @Pattern(regexp = "^[ABC]$", message = "Section must be A,B or C")
    private String section;
    @Min(value = 1, message= "Seat number must be 1 or higher")
    @Max(value = 30, message= "Seat number must be 30 or lower")
    private String seatNumber;
    private boolean isReserved;

    @OneToMany(mappedBy = "seat")
    private List<TicketEntity> tickets;


    public SeatEntity(){}

    public SeatEntity(Long seatId, RealmType realm, String section, String seatNumber, boolean isReserved){
        this.seatId = seatId;
        this.realm = realm;
        this.section = section;
        this.seatNumber = seatNumber;
        this.isReserved = isReserved;
    }
    public Long getSeatId() {
        return seatId;
    }

    public void setSeatId(Long seatId) {
        this.seatId = seatId;
    }

    public RealmType getRealm() {
        return realm;
    }

    public void setRealm(RealmType realm) {
        this.realm = realm;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }

}
