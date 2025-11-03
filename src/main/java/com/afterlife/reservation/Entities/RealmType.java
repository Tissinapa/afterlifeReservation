package com.afterlife.reservation.Entities;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum RealmType {
    HEAVEN,
    HELL;

    @JsonCreator
    public static RealmType fromValue(String value){
        return RealmType.valueOf(value.toUpperCase());
    }

}
