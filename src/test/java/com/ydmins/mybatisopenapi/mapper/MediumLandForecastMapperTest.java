package com.ydmins.mybatisopenapi.mapper;

import com.ydmins.mybatisopenapi.model.MediumLandForecast;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MediumLandForecastMapperTest {
    @Autowired
    private MediumLandForecastMapper mapper;

    String time = "100010401000";

    @Test
    void testSave() {
        // given
        MediumLandForecast mediumLandForecast =
                new MediumLandForecast("1234", time, "109",
                        // 13 rnSt* arguments
                        1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13,
                        // 13 wf* arguments
                        "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13"
                        );
        assertTrue(mapper.findByBaseTime(time).isEmpty()); // 존재하지 않음을 확인

        // when
        mapper.save(mediumLandForecast);
        Optional<MediumLandForecast> optinalSavedMediumLandForecast = mapper.findByBaseTime(time);

        // then
        assertNotNull(optinalSavedMediumLandForecast);
        MediumLandForecast savedMediumLandForecast = optinalSavedMediumLandForecast.get();
        assertEquals("1234", savedMediumLandForecast.getMediumLandId());
        assertEquals(time, savedMediumLandForecast.getTmFc());
        assertEquals("109", savedMediumLandForecast.getRegId());

        assertEquals(1, savedMediumLandForecast.getRnSt3Am());
        assertEquals(2, savedMediumLandForecast.getRnSt3Pm());
        assertEquals(3, savedMediumLandForecast.getRnSt4Am());
        assertEquals(4, savedMediumLandForecast.getRnSt4Pm());
        assertEquals(5, savedMediumLandForecast.getRnSt5Am());
        assertEquals(6, savedMediumLandForecast.getRnSt5Pm());
        assertEquals(7, savedMediumLandForecast.getRnSt6Am());
        assertEquals(8, savedMediumLandForecast.getRnSt6Pm());
        assertEquals(9, savedMediumLandForecast.getRnSt7Am());
        assertEquals(10, savedMediumLandForecast.getRnSt7Pm());
        assertEquals(11, savedMediumLandForecast.getRnSt8());
        assertEquals(12, savedMediumLandForecast.getRnSt9());
        assertEquals(13, savedMediumLandForecast.getRnSt10());

        assertEquals("1", savedMediumLandForecast.getWf3Am());
        assertEquals("2", savedMediumLandForecast.getWf3Pm());
        assertEquals("3", savedMediumLandForecast.getWf4Am());
        assertEquals("4", savedMediumLandForecast.getWf4Pm());
        assertEquals("5", savedMediumLandForecast.getWf5Am());
        assertEquals("6", savedMediumLandForecast.getWf5Pm());
        assertEquals("7", savedMediumLandForecast.getWf6Am());
        assertEquals("8", savedMediumLandForecast.getWf6Pm());
        assertEquals("9", savedMediumLandForecast.getWf7Am());
        assertEquals("10", savedMediumLandForecast.getWf7Pm());
        assertEquals("11", savedMediumLandForecast.getWf8());
        assertEquals("12", savedMediumLandForecast.getWf9());
        assertEquals("13", savedMediumLandForecast.getWf10());

        // rollback
        mapper.deleteById("1234");

        // after rollback
        Optional<MediumLandForecast> optionalMediumLandForecast = mapper.findByBaseTime(time);

        // then
        assertTrue(optionalMediumLandForecast.isEmpty());
    }

    @Test
    void testFindByBaseTime() {
        // given
        MediumLandForecast mediumLandForecast =
                new MediumLandForecast("1234", time, "109",
                        // 13 rnSt* arguments
                        1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13,
                        // 13 wf* arguments
                        "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13"
                );
        assertTrue(mapper.findByBaseTime(time).isEmpty()); // 존재하지 않음을 확인
        mapper.save(mediumLandForecast);

        // when
        Optional<MediumLandForecast> optinalSavedMediumLandForecast = mapper.findByBaseTime(time);

        // then
        assertNotNull(optinalSavedMediumLandForecast);
        MediumLandForecast savedMediumLandForecast = optinalSavedMediumLandForecast.get();
        assertEquals(time, savedMediumLandForecast.getTmFc());

        // rollback
        mapper.deleteById("1234");

        // after rollback
        Optional<MediumLandForecast> optionalMediumLandForecast = mapper.findByBaseTime(time);

        // then
        assertTrue(optionalMediumLandForecast.isEmpty());
    }

    @Test
    void testDeleteById() {
        // given
        MediumLandForecast mediumLandForecast =
                new MediumLandForecast("1234", time, "109",
                        // 13 rnSt* arguments
                        1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13,
                        // 13 wf* arguments
                        "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13"
                );
        assertTrue(mapper.findByBaseTime(time).isEmpty()); // 존재하지 않음을 확인
        mapper.save(mediumLandForecast);
        assertNotNull(mapper.findByBaseTime(time)); // 저장됨을 확인

        // when
        mapper.deleteById("1234");

        // then
        assertTrue(mapper.findByBaseTime(time).isEmpty());
    }
}