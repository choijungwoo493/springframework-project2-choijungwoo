package com.nhnacademy.springframework.service;

public class WaterBill {
//    순번 , 지자체명 , 업종 , 단계 , 구간시작(세제곱미터)  , 구간끝(세제곱미터)  , 구간금액(원)  , 단계별 기본요금(원)
//            1, 동두천시 , 가정용 ,1,1,20,690,
    private final int waterBillSeq;
    private final String city;
    private final String sector;
    private final int stage;
    private final int unitStart;
    private final int unitEnd;
    private final int unitPrice;

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

    public WaterBill(int waterBillSeq, String city, String sector, int stage, int unitStart, int unitEnd, int unitPrice) {
        this.waterBillSeq = waterBillSeq;
        this.city = city;
        this.sector = sector;
        this.stage = stage;
        this.unitStart = unitStart;
        this.unitEnd = unitEnd;
        this.unitPrice = unitPrice;
    }

    public int getWaterBillSeq() {
        return waterBillSeq;
    }

    public String getCity() {
        return city;
    }

    public String getSector() {
        return sector;
    }

    public int getStage() {
        return stage;
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
