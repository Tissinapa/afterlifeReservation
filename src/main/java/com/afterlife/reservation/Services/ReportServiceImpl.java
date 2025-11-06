package com.afterlife.reservation.Services;


import com.afterlife.reservation.Entities.RealmType;
import com.afterlife.reservation.Entities.ReportEntity;
import com.afterlife.reservation.Repositories.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportServiceImpl implements ReportService{

    private final ReportRepository reportRepository;

    @Autowired
    public ReportServiceImpl(ReportRepository reportRepository){
        this.reportRepository = reportRepository;
    }
    @Override
    public List<ReportEntity> getReport(){
        return (List<ReportEntity>) reportRepository.findAll();
    }

    @Override
    public List<ReportEntity> getRealmReport(RealmType realm){
        return reportRepository.findByRealm(realm);
    }
    public void removeCustomer(Long buyerId){
        reportRepository.deleteById(buyerId);

    }

}
