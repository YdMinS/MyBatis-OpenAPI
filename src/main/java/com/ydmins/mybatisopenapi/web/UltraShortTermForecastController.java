package com.ydmins.mybatisopenapi.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ydmins.mybatisopenapi.model.UltraShortTermForecast;
import com.ydmins.mybatisopenapi.service.UltraShortTermForecastService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UltraShortTermForecastController {
    @Autowired
    private UltraShortTermForecastService ultraShortTermForecastService;

    @Transactional
    @GetMapping("/api/v1/ultra-short-forecast")
    public List<UltraShortTermForecast> saveUltraShortTermForecast() throws JsonProcessingException {
        String[] dateTime = ultraShortTermForecastService.timeCalculate();
        String baseDate = dateTime[0];
        String baseTime = dateTime[1];
        int nx = 55;
        int ny = 127;

        return ultraShortTermForecastService.requestDataAndSave(baseDate, baseTime, nx, ny);
    }

    @GetMapping("/api/v1/search-ultra-short-forecast")
    public UltraShortTermForecast getUltraShortTermForecast(){
        String[] dateTime = ultraShortTermForecastService.timeCalculate();
        String baseDate = dateTime[0];
        String baseTime = dateTime[1];
        int nx = 55;
        int ny = 127;

        return ultraShortTermForecastService.getOneData(baseDate, baseTime, nx, ny);

    }
}
