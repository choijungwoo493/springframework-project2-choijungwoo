package com.nhnacademy.springframework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CsvWaterBill implements WaterBills {

    static boolean isFileLoaded = false;


    private List<WaterBill> waterBill = new ArrayList<>();

    public static void isFileLoaded() {
        if (!isFileLoaded) {
            throw new IllegalStateException("파일로딩이 완료되지 않았습니다");
        }
    }

    // TODO 5 : score.csv 파일에서 데이터를 읽어 scores 에 추가하는 로직을 구현하세요.
    @Autowired
    @Override
    public void load(List<WaterBill> list) throws IOException {
        this.waterBill = list;
        isFileLoaded = true;
    }

    @Override
    public List<WaterBill> findAll() {
        return this.waterBill;
    }
}
