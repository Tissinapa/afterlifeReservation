package com.afterlife.reservation.Repositories;

import com.afterlife.reservation.Entities.RealmType;
import com.afterlife.reservation.Entities.ReportEntity;
import com.afterlife.reservation.Entities.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<TicketEntity, Long> {

}
