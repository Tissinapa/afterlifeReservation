package com.afterlife.reservation.Repositories;

import com.afterlife.reservation.Entities.RealmType;
import com.afterlife.reservation.Entities.SeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SeatRepository extends JpaRepository<SeatEntity , Long> {
    Optional<SeatEntity> findByRealmAndSectionAndSeatNumber(
            RealmType realmType,
            String section,
            String seatNumber);
}
