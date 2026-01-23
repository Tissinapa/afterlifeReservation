package com.afterlife.reservation.DataTransferObjects;

import java.math.BigDecimal;

public class PriceResponse {

    private BigDecimal price;
    private String currency = "EUR";

    public PriceResponse(BigDecimal price){
        this.price = price;

    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
