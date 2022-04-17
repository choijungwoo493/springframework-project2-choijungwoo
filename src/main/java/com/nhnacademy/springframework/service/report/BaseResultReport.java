package com.nhnacademy.springframework.service.report;

import com.nhnacademy.springframework.service.WaterBill;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseResultReport implements ResultReport {

    private static final Log log = LogFactory.getLog(BaseResultReport.class);
    public void printResult(List<WaterBill> waterBillList,int waterUse){
        log.info(setFormat(waterBillList, waterUse));
    }

    public String setFormat(List<WaterBill> waterBillList,int waterUse){
        String message = "\n";
        for (int i = 0; i < waterBillList.size(); i++) {
            String city = waterBillList.get(i).getCity();
            String sector = waterBillList.get(i).getSector();
            int unitPrice = waterBillList.get(i).getUnitPrice();
            int usePrice = waterBillList.get(i).getUnitPrice() * waterUse;
            message += "WaterBill{city=' " + city + "', sector='" + sector + "', unitPrice=" + unitPrice + ", billTotal=" + usePrice + " }\n";
        }
        return message;
    }
}
