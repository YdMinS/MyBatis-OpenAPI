package com.ydmins.mybatisopenapi.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MediumForecastCommonServiceTest {

    @Test
    void testTimeCalculate() {
        // given
        MediumForecastCommonService service = new MediumForecastCommonServiceImpl();

        // when
        String result = service.timeCalculate();

        // then
        LocalDateTime currentDateTime = LocalDateTime.now();
        String date = currentDateTime.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        int currentTime = Integer.parseInt(currentDateTime.format(DateTimeFormatter.ofPattern("HH")));
        String expectedTime;

        if (currentTime < 6) {
            expectedTime = date + "1800";
        } else if (currentTime >= 6 && currentTime < 18) {
            expectedTime = date + "0600";
        } else {
            expectedTime = date + "1800";
        }

        assertEquals(expectedTime, result);
    }

    @Test
    void testUuidGenerate() {
        // given
        MediumForecastCommonService service = new MediumForecastCommonServiceImpl();

        // when
        String result = service.uuidGenerate();

        // then
        assertTrue(isValidUUID(result));
    }


    private boolean isValidUUID(String uuid){
        try{
            UUID.fromString(uuid);
            return true;
        } catch (IllegalArgumentException ex){
            return false;
        }
    }
}