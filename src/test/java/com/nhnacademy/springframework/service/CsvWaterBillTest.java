package com.nhnacademy.springframework.service;

import com.nhnacademy.springframework.aspect.LoggerAspect;
import com.nhnacademy.springframework.repository.CsvWaterBill;
import com.nhnacademy.springframework.service.parser.CsvToList;
import com.nhnacademy.springframework.service.parser.Parser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class CsvWaterBillTest {

    String fileName = "Tariff_20220331.csv";
    Parser csvToList;
    CsvWaterBill csvWaterBill;
    LoggerAspect loggerAspect;

    @BeforeEach
    void setUp(){
        csvToList = new CsvToList();
        csvWaterBill = new CsvWaterBill();
        loggerAspect = new LoggerAspect();
    }

    /*
    *
    * load() method는 통합테스트때 빈으로 만들고 테스트 할 예정
     */

    @DisplayName("load 실행 잘 동작")
    @Test
    void load() throws IOException {
        csvWaterBill.load(fileName);
        assertThat(csvWaterBill.findAll().size() == 303).isTrue();

    }

    @Test
    void findAll() throws IOException {
        csvWaterBill.load(fileName);
        assertThat(csvWaterBill.findAll().size() == 303).isTrue();
    }
}