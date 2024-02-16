package com.ydmins.mybatisopenapi.web.dto;

import lombok.Builder;

@Builder
public class UltraShortForecastSearchDto {
    private String baseDate;
    private String baseTime;
    private int nx;
    private int ny;

    public UltraShortForecastSearchDto(String baseDate, String baseTime, int nx, int ny) {
        this.baseDate = baseDate;
        this.baseTime = baseTime;
        this.nx = nx;
        this.ny = ny;
    }
}
