package com.afterlife.reservation.Services;

import com.afterlife.reservation.Entities.SeatEntity;
import com.afterlife.reservation.Repositories.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatServiceImpl implements SeatService{


    private final SeatRepository seatRepository;

    @Autowired
    public SeatServiceImpl(SeatRepository seatRepository){
        this.seatRepository = seatRepository;
    }

    @Override
    public SeatEntity reserveSeat(SeatEntity seat){
        String seatNumber = seat.getSeatNumber();
        int numSeat = Integer.parseInt(seatNumber);// this is so stupid but im to lazy to modify seat entity and db :D lol

        if(numSeat < 1 || numSeat >30 ){
            throw new IllegalArgumentException("Seat number must be between 1 and 30");
        }

        boolean seatIsAvailable = seatRepository.findByRealmAndSectionAndSeatNumber(
                seat.getRealm(),
                seat.getSection(),
                seat.getSeatNumber()
        ).isPresent();
        if (seatIsAvailable){
            throw new IllegalStateException("Seat is already taken!");
        }



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
