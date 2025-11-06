package com.afterlife.reservation.Services;

import com.afterlife.reservation.Entities.RealmType;
import com.afterlife.reservation.Entities.ReportEntity;
import java.util.List;

public interface ReportService {
    List<ReportEntity> getReport();
    List<ReportEntity> getRealmReport(RealmType realm);
    void removeCustomer(Long buyerId);

}
