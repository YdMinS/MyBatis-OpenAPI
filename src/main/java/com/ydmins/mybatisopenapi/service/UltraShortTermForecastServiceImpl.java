package com.ydmins.mybatisopenapi.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ydmins.mybatisopenapi.config.ApiKey;
import com.ydmins.mybatisopenapi.mapper.UltraShortTermForecastMapper;
import com.ydmins.mybatisopenapi.model.UltraShortTermForecast;
import com.ydmins.mybatisopenapi.web.dto.UltraShortForecastSearchDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UltraShortTermForecastServiceImpl implements UltraShortTermForecastService{
    @Autowired
    private UltraShortTermForecastMapper mapper;

    @Autowired
    private MediumForecastCommonService mediumForecastCommonService;

    RestTemplate restTemplate = new RestTemplate();
    ObjectMapper objectMapper = new ObjectMapper();
    private final ApiKey apiKey;

    @Override
    public String[] timeCalculate(){
        String[] result = new String[2];
        LocalDateTime currentDateTime = LocalDateTime.now();
        result[0] = currentDateTime.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        String currentTime;
        int currentMinute = Integer.parseInt(currentDateTime.format(DateTimeFormatter.ofPattern("mm")));
        if (currentMinute >= 45) {
            currentTime = currentDateTime.format(DateTimeFormatter.ofPattern("HH"));
            result[1] = currentTime + "30";
        } else {
            currentTime = currentDateTime.minusHours(1).format(DateTimeFormatter.ofPattern("HH"));
            result[1] = currentTime + "30";        }
        return result;
    }

    @Override
    public JsonNode getJson(String base_date, String base_time, int nx, int ny) throws JsonProcessingException {
        System.out.println(base_date+","+base_time+"/"+nx+","+ny);
        String apiURL = "http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtFcst";
        String serviceKey = apiKey.getEncodedServiceKey();
        int pageNo = 1;
        int numOfRows = 60;
        String dataType = "JSON";

        URI uri;
        try {
            uri = new URI(apiURL +
                    "?serviceKey=" + serviceKey +
                    "&pageNo=" + pageNo +
                    "&numOfRows=" + numOfRows +
                    "&dataType=" + dataType +
                    "&base_date=" + base_date +
                    "&base_time=" + base_time +
                    "&nx=" + nx +
                    "&ny=" + ny);
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return null;
        }

        ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, null, String.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            JsonNode responseJson = objectMapper.readTree(response.getBody()).path("response").path("body").path("items").path("item");
            return responseJson;
        } else {
            System.out.println("API 호출 실패했습니다. 응답 코드 : " + response.getStatusCodeValue());
            return null;
        }
    }

    @Override
    public List<UltraShortTermForecast> requestDataAndSave(String baseDate, String baseTime, int nx, int ny) throws JsonProcessingException {
        List<UltraShortTermForecast> list = new ArrayList<>();
        Optional<UltraShortTermForecast> optionalUltraShortTermForecast =
                mapper.checkDuplicate(new UltraShortForecastSearchDto(baseDate, baseTime, nx, ny));
        if(optionalUltraShortTermForecast.isEmpty()) {
            JsonNode json = getJson(baseDate, baseTime, nx, ny);
            for (int i = 0; i < 60; i++) {
                String ultraShortId = mediumForecastCommonService.uuidGenerate();
                JsonNode _json = json.get(i);
                String category = _json.get("category").toString();
                String fcstDate = _json.get("fcstDate").toString();
                String fcstTime = _json.get("fcstTime").toString();
                String fcstValue = _json.get("fcstValue").toString();
                UltraShortTermForecast ultraShortTermForecast = new UltraShortTermForecast(ultraShortId, baseDate,
                        baseTime, category, fcstDate, fcstTime, fcstValue, nx, ny);
                mapper.save(ultraShortTermForecast);
                System.out.println(i);
                list.add(ultraShortTermForecast);
            }
        } else {
            list.add(optionalUltraShortTermForecast.get());
        }
        return list;
    }

    @Override
    public UltraShortTermForecast getOneData(String baseDate, String baseTime, int nx, int ny) {
        Optional<UltraShortTermForecast> optionalUltraShortTermForecast =
                mapper.checkDuplicate(new UltraShortForecastSearchDto(baseDate, baseTime, nx, ny));
        if(optionalUltraShortTermForecast.isEmpty()){
            return new UltraShortTermForecast(null, baseDate, baseTime, null, null, null, null, nx, ny);
        } else {
            return optionalUltraShortTermForecast.get();
        }
    }

}
