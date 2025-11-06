package com.afterlife.reservation.Entities;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name ="reports" )
public class ReportEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reportId;

    @ManyToOne
    @JoinColumn(name = "ticket_id", nullable = false)
    private TicketEntity ticket;

    private String buyerName;
    private String recipientName;

    @Enumerated(EnumType.STRING)
    private RealmType realm;

    private String section;
    private String seatNumber;
    private double price;
    private boolean isPreorder;
    private LocalDate expectedDepartureDate;

    @Enumerated(EnumType.STRING)
    private TicketStatus status;
    private LocalDateTime reportDate;



    public ReportEntity(){}

    public ReportEntity(Long reportId, TicketEntity ticket, String buyerName,String recipientName,
                        RealmType realm, String section, String seatNumber, double price,
                        boolean isPreorder, LocalDate expectedDepartureDate, TicketStatus status,LocalDateTime reportDate){

        this.reportId = reportId;
        this.ticket = ticket;
        this.buyerName = buyerName;
        this.recipientName = recipientName;
        this.realm = realm;
        this.section = section;
        this.seatNumber = seatNumber;
        this.price = price;
        this.isPreorder = isPreorder;
        this.expectedDepartureDate = expectedDepartureDate;
        this.status = status;
        this.reportDate = reportDate;

    }

    public Long getReportId() {
        return reportId;
    }

    public void setReportId(Long reportId) {
        this.reportId = reportId;
    }

    public TicketEntity getTicket() {
        return ticket;
    }

    public void setTicket(TicketEntity ticket) {
        this.ticket = ticket;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isPreorder() {
        return isPreorder;
    }

    public void setPreorder(boolean preorder) {
        isPreorder = preorder;
    }

    public LocalDate getExpectedDepartureDate() {
        return expectedDepartureDate;
    }

    public void setExpectedDepartureDate(LocalDate expectedDepartureDate) {
        this.expectedDepartureDate = expectedDepartureDate;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }

    public LocalDateTime getReportDate() {
        return reportDate;
    }

    public void setReportDate(LocalDateTime reportDate) {
        this.reportDate = reportDate;
    }

}
