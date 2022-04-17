package com.nhnacademy.springframework.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WaterBill {
    @JsonProperty("순번")
    private int waterBillSeq;
    @JsonProperty("지자체명")
    private String city;
    @JsonProperty("업종")
    private String sector;
    @JsonProperty("단계")
    private int stage;
    @JsonProperty("구간시작(세제곱미터)")
    private int unitStart;
    @JsonProperty("구간끝(세제곱미터)")
    private int unitEnd;
    @JsonProperty("구간금액(원)")
    private int unitPrice;


    public WaterBill(int waterBillSeq, String city, String sector, int stage, int unitStart, int unitEnd, int unitPrice) {
        this.waterBillSeq = waterBillSeq;
        this.city = city;
        this.sector = sector;
        this.stage = stage;
        this.unitStart = unitStart;
        this.unitEnd = unitEnd;
        this.unitPrice = unitPrice;
    }

    public WaterBill() {
    }

    @Override
    public String toString() {
        return "WaterBill{" +
                "waterBillSeq=" + waterBillSeq +
                ", city='" + city + '\'' +
                ", sector='" + sector + '\'' +
                ", stage=" + stage +
                ", unitStart=" + unitStart +
                ", unitEnd=" + unitEnd +
                ", unitPrice=" + unitPrice +
                '}';
    }

    public String getCity() {
        return city;
    }

    public String getSector() {
        return sector;
    }


    public int getUnitStart() {
        return unitStart;
    }

    public int getUnitEnd() {
        return unitEnd;
    }

    public int getUnitPrice() {
        return unitPrice;
    }
}
