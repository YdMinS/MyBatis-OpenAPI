package com.ydmins.mybatisopenapi.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ydmins.mybatisopenapi.model.ShortTermForecast;
import com.ydmins.mybatisopenapi.service.ShortTermForecastService;
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
public class ShortTermForecastController {
    @Autowired
    private ShortTermForecastService shortTermForecastService;

    @Transactional
    @GetMapping("/api/v1/short-forecast")
    public List<ShortTermForecast> saveUltraShortTermForecast() throws JsonProcessingException {
        String[] dateTime = shortTermForecastService.timeCalculate();
        String baseDate = dateTime[0];
        String baseTime = dateTime[1];
        int nx = 55;
        int ny = 127;

        List<ShortTermForecast> list = shortTermForecastService.requestDataAndSave(baseDate, baseTime, nx, ny);

        return list;

    }

    @GetMapping("/api/v1/search-short-forecast")
    public ShortTermForecast getUltraShortTermForecast(){
        int nx = 55;
        int ny = 127;

        ShortTermForecast shortTermForecast = shortTermForecastService.getOneData(nx, ny);
        return shortTermForecast;
    }
}
