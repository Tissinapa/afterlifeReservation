package com.afterlife.reservation.Services;

import com.afterlife.reservation.Entities.SeatEntity;

import java.util.List;

public interface SeatService {
    SeatEntity reserveSeat(SeatEntity seatEntity);
    List<SeatEntity> fetchSeats();
    void deleteSeatById(Long seatId);
}
