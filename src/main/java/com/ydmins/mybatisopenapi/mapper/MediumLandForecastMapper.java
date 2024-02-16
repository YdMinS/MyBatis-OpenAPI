package com.ydmins.mybatisopenapi.mapper;

import com.ydmins.mybatisopenapi.model.MediumLandForecast;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface MediumLandForecastMapper {

    void save(MediumLandForecast mediumLandForecast);

    Optional<MediumLandForecast> findByBaseTime(String baseTime);

    void deleteById(String id);

}
