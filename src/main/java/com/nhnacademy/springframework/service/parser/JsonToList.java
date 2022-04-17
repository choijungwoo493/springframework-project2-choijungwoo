package com.nhnacademy.springframework.service.parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhnacademy.springframework.service.WaterBill;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;


@Service
@Component("Json")
public class JsonToList implements Parser{
    private static final Log log = LogFactory.getLog(JsonToList.class);

    @Override
    public List<WaterBill> readToList(String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(path);
        WaterBill[] waterBill = objectMapper.readValue(inputStream, WaterBill[].class);
        return List.of(waterBill);
    }
}
