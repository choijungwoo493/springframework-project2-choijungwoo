package com.nhnacademy.springframework.service;


import com.nhnacademy.springframework.Main;
import com.nhnacademy.springframework.aspect.LoggerAspect;
import com.nhnacademy.springframework.config.Mainconfiguration;
import com.nhnacademy.springframework.repository.CsvWaterBill;
import com.nhnacademy.springframework.service.parser.CsvToList;
import com.nhnacademy.springframework.service.parser.Parser;
import com.nhnacademy.springframework.service.report.BaseResultReport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

@SpringJUnitConfig(classes = {Mainconfiguration.class, LoggerAspect.class})
public class AllTest {

    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Mainconfiguration.class);
    String fileName = "Tariff_20220331.csv";
    CsvWaterBill csvWaterBill;
    WaterBillService defaultWaterBillService;
    BaseResultReport baseResultReport;
    Parser csvToList;
    LoggerAspect loggerAspect;

    @BeforeEach()
    void setUp() {
        csvWaterBill = context.getBean("csvWaterBill", CsvWaterBill.class);
        defaultWaterBillService = context.getBean("defaultWaterBillService", DefaultWaterBillService.class);
        baseResultReport = context.getBean("baseResultReport", BaseResultReport.class);
        csvToList = context.getBean("csvToList", CsvToList.class);

    }

    @Override
    public boolean equals(Object o) {
        return Objects.equals(o.toString(), this.toString());
    }

    @Override
    public int hashCode() {
        return Objects.hash(csvWaterBill);
    }

    @DisplayName("csvWaterBill load method 의 parser 구현체인 csvToList의 함수인 readToList를 쓴다." +
            "그 값이 잘 로드 되는지 테스트")
    @Test()
    void csvWaterBillAndCsvToListTest() throws IOException {
        csvWaterBill.load(fileName);
        assertThat(csvWaterBill.findAll().size() == csvToList.readToList(fileName).size()).isTrue();
    }
}