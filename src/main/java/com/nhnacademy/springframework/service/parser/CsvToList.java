package com.nhnacademy.springframework.service.parser;

import com.nhnacademy.springframework.service.WaterBill;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


@Service
@Component("Csv")
public class CsvToList implements Parser {
    private static final Log log = LogFactory.getLog(CsvToList.class);

    @Override
    public List<WaterBill> readToList(String path) {
        List<WaterBill> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream(path)))) {
            String line;
            br.readLine(); // 첫번째줄은 생략하기위함
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
