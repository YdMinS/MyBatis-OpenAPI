package com.ydmins.mybatisopenapi.mapper;

import com.ydmins.mybatisopenapi.model.ShortTermForecast;
import com.ydmins.mybatisopenapi.web.dto.UltraShortForecastSearchDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ShortTermForecastMapperTest {
    @Autowired
    private ShortTermForecastMapper mapper;

    String baseDate = "1000";
    String baseTime = "2000";

    @Test
    void testSave() {
        // given
        ShortTermForecast shortTermForecast = new ShortTermForecast("1234", baseDate, baseTime, "category", "1000",
                "2000", "날씨", 1, 2);
        UltraShortForecastSearchDto dto = new UltraShortForecastSearchDto("1000",
                "2000", 1, 2);
        assertTrue(mapper.checkDuplicate(dto).isEmpty()); // 존재하지 않음을 확인

        // when
        mapper.save(shortTermForecast);
        Optional<ShortTermForecast> optionalSavedShortTermForecast = mapper.checkDuplicate(dto);

        // then
        assertTrue(optionalSavedShortTermForecast.isPresent());
        ShortTermForecast savedShortTermForecast = optionalSavedShortTermForecast.get();
        assertEquals("1234", savedShortTermForecast.getShortId());
        assertEquals("1000", savedShortTermForecast.getBaseDate());
        assertEquals("2000", savedShortTermForecast.getBaseTime());
        assertEquals("category", savedShortTermForecast.getCategory());
        assertEquals("1000", savedShortTermForecast.getFcstDate());
        assertEquals("2000", savedShortTermForecast.getFcstTime());
        assertEquals("날씨", savedShortTermForecast.getFcstValue());
        assertEquals(1, savedShortTermForecast.getNx());
        assertEquals(2, savedShortTermForecast.getNy());

        // rollback
        mapper.deleteById("1234");

        // then
        assertTrue(mapper.checkDuplicate(dto).isEmpty());
    }

    @Test
    void testCheckDuplicate() {
        // given
        ShortTermForecast shortTermForecast = new ShortTermForecast("1234", baseDate, baseTime, "category", "1000",
                "2000", "날씨", 1, 2);
        UltraShortForecastSearchDto dto = new UltraShortForecastSearchDto("1000",
                "2000", 1, 2);
        assertTrue(mapper.checkDuplicate(dto).isEmpty()); // 존재하지 않음을 확인
        mapper.save(shortTermForecast);

        // when
        Optional<ShortTermForecast> optionalSavedShortTermForecast = mapper.checkDuplicate(dto);

        // then
        assertTrue(optionalSavedShortTermForecast.isPresent());
        ShortTermForecast savedShortTermForecast = optionalSavedShortTermForecast.get();
        assertEquals("1234", savedShortTermForecast.getShortId());

        // rollback
        mapper.deleteById("1234");

        // then
        assertTrue(mapper.checkDuplicate(dto).isEmpty());
    }

    @Test
    void testDeleteById() {
        // given
        ShortTermForecast shortTermForecast = new ShortTermForecast("1234", baseDate, baseTime, "category", "1000",
                "2000", "날씨", 1, 2);
        UltraShortForecastSearchDto dto = new UltraShortForecastSearchDto("1000",
                "2000", 1, 2);
        assertTrue(mapper.checkDuplicate(dto).isEmpty()); // 존재하지 않음을 확인
        mapper.save(shortTermForecast);
        Optional<ShortTermForecast> optionalSavedShortTermForecast = mapper.checkDuplicate(dto);
        assertTrue(optionalSavedShortTermForecast.isPresent());

        // when
        mapper.deleteById("1234");

        // then
        assertTrue(mapper.checkDuplicate(dto).isEmpty());
    }
}