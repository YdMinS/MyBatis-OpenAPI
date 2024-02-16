package com.ydmins.mybatisopenapi.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ydmins.mybatisopenapi.model.MediumTemperatureForecast;
import com.ydmins.mybatisopenapi.web.dto.MediumTemperatureForecastDto;

public interface MediumTemperatureForecastService {

    MediumTemperatureForecastDto getDto(String regId, String tmFc) throws JsonProcessingException;

    MediumTemperatureForecast requestDataAndSave(String regId) throws JsonProcessingException;

    MediumTemperatureForecast getOneData();
}
