package com.nhnacademy.springframework.repository;

import java.io.IOException;
import java.util.List;

public interface WaterBills {

    void load() throws IOException;

    List<WaterBill> findAll();
}
