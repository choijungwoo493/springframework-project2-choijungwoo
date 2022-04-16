package com.nhnacademy.springframework.service;

import com.nhnacademy.springframework.repository.WaterBills;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DefaultWaterBillService implements WaterBillService {

    private final WaterBills waterBills;

    @Autowired
    public DefaultWaterBillService(WaterBills waterBills) {
        this.waterBills = waterBills;
    }


    @Override
    public List<WaterBill> get5CitiesByWaterUseAndSortByUnitPrice(int waterUse) {
        return waterBills.findAll().stream()
                .filter(s->(s.getUnitStart() <= waterUse && s.getUnitEnd() >= waterUse))
                .sorted(Comparator.comparing(WaterBill::getUnitPrice))
                .limit(5)
                .collect(Collectors.toList());
    }



}
