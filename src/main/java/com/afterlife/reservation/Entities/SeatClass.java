package com.afterlife.reservation.Entities;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum SeatClass {
    A,
    B,
    C;

    @JsonCreator
    public static SeatClass fromValues(String value) { return  SeatClass.valueOf(value.toUpperCase());}
}
