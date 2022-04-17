package com.nhnacademy.springframework.service.parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhnacademy.springframework.service.WaterBill;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


@Service
@Component("Json")
public class JsonToList implements Parser {

    @Override
    public List<WaterBill> readToList(String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(path);
        WaterBill[] waterBill = objectMapper.readValue(inputStream, WaterBill[].class);
        return List.of(waterBill);
    }
}
