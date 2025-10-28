package com.afterlife.reservation.Controllers;


import com.afterlife.reservation.Entities.SeatEntity;
import com.afterlife.reservation.Services.SeatService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/seat")
public class SeatController {

    @Autowired
    private SeatService seatService;

    //Post seat
    @PostMapping("/select")
    public SeatEntity reserveSeat(@Valid @RequestBody SeatEntity seat) {return seatService.reserveSeat(seat); }

    @GetMapping("/all")
    public List<SeatEntity> fetchSeats() { return seatService.fetchSeats();}



}
