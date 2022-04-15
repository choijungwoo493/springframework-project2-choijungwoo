package com.nhnacademy.springframework.repository;

import com.nhnacademy.springframework.service.WaterBill;
import com.nhnacademy.springframework.service.parser.CsvToList;
import com.nhnacademy.springframework.service.parser.Parser;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CsvWaterBill implements WaterBills {

    static boolean isFileLoaded = false;
    Parser parser = new CsvToList();


    private List<WaterBill> waterBill = new ArrayList<>();

    public static void isFileLoaded() {
        if (!isFileLoaded) {
            throw new IllegalStateException("파일로딩이 완료되지 않았습니다");
        }
    }

    @Override
    public void load(String path) throws IOException {
        this.waterBill = parser.readToList(path);
        isFileLoaded = true;
    }

    @Override
    public List<WaterBill> findAll() {
        return this.waterBill;
    }
}
