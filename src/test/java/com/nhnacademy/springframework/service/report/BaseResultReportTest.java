package com.nhnacademy.springframework.service.report;

import com.nhnacademy.springframework.repository.CsvWaterBill;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class BaseResultReportTest {
    CsvWaterBill csvWaterBill;
    String fileName = "Tariff_20220331.json";
    @BeforeEach
    void setUp() {
        csvWaterBill = new CsvWaterBill();
    }

    @Test
    void printResult() throws IOException {
        csvWaterBill.load(fileName);
    }

    @Test
    void setFormat() {
    }
}