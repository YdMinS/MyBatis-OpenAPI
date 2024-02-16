package com.ydmins.mybatisopenapi.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ydmins.mybatisopenapi.model.MediumLandForecast;
import com.ydmins.mybatisopenapi.web.dto.MediumLandForecastDto;

public interface MediumLandForecastService {

    MediumLandForecastDto getDto(String regId, String tmFc) throws JsonProcessingException;

    MediumLandForecast requestDataAndSave(String regId) throws JsonProcessingException;

    MediumLandForecast getOneData();
}
