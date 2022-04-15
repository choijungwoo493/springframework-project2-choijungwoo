package com.nhnacademy.springframework.service;

import com.nhnacademy.springframework.repository.CsvWaterBill;
import com.nhnacademy.springframework.repository.WaterBills;
import com.nhnacademy.springframework.service.parser.CsvToList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class DefaultWaterBillServiceTest {

    WaterBills csvWaterBill;
    CsvToList csvToList;
    String csvFile = "Tariff_2022033®1.csv";
    List<WaterBill> list;
    WaterBillService defaultWaterBillService;
    WaterBills waterBills;
    String fileName = "Tariff_20220331.csv";
    @BeforeEach()
    void setUp() throws IOException {
        csvWaterBill = new CsvWaterBill();
        csvToList = new CsvToList();
        csvWaterBill.load(fileName);
        defaultWaterBillService = new DefaultWaterBillService(csvWaterBill);

    }

    @Test
    void get5CitiesByWaterUseAndSortByUnitPrice() {
        List<WaterBill> list = defaultWaterBillService.get5CitiesByWaterUseAndSortByUnitPrice(1000);

        assertThat(list.size() == 5).isTrue();
        list.stream().filter(s->s.getUnitStart()<= 1000 && s.getUnitEnd() >= 1000);
        assertThat(list.size() == 5).isTrue();


    }


}