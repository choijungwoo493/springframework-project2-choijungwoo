package com.nhnacademy.springframework.service.report;

import com.nhnacademy.springframework.service.WaterBill;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseResultReport implements ResultReport {

    private static final Log log = LogFactory.getLog(BaseResultReport.class);
    public void print(List<WaterBill> waterBillList){
        log.info(setFormat(waterBillList));

    }

    public String setFormat(List<WaterBill> waterBillList){
        String message = "";
        for (int i = 0; i < waterBillList.size(); i++) {
            String city = waterBillList.get(i).getCity();
            String sector = waterBillList.get(i).getSector();
            int unitPrice = waterBillList.get(i).getUnitPrice();
            int usePrice = waterBillList.get(i).getUnitPrice();
            message += "WaterBill{city=' " + city + "', sector='" + sector + "', unitPrice=" + unitPrice + ", billTotal=" + usePrice + " }\n";
        }
        return message;
    }
}
