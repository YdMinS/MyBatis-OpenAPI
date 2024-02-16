package com.ydmins.mybatisopenapi.mapper;

import com.ydmins.mybatisopenapi.model.MediumForecast;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MediumForecastMapperTest {
    @Autowired
    private MediumForecastMapper mapper;

    String time = "100010201000";

    @Test
    void testSave() {
        // given
        MediumForecast mediumForecast =
                new MediumForecast("1234", time, 109, "Test Text");
        assertTrue(mapper.findByBaseTime(time).isEmpty());

        // when
        mapper.save(mediumForecast);
        Optional<MediumForecast> optionalSavedMediumForecast = mapper.findByBaseTime(time);

        // then
        assertNotNull(optionalSavedMediumForecast);
        MediumForecast savedMediumForecast = optionalSavedMediumForecast.get();
        assertEquals("1234", savedMediumForecast.getMediumTermId());
        assertEquals(time, savedMediumForecast.getTmFc());
        assertEquals(109, savedMediumForecast.getStnId());
        assertEquals("Test Text", savedMediumForecast.getWfSv());

        // rollback
        mapper.deleteById("1234");

        // after rollback
        Optional<MediumForecast> optionalMediumForecast = mapper.findByBaseTime(time);

        // then
        assertTrue(optionalMediumForecast.isEmpty());
    }

    @Test
    void testFindByBaseTime() {
        // given
        MediumForecast mediumForecast =
                new MediumForecast("1234", time, 109, "Test Text");
        mapper.save(mediumForecast);

        // when
        Optional<MediumForecast> optionalSavedMediumForecast = mapper.findByBaseTime(time);

        // then
        assertNotNull(optionalSavedMediumForecast);
        MediumForecast savedMediumForecast = optionalSavedMediumForecast.get();
        assertEquals("1234", savedMediumForecast.getMediumTermId());
        assertEquals(time, savedMediumForecast.getTmFc());
        assertEquals(109, savedMediumForecast.getStnId());
        assertEquals("Test Text", savedMediumForecast.getWfSv());

        // rollback
        mapper.deleteById("1234");

        // after rollback
        Optional<MediumForecast> optionalMediumForecast = mapper.findByBaseTime(time);

        // then
        assertTrue(optionalMediumForecast.isEmpty());
    }

    @Test
    void testDeleteById() {
        // given
        MediumForecast mediumForecast =
                new MediumForecast("1234", time, 109, "Test Text");
        mapper.save(mediumForecast);
        Optional<MediumForecast> optionalSavedMediumForecast = mapper.findByBaseTime(time);

        // then 1
        assertNotNull(optionalSavedMediumForecast);

        // when
        mapper.deleteById("1234");

        // then 2
        Optional<MediumForecast> optionalMediumForecast = mapper.findByBaseTime(time);
        assertTrue(optionalMediumForecast.isEmpty());
    }
}