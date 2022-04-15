package com.nhnacademy.springframework.service.parser;

import com.nhnacademy.springframework.service.WaterBill;

import java.io.IOException;
import java.util.List;

public interface Parser {

    List<WaterBill> readToList(String path) throws IOException;
}
