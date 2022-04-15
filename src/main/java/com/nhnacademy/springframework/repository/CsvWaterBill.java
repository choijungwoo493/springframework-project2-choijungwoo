package com.nhnacademy.springframework.repository;

import com.nhnacademy.springframework.service.parser.CsvToList;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CsvWaterBill  implements WaterBills {

    public static void main(String[] args) {
        List<List<String>> list = CsvToList.readToList("src/main/resources/Tariff_20220331.csv");
        List<WaterBill> waterBill = new ArrayList<>();;
        for (int i = 1; i < list.size(); i++) {

            List<String> ele = list.get(i);
            waterBill.add(new WaterBill(Integer.parseInt(ele.get(0)),ele.get(1),ele.get(2),Integer.parseInt(ele.get(3)),Integer.parseInt(ele.get(4)),Integer.parseInt(ele.get(5)),Integer.parseInt(ele.get(6))));
//            System.out.println(waterBill.get(1));
        }
    }
    static boolean isFileLoaded = false;


    private final List<WaterBill> waterBill = new ArrayList<>();

    public static void isFileLoaded() {
        if (!isFileLoaded) {
            throw new IllegalStateException("파일로딩이 완료되지 않았습니다");
        }
    }

    // TODO 5 : score.csv 파일에서 데이터를 읽어 scores 에 추가하는 로직을 구현하세요.
    @Override
    public void load() throws IOException {
        List<List<String>> list = CsvToList.readToList("src/main/resources/Tariff_20220331.csv");
        for (int i = 1; i < list.size(); i++) {

            List<String> ele = list.get(i);
            waterBill.add(new WaterBill(Integer.parseInt(ele.get(0)),ele.get(1),ele.get(2),Integer.parseInt(ele.get(3)),Integer.parseInt(ele.get(4)),Integer.parseInt(ele.get(5)),Integer.parseInt(ele.get(6))));
            }
        isFileLoaded = true;
    }

    @Override
    public List<WaterBill> findAll() {
        return this.waterBill;
    }
}
