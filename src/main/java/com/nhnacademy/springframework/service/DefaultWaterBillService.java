package com.nhnacademy.springframework.service;

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
        List<WaterBill> waterBillList = waterBills.findAll().stream()
                .filter(s->(s.getUnitStart() <= waterUse && s.getUnitEnd() >= waterUse))
                .sorted(Comparator.comparing(WaterBill::getUnitPrice))
                .limit(5)
                .collect(Collectors.toList());
        for (int i = 0; i < waterBillList.size(); i++) {
            String city = waterBillList.get(i).getCity();
            String sector= waterBillList.get(i).getSector();
            int unitPrice = waterBillList.get(i).getUnitPrice();
            int usePrice = waterBillList.get(i).getUnitPrice() * waterUse;
            System.out.printf("WaterBill{city='%s', sector='%s', unitPrice=%d, billTotal=%d}",city,sector,unitPrice,usePrice);
        }

        return waterBillList;
    }



}
