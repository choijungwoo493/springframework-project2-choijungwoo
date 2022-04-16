package com.nhnacademy.springframework;

import com.nhnacademy.springframework.aspect.LoggerAspect;
import com.nhnacademy.springframework.config.Mainconfiguration;
import com.nhnacademy.springframework.repository.CsvWaterBill;
import com.nhnacademy.springframework.service.report.BaseResultReport;
import com.nhnacademy.springframework.service.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Mainconfiguration.class);

        String fileName = "Tariff_20220331.csv";
        CsvWaterBill csvWaterBill = context.getBean("csvWaterBill",CsvWaterBill.class);
        WaterBillService defaultWaterBillService = context.getBean("defaultWaterBillService",DefaultWaterBillService.class);
        BaseResultReport baseResultReport = context.getBean("baseResultReport",BaseResultReport.class);

        csvWaterBill.load(fileName);
        List<WaterBill> list1 = defaultWaterBillService.get5CitiesByWaterUseAndSortByUnitPrice(1000);
        baseResultReport.printResult(list1);

    }
}
