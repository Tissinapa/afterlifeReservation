package com.afterlife.reservation.Entities;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum TicketStatus {
    PENDING,
    CONFIRMED,
    FULFILLED,
    EXPIRED;

    /*@JsonCreator
    public static TicketStatus(String value){
        return TicketStatus.valueOf(value.toUpperCase());
    }*/

}
