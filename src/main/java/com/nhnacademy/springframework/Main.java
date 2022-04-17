package com.nhnacademy.springframework;

import com.nhnacademy.springframework.config.Mainconfiguration;
import com.nhnacademy.springframework.repository.CsvWaterBill;
import com.nhnacademy.springframework.service.report.BaseResultReport;
import com.nhnacademy.springframework.service.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Mainconfiguration.class);

        String fileName = "Tariff_20220331.json";
        CsvWaterBill csvWaterBill = context.getBean("csvWaterBill",CsvWaterBill.class);
        WaterBillService defaultWaterBillService = context.getBean("defaultWaterBillService",DefaultWaterBillService.class);
        BaseResultReport baseResultReport = context.getBean("baseResultReport",BaseResultReport.class);
        csvWaterBill.load(fileName);
        int waterUse = scanner.nextInt();
        List<WaterBill> list1 = defaultWaterBillService.get5CitiesByWaterUseAndSortByUnitPrice(waterUse);
        baseResultReport.printResult(list1,waterUse);

    }
}
