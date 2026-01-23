package com.afterlife.reservation.Services;


import com.afterlife.reservation.Entities.RealmType;
import com.afterlife.reservation.Entities.SeatClass;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class PriceService {

    public BigDecimal calculatePrice(RealmType realmType, SeatClass seatClass, LocalDate departureDate){
        BigDecimal basePrice;

        switch(realmType){
            case HELL -> basePrice = BigDecimal.valueOf(200);
            case HEAVEN -> basePrice = BigDecimal.valueOf(1000);
            default -> throw new IllegalStateException("Wrong realm!");

        }

        BigDecimal classMultiplier = switch (seatClass){
            case A -> BigDecimal.valueOf(1.5);
            case B -> BigDecimal.valueOf(1.2);
            case C -> BigDecimal.valueOf(1.0);
        };
        // Dynamic pricing for weekends
        BigDecimal finalPrice = basePrice.multiply(classMultiplier);
        if (departureDate.getDayOfWeek().getValue() >= 6){
            finalPrice = finalPrice.add(BigDecimal.valueOf(100));
        }


        return finalPrice;
    }


}
