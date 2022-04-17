package com.nhnacademy.springframework;

import com.nhnacademy.springframework.config.Mainconfiguration;
import com.nhnacademy.springframework.repository.CsvWaterBill;
import com.nhnacademy.springframework.service.DefaultWaterBillService;
import com.nhnacademy.springframework.service.WaterBill;
import com.nhnacademy.springframework.service.WaterBillService;
import com.nhnacademy.springframework.service.report.BaseResultReport;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Mainconfiguration.class);

        String fileName = "Tariff_20220331.json";
        CsvWaterBill csvWaterBill = context.getBean("csvWaterBill", CsvWaterBill.class);
        WaterBillService defaultWaterBillService = context.getBean("defaultWaterBillService", DefaultWaterBillService.class);
        BaseResultReport baseResultReport = context.getBean("baseResultReport", BaseResultReport.class);
        csvWaterBill.load(fileName);
        int waterUse = 1000;
        List<WaterBill> list1 = defaultWaterBillService.get5CitiesByWaterUseAndSortByUnitPrice(waterUse);
        baseResultReport.printResult(list1, waterUse);

    }
}
