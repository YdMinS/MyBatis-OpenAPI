package com.ydmins.mybatisopenapi.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class MediumForecastCommonServiceImpl implements MediumForecastCommonService {

    @Override
    public String timeCalculate() {
        log.info("Executed : MediumForecastService.timeCalculate");
        String resultTime;
        LocalDateTime currentDateTime = LocalDateTime.now();
        String date;
        int currentTime = Integer.parseInt(currentDateTime.format(DateTimeFormatter.ofPattern("HH")));
        if (currentTime < 6) {
            date = currentDateTime.minusDays(1).format(DateTimeFormatter.ofPattern("yyyyMMdd"));
            resultTime = date + "1800";
        } else if (currentTime >= 6 && currentTime < 18) {
            date = currentDateTime.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
            resultTime = date + "0600";
        } else {
            date = currentDateTime.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
            resultTime = date + "1800";
        }
        return resultTime;
    }

    @Override
    public String uuidGenerate() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

}