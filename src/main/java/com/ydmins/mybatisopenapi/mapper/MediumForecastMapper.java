package com.ydmins.mybatisopenapi.mapper;

import com.ydmins.mybatisopenapi.model.MediumForecast;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface MediumForecastMapper {

    void save(MediumForecast mediumForecast);

    Optional<MediumForecast> findByBaseTime(String baseTime);

    void deleteById(String id);
}
