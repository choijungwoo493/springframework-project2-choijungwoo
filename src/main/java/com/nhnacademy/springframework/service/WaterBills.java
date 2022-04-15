package com.nhnacademy.springframework.service;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.List;

public interface WaterBills {

    // TODO 5 : score.csv 파일에서 데이터를 읽어 scores 에 추가하는 로직을 구현하세요.
    @Autowired
    void load(List<WaterBill> list) throws IOException;

    List<WaterBill> findAll();
}
