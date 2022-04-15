package com.nhnacademy.springframework.service;

import java.io.IOException;
import java.util.List;

public interface Parser {

    List<WaterBill> readToList(String path) throws IOException;
}
