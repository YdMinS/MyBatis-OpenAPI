package com.ydmins.mybatisopenapi.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ydmins.mybatisopenapi.model.MediumForecast;

public interface MediumForecastService{

    String getWfSv(int stnId, String tmFc) throws JsonProcessingException;

    MediumForecast requestDataAndSave(int stnId) throws JsonProcessingException;

    MediumForecast getOneData();
}
