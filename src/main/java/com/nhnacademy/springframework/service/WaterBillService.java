package com.nhnacademy.springframework.service;

import java.util.List;

public interface WaterBillService {

    List<WaterBill> get5CitiesByWaterUseAndSortByUnitPrice(int useWater);

}
