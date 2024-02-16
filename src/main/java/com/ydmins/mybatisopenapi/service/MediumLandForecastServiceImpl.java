package com.ydmins.mybatisopenapi.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ydmins.mybatisopenapi.config.ApiKey;
import com.ydmins.mybatisopenapi.mapper.MediumLandForecastMapper;
import com.ydmins.mybatisopenapi.model.MediumLandForecast;
import com.ydmins.mybatisopenapi.web.dto.MediumLandForecastDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MediumLandForecastServiceImpl implements MediumLandForecastService {
    @Autowired
    private MediumLandForecastMapper mapper;

    @Autowired
    private MediumForecastCommonService mediumForecastCommonService;

    RestTemplate restTemplate = new RestTemplate();
    ObjectMapper objectMapper = new ObjectMapper();
    private final ApiKey apiKey;

    @Override
    public MediumLandForecastDto getDto(String regId, String tmFc) throws JsonProcessingException {
        String apiURL = "http://apis.data.go.kr/1360000/MidFcstInfoService/getMidLandFcst";
        String serviceKey = apiKey.getEncodedServiceKey();
        int pageNo = 1;
        int numOfRows = 100;
        String dataType = "JSON";

        URI uri;
        try {
            uri = new URI(apiURL +
                    "?serviceKey=" + serviceKey +
                    "&pageNo2=" + pageNo +
                    "&numOfRows2=" + numOfRows +
                    "&dataType=" + dataType +
                    "&regId=" + regId +
                    "&tmFc=" + tmFc);
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return null;
        }

        ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, null, String.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            JsonNode responseJson = objectMapper.readTree(response.getBody()).path("response").path("body").path("items").path("item").get(0);
            log.debug(responseJson.toString());
            MediumLandForecastDto dto = new MediumLandForecastDto();
            dto.builder()
                    .rnSt3Am(Integer.parseInt(responseJson.get("rnSt3Am").toString()))
                    .rnSt3Pm(Integer.parseInt(responseJson.get("rnSt3Pm").toString()))
                    .rnSt4Am(Integer.parseInt(responseJson.get("rnSt4Am").toString()))
                    .rnSt4Pm(Integer.parseInt(responseJson.get("rnSt4Pm").toString()))
                    .rnSt5Am(Integer.parseInt(responseJson.get("rnSt5Am").toString()))
                    .rnSt5Pm(Integer.parseInt(responseJson.get("rnSt5Pm").toString()))
                    .rnSt6Am(Integer.parseInt(responseJson.get("rnSt6Am").toString()))
                    .rnSt6Pm(Integer.parseInt(responseJson.get("rnSt6Pm").toString()))
                    .rnSt7Am(Integer.parseInt(responseJson.get("rnSt7Am").toString()))
                    .rnSt7Pm(Integer.parseInt(responseJson.get("rnSt7Pm").toString()))
                    .rnSt8(Integer.parseInt(responseJson.get("rnSt8").toString()))
                    .rnSt9(Integer.parseInt(responseJson.get("rnSt9").toString()))
                    .rnSt10(Integer.parseInt(responseJson.get("rnSt10").toString()))
                    .wf3Am(responseJson.get("wf3Am").toString())
                    .wf3Pm(responseJson.get("wf3Pm").toString())
                    .wf4Am(responseJson.get("wf4Am").toString())
                    .wf4Pm(responseJson.get("wf4Pm").toString())
                    .wf5Am(responseJson.get("wf5Am").toString())
                    .wf5Pm(responseJson.get("wf5Pm").toString())
                    .wf6Am(responseJson.get("wf6Am").toString())
                    .wf6Pm(responseJson.get("wf6Pm").toString())
                    .wf7Am(responseJson.get("wf7Am").toString())
                    .wf7Pm(responseJson.get("wf7Pm").toString())
                    .wf8(responseJson.get("wf8").toString())
                    .wf9(responseJson.get("wf9").toString())
                    .wf10(responseJson.get("wf10").toString()).build();
            return dto;
        } else {
            System.out.println("API 호출 실패했습니다. 응답 코드 : " + response.getStatusCodeValue());
        }
        return null;
    }

    @Override
    public MediumLandForecast requestDataAndSave(String regId) throws JsonProcessingException {
        String tmFc = mediumForecastCommonService.timeCalculate();
        Optional<MediumLandForecast> optionalMediumLandForecast = mapper.findByBaseTime(tmFc);
        if(optionalMediumLandForecast.isEmpty()) {
            MediumLandForecastDto dto = getDto(regId, tmFc);
            String mediumForecastId = mediumForecastCommonService.uuidGenerate();
            MediumLandForecast mediumLandForecast = new MediumLandForecast(mediumForecastId, tmFc, regId, dto);
            mapper.save(mediumLandForecast);
            log.info("SUCCESS getMediumLandForecast");
            return mediumLandForecast;
        } else {
            return optionalMediumLandForecast.get();
        }
    }

    @Override
    public MediumLandForecast getOneData() {
        String tmFc = mediumForecastCommonService.timeCalculate();
        Optional<MediumLandForecast> optionalMediumLandForecast = mapper.findByBaseTime(tmFc);
        if(optionalMediumLandForecast.isEmpty()){
            log.info("DATA DOES NOT EXIST");
            return new MediumLandForecast(null, null, "NOT EXIST");
        } else {
            log.info("DATA EXISTS");
            return optionalMediumLandForecast.get();
        }
    }
}
