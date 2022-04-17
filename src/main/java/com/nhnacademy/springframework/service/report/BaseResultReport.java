package com.nhnacademy.springframework.service.report;

import com.nhnacademy.springframework.service.WaterBill;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseResultReport implements ResultReport {

    private static final Log log = LogFactory.getLog(BaseResultReport.class);

    public void printResult(List<WaterBill> waterBillList, int waterUse) {
        log.info(setFormat(waterBillList, waterUse));
    }

    public String setFormat(List<WaterBill> waterBillList, int waterUse) {
        var message = new StringBuilder("\n");
        for (WaterBill waterBill : waterBillList) {
            String city = waterBill.getCity();
            String sector = waterBill.getSector();
            int unitPrice = waterBill.getUnitPrice();
            int usePrice = waterBill.getUnitPrice() * waterUse;
            message.append(toString(city, sector, unitPrice, usePrice));
        }
        return message.toString();
    }
    public String toString(String city,String sector,int unitPrice,int usePrice) {
        return "WaterBill{city=' " + city + "', sector='" + sector + "', unitPrice=" + unitPrice + ", billTotal=" + usePrice + " }\n";
    }
}
