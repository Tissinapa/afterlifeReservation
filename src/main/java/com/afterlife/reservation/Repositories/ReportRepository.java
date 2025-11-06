package com.afterlife.reservation.Repositories;

import com.afterlife.reservation.Entities.RealmType;
import com.afterlife.reservation.Entities.ReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRepository extends JpaRepository<ReportEntity, Long> {
    List<ReportEntity> findByRealm(RealmType realm);
}
