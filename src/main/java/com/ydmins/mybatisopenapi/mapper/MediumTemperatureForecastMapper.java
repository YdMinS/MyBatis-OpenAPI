package com.ydmins.mybatisopenapi.mapper;

import com.ydmins.mybatisopenapi.model.MediumTemperatureForecast;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface MediumTemperatureForecastMapper {

    void save(MediumTemperatureForecast mediumTemperatureForecast);

    Optional<MediumTemperatureForecast> findByBaseTime(String baseTime);

    void deleteById(String id);

}
