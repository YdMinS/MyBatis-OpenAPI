package com.ydmins.mybatisopenapi.mapper;

import com.ydmins.mybatisopenapi.model.MediumTemperatureForecast;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MediumTemperatureForecastMapperTest {
    @Autowired
    private MediumTemperatureForecastMapper mapper;

    String time = "100010201000";

    @Test
    void testSave() {
        // given
        MediumTemperatureForecast mediumTemperatureForecast = new MediumTemperatureForecast("1234", time, "109",
                // 48 ta* values
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
                21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
                41, 42, 43, 44, 45, 46, 47, 48);
        assertTrue(mapper.findByBaseTime(time).isEmpty());

        // when
        mapper.save(mediumTemperatureForecast);
        Optional<MediumTemperatureForecast> optionalSavedMediumTemperatureForecast = mapper.findByBaseTime(time);

        // then
        assertNotNull(optionalSavedMediumTemperatureForecast);
        MediumTemperatureForecast savedMediumTemperatrueForecast = optionalSavedMediumTemperatureForecast.get();
        assertEquals("1234", savedMediumTemperatrueForecast.getMediumTempId());
        assertEquals(time, savedMediumTemperatrueForecast.getTmFc());
        assertEquals("109", savedMediumTemperatrueForecast.getRegId());
        assertEquals(1, savedMediumTemperatrueForecast.getTaMin3());
        assertEquals(2, savedMediumTemperatrueForecast.getTaMin3Low());
        assertEquals(3, savedMediumTemperatrueForecast.getTaMin3High());
        assertEquals(4, savedMediumTemperatrueForecast.getTaMax3());
        assertEquals(5, savedMediumTemperatrueForecast.getTaMax3Low());
        assertEquals(6, savedMediumTemperatrueForecast.getTaMax3High());
        assertEquals(7, savedMediumTemperatrueForecast.getTaMin4());
        assertEquals(8, savedMediumTemperatrueForecast.getTaMin4Low());
        assertEquals(9, savedMediumTemperatrueForecast.getTaMin4High());
        assertEquals(10, savedMediumTemperatrueForecast.getTaMax4());
        assertEquals(11, savedMediumTemperatrueForecast.getTaMax4Low());
        assertEquals(12, savedMediumTemperatrueForecast.getTaMax4High());
        assertEquals(13, savedMediumTemperatrueForecast.getTaMin5());
        assertEquals(14, savedMediumTemperatrueForecast.getTaMin5Low());
        assertEquals(15, savedMediumTemperatrueForecast.getTaMin5High());
        assertEquals(16, savedMediumTemperatrueForecast.getTaMax5());
        assertEquals(17, savedMediumTemperatrueForecast.getTaMax5Low());
        assertEquals(18, savedMediumTemperatrueForecast.getTaMax5High());
        assertEquals(19, savedMediumTemperatrueForecast.getTaMin6());
        assertEquals(20, savedMediumTemperatrueForecast.getTaMin6Low());
        assertEquals(21, savedMediumTemperatrueForecast.getTaMin6High());
        assertEquals(22, savedMediumTemperatrueForecast.getTaMax6());
        assertEquals(23, savedMediumTemperatrueForecast.getTaMax6Low());
        assertEquals(24, savedMediumTemperatrueForecast.getTaMax6High());
        assertEquals(25, savedMediumTemperatrueForecast.getTaMin7());
        assertEquals(26, savedMediumTemperatrueForecast.getTaMin7Low());
        assertEquals(27, savedMediumTemperatrueForecast.getTaMin7High());
        assertEquals(28, savedMediumTemperatrueForecast.getTaMax7());
        assertEquals(29, savedMediumTemperatrueForecast.getTaMax7Low());
        assertEquals(30, savedMediumTemperatrueForecast.getTaMax7High());
        assertEquals(31, savedMediumTemperatrueForecast.getTaMin8());
        assertEquals(32, savedMediumTemperatrueForecast.getTaMin8Low());
        assertEquals(33, savedMediumTemperatrueForecast.getTaMin8High());
        assertEquals(34, savedMediumTemperatrueForecast.getTaMax8());
        assertEquals(35, savedMediumTemperatrueForecast.getTaMax8Low());
        assertEquals(36, savedMediumTemperatrueForecast.getTaMax8High());
        assertEquals(37, savedMediumTemperatrueForecast.getTaMin9());
        assertEquals(38, savedMediumTemperatrueForecast.getTaMin9Low());
        assertEquals(39, savedMediumTemperatrueForecast.getTaMin9High());
        assertEquals(40, savedMediumTemperatrueForecast.getTaMax9());
        assertEquals(41, savedMediumTemperatrueForecast.getTaMax9Low());
        assertEquals(42, savedMediumTemperatrueForecast.getTaMax9High());
        assertEquals(43, savedMediumTemperatrueForecast.getTaMin10());
        assertEquals(44, savedMediumTemperatrueForecast.getTaMin10Low());
        assertEquals(45, savedMediumTemperatrueForecast.getTaMin10High());
        assertEquals(46, savedMediumTemperatrueForecast.getTaMax10());
        assertEquals(47, savedMediumTemperatrueForecast.getTaMax10Low());
        assertEquals(48, savedMediumTemperatrueForecast.getTaMax10High());

        // rollback
        mapper.deleteById("1234");

        // after rollback
        Optional<MediumTemperatureForecast> optionalMediumTemperatureForecast = mapper.findByBaseTime(time);

        // then
        assertTrue(optionalMediumTemperatureForecast.isEmpty());
    }

    @Test
    void testFindByBaseTime() {
        // given
        MediumTemperatureForecast mediumTemperatureForecast = new MediumTemperatureForecast("1234", time, "109",
                // 48 ta* values
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
                21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
                41, 42, 43, 44, 45, 46, 47, 48);
        assertTrue(mapper.findByBaseTime(time).isEmpty());
        mapper.save(mediumTemperatureForecast);

        // when
        Optional<MediumTemperatureForecast> optionalSavedMediumTemperatureForecast = mapper.findByBaseTime(time);

        // then
        assertNotNull(optionalSavedMediumTemperatureForecast);

        // rollback
        mapper.deleteById("1234");

        // after rollback
        Optional<MediumTemperatureForecast> optionalMediumTemperatureForecast = mapper.findByBaseTime(time);

        // then
        assertTrue(optionalMediumTemperatureForecast.isEmpty());
    }

    @Test
    void testDeleteById() {
        // given
        MediumTemperatureForecast mediumTemperatureForecast = new MediumTemperatureForecast("1234", time, "109",
                // 48 ta* values
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
                21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
                41, 42, 43, 44, 45, 46, 47, 48);
        assertTrue(mapper.findByBaseTime(time).isEmpty()); // 존재하지 않음을 확인

        mapper.save(mediumTemperatureForecast);
        assertTrue(mapper.findByBaseTime(time).isPresent()); // 저장됨을 확인

        // when
        mapper.deleteById("1234");

        // then
        Optional<MediumTemperatureForecast> optionalMediumTemperatureForecast = mapper.findByBaseTime(time);
        assertTrue(optionalMediumTemperatureForecast.isEmpty());
    }
}