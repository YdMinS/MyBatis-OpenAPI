package com.ydmins.mybatisopenapi.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.ydmins.mybatisopenapi.model.UltraShortTermForecast;

import java.util.List;

public interface UltraShortTermForecastService {

    String[] timeCalculate();

    JsonNode getJson(String baseDate, String baseTime, int nx, int ny) throws JsonProcessingException;

    List<UltraShortTermForecast> requestDataAndSave(String baseDate, String baseTime, int nx, int ny) throws JsonProcessingException;

    UltraShortTermForecast getOneData(String baseDate, String baseTime, int nx, int ny);
}
