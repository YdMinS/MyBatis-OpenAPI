package com.ydmins.mybatisopenapi.mapper;

import com.ydmins.mybatisopenapi.model.UltraShortTermForecast;
import com.ydmins.mybatisopenapi.web.dto.UltraShortForecastSearchDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface UltraShortTermForecastMapper {

    void save (UltraShortTermForecast ultraShortTermForecast);

    Optional<UltraShortTermForecast> checkDuplicate(UltraShortForecastSearchDto dto);

    void deleteById(String id);

}
