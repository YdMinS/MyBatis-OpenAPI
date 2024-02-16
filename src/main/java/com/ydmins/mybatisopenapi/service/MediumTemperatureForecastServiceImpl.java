package com.ydmins.mybatisopenapi.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ydmins.mybatisopenapi.config.ApiKey;
import com.ydmins.mybatisopenapi.mapper.MediumTemperatureForecastMapper;
import com.ydmins.mybatisopenapi.model.MediumTemperatureForecast;
import com.ydmins.mybatisopenapi.web.dto.MediumTemperatureForecastDto;
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
public class MediumTemperatureForecastServiceImpl implements MediumTemperatureForecastService {
    @Autowired
    private MediumTemperatureForecastMapper mapper;

    @Autowired
    private MediumForecastCommonService mediumForecastCommonService;

    RestTemplate restTemplate = new RestTemplate();
    ObjectMapper objectMapper = new ObjectMapper();
    private final ApiKey apiKey;

    @Override
    public MediumTemperatureForecastDto getDto(String regId, String tmFc) throws JsonProcessingException {
        String apiURL = "http://apis.data.go.kr/1360000/MidFcstInfoService/getMidTa";
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
            MediumTemperatureForecastDto dto = new MediumTemperatureForecastDto();
            dto.builder()
                    .taMin3(Integer.parseInt(responseJson.get("taMin3").toString()))
                .taMin3Low(Integer.parseInt(responseJson.get("taMin3Low").toString()) )
                .taMin3High(Integer.parseInt(responseJson.get("taMin3High").toString()) )
                .taMax3(Integer.parseInt(responseJson.get("taMax3").toString()) )
                .taMax3Low(Integer.parseInt(responseJson.get("taMax3Low").toString()) )
                .taMax3High(Integer.parseInt(responseJson.get("taMax3High").toString()) )
                .taMin4(Integer.parseInt(responseJson.get("taMin4").toString()) )
                .taMin4Low(Integer.parseInt(responseJson.get("taMin4Low").toString()) )
                .taMin4High(Integer.parseInt(responseJson.get("taMin4High").toString()) )
                .taMax4(Integer.parseInt(responseJson.get("taMax4").toString()) )
                .taMax4Low(Integer.parseInt(responseJson.get("taMax4Low").toString()))
                .taMax4High(Integer.parseInt(responseJson.get("taMax4High").toString()))
                .taMin5(Integer.parseInt(responseJson.get("taMin5").toString()))
                .taMin5Low(Integer.parseInt(responseJson.get("taMin5Low").toString()))
                .taMin5High(Integer.parseInt(responseJson.get("taMin5High").toString()))
                .taMax5(Integer.parseInt(responseJson.get("taMax5").toString()))
                .taMax5Low(Integer.parseInt(responseJson.get("taMax5Low").toString()))
                .taMax5High(Integer.parseInt(responseJson.get("taMax5High").toString()))
                .taMin6(Integer.parseInt(responseJson.get("taMin6").toString()))
                .taMin6Low(Integer.parseInt(responseJson.get("taMin6Low").toString()))
                .taMin6High(Integer.parseInt(responseJson.get("taMin6High").toString()))
                .taMax6(Integer.parseInt(responseJson.get("taMax6").toString()))
                .taMax6Low(Integer.parseInt(responseJson.get("taMax6Low").toString()))
                .taMax6High(Integer.parseInt(responseJson.get("taMax6High").toString()))
                .taMin7(Integer.parseInt(responseJson.get("taMin7").toString()))
                .taMin7Low(Integer.parseInt(responseJson.get("taMin7Low").toString()))
                .taMin7High(Integer.parseInt(responseJson.get("taMin7High").toString()))
                .taMax7(Integer.parseInt(responseJson.get("taMax7").toString()))
                .taMax7Low(Integer.parseInt(responseJson.get("taMax7Low").toString()))
                .taMax7High(Integer.parseInt(responseJson.get("taMax7High").toString()))
                .taMin8(Integer.parseInt(responseJson.get("taMin8").toString()))
                .taMin8Low(Integer.parseInt(responseJson.get("taMin8Low").toString()))
                .taMin8High(Integer.parseInt(responseJson.get("taMin8High").toString()))
                .taMax8(Integer.parseInt(responseJson.get("taMax8").toString()))
                .taMax8Low(Integer.parseInt(responseJson.get("taMax8Low").toString()))
                .taMax8High(Integer.parseInt(responseJson.get("taMax8High").toString()))
                .taMin9(Integer.parseInt(responseJson.get("taMin9").toString()))
                .taMin9Low(Integer.parseInt(responseJson.get("taMin9Low").toString()))
                .taMin9High(Integer.parseInt(responseJson.get("taMin9High").toString()))
                .taMax9(Integer.parseInt(responseJson.get("taMax9").toString()))
                .taMax9Low(Integer.parseInt(responseJson.get("taMax9Low").toString()))
                .taMax9High(Integer.parseInt(responseJson.get("taMax9High").toString()))
                .taMin10(Integer.parseInt(responseJson.get("taMin10").toString()))
                .taMin10Low(Integer.parseInt(responseJson.get("taMin10Low").toString()))
                .taMin10High(Integer.parseInt(responseJson.get("taMin10High").toString()))
                .taMax10(Integer.parseInt(responseJson.get("taMax10").toString()))
                .taMax10Low(Integer.parseInt(responseJson.get("taMax10Low").toString()))
                .taMax10High(Integer.parseInt(responseJson.get("taMax10High").toString())).build();
            return dto;
        } else {
            System.out.println("API 호출 실패했습니다. 응답 코드 : " + response.getStatusCodeValue());
        }
        return null;
    }

    @Override
    public MediumTemperatureForecast requestDataAndSave(String regId) throws JsonProcessingException {
        String tmFc = mediumForecastCommonService.timeCalculate();
        Optional<MediumTemperatureForecast> optionalMediumTemperatureForecast = mapper.findByBaseTime(tmFc);
        if(optionalMediumTemperatureForecast.isEmpty()) {
            MediumTemperatureForecastDto dto = getDto(regId, tmFc);
            String mediumTempId = mediumForecastCommonService.uuidGenerate();
            MediumTemperatureForecast mediumTemperatureForecast = new MediumTemperatureForecast(mediumTempId, tmFc, regId, dto);
            mapper.save(mediumTemperatureForecast);
            log.info("SUCCESS getMediumTemperatureForecast");
            return mediumTemperatureForecast;
        } else {
            return optionalMediumTemperatureForecast.get();
        }
    }

    @Override
    public MediumTemperatureForecast getOneData() {
        String tmFc = mediumForecastCommonService.timeCalculate();
        Optional<MediumTemperatureForecast> optionalMediumTemperatureForecast = mapper.findByBaseTime(tmFc);
        if(optionalMediumTemperatureForecast.isEmpty()){
            log.info("DATA DOES NOT EXIST");
            return new MediumTemperatureForecast(null, null, "NOT EXIST");
        } else {
            log.info("DATA EXISTS");
            return optionalMediumTemperatureForecast.get();
        }
    }
}
