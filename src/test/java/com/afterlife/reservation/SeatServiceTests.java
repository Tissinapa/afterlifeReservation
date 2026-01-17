package com.afterlife.reservation;

import com.afterlife.reservation.Entities.RealmType;
import com.afterlife.reservation.Entities.SeatEntity;
import com.afterlife.reservation.Repositories.SeatRepository;
import com.afterlife.reservation.Services.SeatServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

// Unit tests for seat service


@ExtendWith(MockitoExtension.class)
public class SeatServiceTests {

    @Mock
    private SeatRepository seatRepository;
    @InjectMocks
    private SeatServiceImpl seatService;

    @Test
    void ShouldReturnSeatWhenIdExists(){
        SeatEntity seat = new SeatEntity(1L, RealmType.HELL,"A",1,false);
        when(seatRepository.save(any(SeatEntity.class))).thenReturn(seat);

    }

}
