package com.ydmins.mybatisopenapi.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ShortTermForecast {

    private String shortId;
    private String baseDate;
    private String baseTime;

    private String category;
    private String fcstDate;
    private String fcstTime;
    private String fcstValue;
    private int nx;
    private int ny;

    public ShortTermForecast() {
    }

    public ShortTermForecast(String shortId, String baseDate, String baseTime, String category, String fcstDate, String fcstTime, String fcstValue, int nx, int ny) {
        this.shortId = shortId;
        this.baseDate = baseDate;
        this.baseTime = baseTime;
        this.category = category;
        this.fcstDate = fcstDate;
        this.fcstTime = fcstTime;
        this.fcstValue = fcstValue;
        this.nx = nx;
        this.ny = ny;
    }
}
