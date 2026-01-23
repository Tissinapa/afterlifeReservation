package com.afterlife.reservation;

import com.afterlife.reservation.Entities.RealmType;
import com.afterlife.reservation.Entities.SeatClass;
import com.afterlife.reservation.Entities.SeatEntity;
import com.afterlife.reservation.Repositories.SeatRepository;
import com.afterlife.reservation.Services.SeatServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

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
    void ShouldReturnRealmWhenIdExists(){
        SeatEntity seat = new SeatEntity(1L, RealmType.HELL, SeatClass.A,1,false);
        when(seatRepository.save(any(SeatEntity.class))).thenReturn(seat);

        SeatEntity savedSeat = seatService.reserveSeat(seat);

        assertNotNull(savedSeat);
        assertEquals(RealmType.HELL,savedSeat.getRealm());
        verify(seatRepository,times(1)).save(seat);

    }
    @Test
    void ShouldReturnSectionWhenIdExists(){
        SeatEntity seat = new SeatEntity(1L, RealmType.HELL,SeatClass.A,1,false);
        when(seatRepository.save(any(SeatEntity.class))).thenReturn(seat);

        SeatEntity savedSeat = seatService.reserveSeat(seat);

        assertNotNull(savedSeat);
        assertEquals(SeatClass.A,savedSeat.getSection());
        verify(seatRepository,times(1)).save(seat);

    }
    @Test
    void ShouldReturnSeatWhenIdExists(){
        SeatEntity seat = new SeatEntity(1L, RealmType.HELL,SeatClass.A,1,false);
        when(seatRepository.save(any(SeatEntity.class))).thenReturn(seat);

        SeatEntity savedSeat = seatService.reserveSeat(seat);

        assertNotNull(savedSeat);
        assertEquals(1,savedSeat.getSeatNumber());
        verify(seatRepository,times(1)).save(seat);

    }
    @Test
    void ShouldFetchAllWhenExists(){
        SeatEntity seat1 = new SeatEntity(1L,RealmType.HELL,SeatClass.B,2,false);
        SeatEntity seat2 = new SeatEntity(2L,RealmType.HEAVEN,SeatClass.C,3,false);

        when(seatRepository.findAll()).thenReturn(List.of(seat1,seat2));

        List<SeatEntity> seats = seatService.fetchSeats();

        assertEquals(2,seats.size());
        verify(seatRepository,times(1)).findAll();

    }
    @Test
    void shouldDeleteSeatById(){
        Long seatId = 1L;
        seatService.deleteSeatById(seatId);
        verify(seatRepository,times(1)).deleteById(seatId);
    }

}
