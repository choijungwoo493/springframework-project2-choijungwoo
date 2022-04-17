package com.nhnacademy.springframework.repository;

import com.nhnacademy.springframework.service.WaterBill;
import com.nhnacademy.springframework.service.parser.Parser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class CsvWaterBill implements WaterBills {

    static boolean isFileLoaded = false;


    private Parser parser;

    @Autowired
    @Qualifier("Json")    // Csv
    private void Parser(Parser parser){
        this.parser = parser;
    }

    private List<WaterBill> waterBill = new ArrayList<>();

    public static void isFileLoaded() {
        if (!isFileLoaded) {
            throw new IllegalStateException("파일로딩이 완료되지 않았습니다");
        }
    }

    public static void changeValueTrueByLoading(){
        if(!isFileLoaded){
            isFileLoaded = true;
        }
    }
    @Override
    public void load(String path) throws IOException {

        this.waterBill = parser.readToList(path);
        changeValueTrueByLoading();
    }


    @Override
    public List<WaterBill> findAll() {
        return this.waterBill;
    }
}
