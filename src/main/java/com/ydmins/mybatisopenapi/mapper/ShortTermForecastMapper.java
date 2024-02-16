package com.ydmins.mybatisopenapi.mapper;

import com.ydmins.mybatisopenapi.model.ShortTermForecast;
import com.ydmins.mybatisopenapi.web.dto.UltraShortForecastSearchDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface ShortTermForecastMapper {

    void save (ShortTermForecast shortTermForecast);

    Optional<ShortTermForecast> checkDuplicate(UltraShortForecastSearchDto dto);

    void deleteById(String id);

}
