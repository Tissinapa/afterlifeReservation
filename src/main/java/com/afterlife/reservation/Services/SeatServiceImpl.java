package com.afterlife.reservation.Services;

import com.afterlife.reservation.Entities.SeatEntity;
import com.afterlife.reservation.Repositories.SeatRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatServiceImpl implements SeatService{


    private SeatRepository seatRepository;

    @Override
    public SeatEntity reserveSeat(SeatEntity seat){

        return seatRepository.save(seat);
    }

    @Override
    public List<SeatEntity> fetchSeats(){
        return(List<SeatEntity>) seatRepository.findAll();
    }

    @Override
    public void deleteSeat(Long seatId){
        seatRepository.deleteById(seatId);
    }


}
