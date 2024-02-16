package com.ydmins.mybatisopenapi.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.ydmins.mybatisopenapi.model.ShortTermForecast;

import java.util.List;

public interface ShortTermForecastService {

    String[] timeCalculate();

    JsonNode getJson(String baseDate, String baseTime, int nx, int ny) throws JsonProcessingException;

    List<ShortTermForecast> requestDataAndSave(String baseDate, String baseTime, int nx, int ny) throws JsonProcessingException;

    ShortTermForecast getOneData(int nx, int ny);
}
