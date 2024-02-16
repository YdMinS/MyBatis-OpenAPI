package com.ydmins.mybatisopenapi.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ydmins.mybatisopenapi.model.MediumLandForecast;
import com.ydmins.mybatisopenapi.service.MediumLandForecastService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MediumLandForecastController {
    @Autowired
    private MediumLandForecastService mediumLandForecastService;

    @GetMapping("/api/v1/medium-land-forecast")
    MediumLandForecast saveMediumForecast() throws JsonProcessingException {
        String regId = "11B00000";
        return mediumLandForecastService.requestDataAndSave(regId);
    }

    @GetMapping("/api/v1/search-medium-land-forecast")
    MediumLandForecast searchMediumForecast(){
        return mediumLandForecastService.getOneData();
    }

}
