package com.nhnacademy.springframework.service.report;

import com.nhnacademy.springframework.service.WaterBill;

import java.util.List;

public interface ResultReport {

    void printResult(List<WaterBill> waterBillList,int waterUse);

    String setFormat(List<WaterBill> waterBillList,int waterUse);
}
