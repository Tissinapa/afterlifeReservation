package com.afterlife.reservation.DataTransferObjects;

import java.math.BigDecimal;

public class TicketResponse {

    private Long ticketId;
    private BigDecimal price;
    private String status;

    public TicketResponse(Long ticketId, BigDecimal price){
        this.ticketId = ticketId;
        this.price = price;
        this.status = "CONFIRMED";
    }

    public Long getTicketId() {
        return ticketId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getStatus() {
        return status;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
