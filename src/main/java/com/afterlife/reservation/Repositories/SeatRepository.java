package com.afterlife.reservation.Repositories;

import com.afterlife.reservation.Entities.SeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepository extends JpaRepository<SeatEntity , Long> {
}
