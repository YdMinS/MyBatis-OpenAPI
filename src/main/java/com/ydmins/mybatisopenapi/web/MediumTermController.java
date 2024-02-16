package com.ydmins.mybatisopenapi.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ydmins.mybatisopenapi.model.MediumForecast;
import com.ydmins.mybatisopenapi.service.MediumForecastService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MediumTermController {
    @Autowired
    private MediumForecastService mediumForecastService;

    @GetMapping("/api/v1/medium-forecast")
    MediumForecast saveMediumForecast() throws JsonProcessingException {
        int stnId = 109;
        return mediumForecastService.requestDataAndSave(stnId);
    }

    @GetMapping("/api/v1/search-medium-forecast")
    MediumForecast searchMediumForecast(){
        return mediumForecastService.getOneData();
    }

}