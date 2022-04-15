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

class CsvToListTest {


    CsvWaterBill csvWaterBill;
    CsvToList csvToList;
    String csvFile = "Tariff_20220331.csv";
    @BeforeEach()
    void setUp(){

        csvWaterBill = new CsvWaterBill();
        csvToList = new CsvToList();

    }

    @DisplayName("csv파일을 parse해서 waterBill 리스트를 잘 반환하는가")
    @Test
    void ReadToListTest(){
        assertThat(csvToList.readToList(csvFile).size() == 303).isTrue();
    }
    @DisplayName("csvWaterBill에 잘 로드 되었나 확인")
    @Test
    void LoadTest() throws IOException {
        List<WaterBill> list = csvToList.readToList(csvFile);
        assertThat(csvWaterBill.findAll().size() == 0).isTrue();
        csvWaterBill.load(list);
        assertThat(csvWaterBill.findAll().size() == 303).isTrue();

    }
}