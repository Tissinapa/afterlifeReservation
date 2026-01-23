package com.afterlife.reservation.Controllers;

import com.afterlife.reservation.DataTransferObjects.PriceRequests;
import com.afterlife.reservation.DataTransferObjects.PriceResponse;
import com.afterlife.reservation.Services.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/prices")
public class PriceController {

    @Autowired
    private PriceService priceService;

    @PostMapping
    public PriceResponse calculatePrice(@RequestBody PriceRequests request){
        return new PriceResponse(priceService.calculatePrice(
                request.getRealmType(),
                request.getSeatClass(),
                request.getDepartureDate())
        );
    }

}
