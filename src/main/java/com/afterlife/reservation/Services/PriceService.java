package com.afterlife.reservation.Services;

import com.afterlife.reservation.Entities.RealmType;
import com.afterlife.reservation.Entities.SeatClass;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface PriceService {
    BigDecimal calculatePrice(
            RealmType realmType,
            SeatClass seatClass,
            LocalDate departureDate
    );

}
