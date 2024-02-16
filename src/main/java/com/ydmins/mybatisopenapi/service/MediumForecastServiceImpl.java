package com.ydmins.mybatisopenapi.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ydmins.mybatisopenapi.config.ApiKey;
import com.ydmins.mybatisopenapi.mapper.MediumForecastMapper;
import com.ydmins.mybatisopenapi.model.MediumForecast;
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
public class MediumForecastServiceImpl implements MediumForecastService{
    @Autowired
    private MediumForecastMapper mapper;

    @Autowired
    private MediumForecastCommonService mediumForecastCommonService;

    RestTemplate restTemplate = new RestTemplate();
    ObjectMapper objectMapper = new ObjectMapper();
    private final ApiKey apiKey;

    @Override
    public String getWfSv(int stnId, String tmFc) throws JsonProcessingException {
        String result = null;
        String apiURL = "http://apis.data.go.kr/1360000/MidFcstInfoService/getMidFcst";
        String serviceKey = apiKey.getEncodedServiceKey();
        String dataType = "JSON";
        int pageNo = 4;
        int numOfRows = 100;

        URI uri;
        try {
            uri = new URI(apiURL +
                    "?serviceKey=" + serviceKey +
                    "&pageNo=" + pageNo +
                    "&numOfRows=" + numOfRows +
                    "&dataType=" + dataType +
                    "&stnId=" + stnId +
                    "&tmFc=" + tmFc);
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return null;
        }

        ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, null, String.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            JsonNode responseJson = objectMapper.readTree(response.getBody());
            result =
                    responseJson.path("response").path("body").path("items").path("item").get(0).get("wfSv").toString();
            return result;
        } else {
            System.out.println("API 호출 실패했습니다. 응답 코드 : " + response.getStatusCodeValue());
        }
        return result;
    }

    @Override
    public MediumForecast requestDataAndSave(int stnId) throws JsonProcessingException {
        String tmFc = mediumForecastCommonService.timeCalculate();

        Optional<MediumForecast> optionalMediumForecast = mapper.findByBaseTime(tmFc);
        if(optionalMediumForecast.isEmpty()) {
            String wfSv = getWfSv(stnId, tmFc);
            String mediumForecastId = mediumForecastCommonService.uuidGenerate();
            MediumForecast mediumForecast = new MediumForecast(mediumForecastId, tmFc, stnId, wfSv);
            mapper.save(mediumForecast);
            log.info("SUCCESS getMediumForecast");
            return mediumForecast;
        } else {
            return optionalMediumForecast.get();
        }
    }

    @Override
    public MediumForecast getOneData() {
        String tmFc = mediumForecastCommonService.timeCalculate();

        Optional<MediumForecast> optionalMediumForecast = mapper.findByBaseTime(tmFc);
        if(optionalMediumForecast.isEmpty()){
            return new MediumForecast(null, null, 0, "Not Exist");
        } else {
            return optionalMediumForecast.get();
        }
    }
}
