package com.ydmins.mybatisopenapi.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ydmins.mybatisopenapi.model.MediumTemperatureForecast;
import com.ydmins.mybatisopenapi.service.MediumTemperatureForecastService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MediumTemperatureController {
    @Autowired
    private MediumTemperatureForecastService mediumTemperatureForecastService;

    @GetMapping("/api/v1/medium-temperature-forecast")
    MediumTemperatureForecast saveMediumForecast() throws JsonProcessingException {
        String regId = "11B00000";
        return mediumTemperatureForecastService.requestDataAndSave(regId);
    }

    @GetMapping("/api/v1/search-medium-temperature-forecast")
    MediumTemperatureForecast searchMediumTemperatureForecast(){
        return mediumTemperatureForecastService.getOneData();
    }

}