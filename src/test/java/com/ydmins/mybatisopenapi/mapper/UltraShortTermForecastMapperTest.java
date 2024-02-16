package com.ydmins.mybatisopenapi.mapper;

import com.ydmins.mybatisopenapi.model.ShortTermForecast;
import com.ydmins.mybatisopenapi.model.UltraShortTermForecast;
import com.ydmins.mybatisopenapi.web.dto.UltraShortForecastSearchDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UltraShortTermForecastMapperTest {
    @Autowired
    private UltraShortTermForecastMapper mapper;

    String baseDate = "1000";
    String baseTime = "2000";

    @Test
    void testSave() {
        // given
        UltraShortTermForecast ultraShortTermForecast = new UltraShortTermForecast("1234", baseDate, baseTime, "category", "1000",
                "2000", "날씨", 1, 2);
        UltraShortForecastSearchDto dto = new UltraShortForecastSearchDto("1000",
                "2000", 1, 2);
        assertTrue(mapper.checkDuplicate(dto).isEmpty()); // 존재하지 않음을 확인

        // when
        mapper.save(ultraShortTermForecast);
        Optional<UltraShortTermForecast> optionalSavedUltraShortTermForecast = mapper.checkDuplicate(dto);

        // then
        assertTrue(optionalSavedUltraShortTermForecast.isPresent());
        UltraShortTermForecast savedUltraShortTermForecast = optionalSavedUltraShortTermForecast.get();
        assertEquals("1234", savedUltraShortTermForecast.getUltraShortId());
        assertEquals("1000", savedUltraShortTermForecast.getBaseDate());
        assertEquals("2000", savedUltraShortTermForecast.getBaseTime());
        assertEquals("category", savedUltraShortTermForecast.getCategory());
        assertEquals("1000", savedUltraShortTermForecast.getFcstDate());
        assertEquals("2000", savedUltraShortTermForecast.getFcstTime());
        assertEquals("날씨", savedUltraShortTermForecast.getFcstValue());
        assertEquals(1, savedUltraShortTermForecast.getNx());
        assertEquals(2, savedUltraShortTermForecast.getNy());

        // rollback
        mapper.deleteById("1234");

        // then
        assertTrue(mapper.checkDuplicate(dto).isEmpty());
    }

    @Test
    void testCheckDuplicate() {
        // given
        UltraShortTermForecast ultraShortTermForecast = new UltraShortTermForecast("1234", baseDate, baseTime, "category", "1000",
                "2000", "날씨", 1, 2);
        UltraShortForecastSearchDto dto = new UltraShortForecastSearchDto("1000",
                "2000", 1, 2);
        assertTrue(mapper.checkDuplicate(dto).isEmpty()); // 존재하지 않음을 확인
        mapper.save(ultraShortTermForecast);

        // when
        Optional<UltraShortTermForecast> optionalSavedUltraShortTermForecast = mapper.checkDuplicate(dto);

        // then
        assertTrue(optionalSavedUltraShortTermForecast.isPresent());
        UltraShortTermForecast savedUltraShortTermForecast = optionalSavedUltraShortTermForecast.get();
        assertEquals("1234", savedUltraShortTermForecast.getUltraShortId());

        // rollback
        mapper.deleteById("1234");

        // then
        assertTrue(mapper.checkDuplicate(dto).isEmpty());
    }

    @Test
    void testDeleteById() {
        // given
        UltraShortTermForecast ultraShortTermForecast = new UltraShortTermForecast("1234", baseDate, baseTime, "category", "1000",
                "2000", "날씨", 1, 2);
        UltraShortForecastSearchDto dto = new UltraShortForecastSearchDto("1000",
                "2000", 1, 2);
        assertTrue(mapper.checkDuplicate(dto).isEmpty()); // 존재하지 않음을 확인
        mapper.save(ultraShortTermForecast);
        Optional<UltraShortTermForecast> optionalSavedUltraShortTermForecast = mapper.checkDuplicate(dto);
        assertTrue(optionalSavedUltraShortTermForecast.isPresent());

        // when
        mapper.deleteById("1234");

        // then
        assertTrue(mapper.checkDuplicate(dto).isEmpty());
    }
}