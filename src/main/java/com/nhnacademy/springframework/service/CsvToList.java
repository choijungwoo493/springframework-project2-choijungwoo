package com.nhnacademy.springframework.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;


@Service
public class CsvToList implements Parser {
    private static final Log log = LogFactory.getLog(CsvToList.class);

    public static void main(String[] args) {
        CsvToList csvToList = new CsvToList();
        System.out.println(csvToList.readToList("Tariff_20220331.csv"));
    }
    public List<WaterBill> readToList(String path){
        List<WaterBill> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream(path)))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] token = line.split(",");
                WaterBill tempList = new WaterBill(Integer.parseInt(token[0]), token[1], token[2], Integer.parseInt(token[3]), Integer.parseInt(token[4]), Integer.parseInt(token[5]), Integer.parseInt(token[6]));
                list.add(tempList);
            }
        } catch (IOException e) {
            log.info(IOException.class);
        }
        return list;
    }
}
