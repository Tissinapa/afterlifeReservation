package com.afterlife.reservation;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReservationController {
    @GetMapping("/home")
    public String Home(){
        return "This is reservation service for afterlife!";
    }
}
