package com.afterlife.reservation.Controllers;


import com.afterlife.reservation.Entities.RealmType;
import com.afterlife.reservation.Entities.ReportEntity;
import com.afterlife.reservation.Services.ReportService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/all")
    public List<ReportEntity> getReport() {return reportService.getReport();}

    @GetMapping("/byrealms")
    public List<ReportEntity> getRealmReport(@RequestParam String realm) {

        RealmType realmType = RealmType.valueOf(realm.toUpperCase());
        return reportService.getRealmReport(realmType);

    }

}
