package com.nhnacademy.springframework.service;

import com.nhnacademy.springframework.config.Mainconfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DefaultWaterBillServiceTest {

    CsvWaterBill csvWaterBill;
    WaterBillService waterBillService;
    CsvToList csvToList;
    String csvFile = "Tariff_20220331.csv";
    List<WaterBill> list;
    @BeforeEach()
    void setUp(){
        csvWaterBill = new CsvWaterBill();
        csvToList = new CsvToList();
        list = csvToList.readToList(csvFile);


    }

    @DisplayName("물사용량에따라 잘 filter됐는지 확인")
    @Test
    void getWaterBillByWaterUseTest() throws IOException {
        csvWaterBill.load(list);
        waterBillService =  new DefaultWaterBillService(csvWaterBill);
        List<WaterBill> list = waterBillService.get5CitiesByWaterUseAndSortByUnitPrice(1000);
        for (int i = 0; i < list.size(); i++) {
            assertThat(list.get(i).getUnitStart() <=1000 && list.get(i).getUnitEnd()>= 1000).isTrue();
        }
        System.out.println(list.size());
    }

    @DisplayName("정렬후 물값이 가장 싼 5곳 확인")
    @Test
    void take5CitiesTest() throws IOException {

        csvWaterBill.load(list);
        waterBillService =  new DefaultWaterBillService(csvWaterBill);
        List<WaterBill> list = waterBillService.get5CitiesByWaterUseAndSortByUnitPrice(1000);
        assertThat(list.size() == 5).isTrue();
    }
}