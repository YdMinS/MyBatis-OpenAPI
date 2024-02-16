package com.ydmins.mybatisopenapi.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ydmins.mybatisopenapi.config.ApiKey;
import com.ydmins.mybatisopenapi.mapper.MediumForecastMapper;
import com.ydmins.mybatisopenapi.mapper.ShortTermForecastMapper;
import com.ydmins.mybatisopenapi.model.ShortTermForecast;
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
public class ShortTermForecastServiceImpl implements ShortTermForecastService{
    @Autowired
    private ShortTermForecastMapper mapper;

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
        int currentTime = Integer.parseInt(currentDateTime.format(DateTimeFormatter.ofPattern("HH")));
        int currentMinute = Integer.parseInt(currentDateTime.format(DateTimeFormatter.ofPattern("mm")));
        int n = (currentTime + 1) / 3;
        if (n == 0) {
            result[0] = currentDateTime.minusDays(1).format(DateTimeFormatter.ofPattern("yyyyMMdd"));
            result[1] = "2300";
        } else if (n > 0 && n < 8) {
            int calculatedTime = n * 3 - 1;
            if (calculatedTime == currentTime && currentMinute < 10) {
                calculatedTime -= 3;
            }
            result[1] = calculatedTime + "00";
        } else {
            if (currentTime < 10) {
                result[1] = "2000";
            } else {
                result[1] = "2300";
            }
        }
        return result;
    }

    @Override
    public JsonNode getJson(String base_date, String base_time, int nx, int ny) throws JsonProcessingException {
        System.out.println(base_date+","+base_time+"/"+nx+","+ny);
        String apiURL = "http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getVilageFcst";
        String serviceKey = apiKey.getEncodedServiceKey();
        int pageNo = 1;
        int numOfRows = 809;
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
    public List<ShortTermForecast> requestDataAndSave(String baseDate, String baseTime, int nx, int ny) throws JsonProcessingException {
        List<ShortTermForecast> list = new ArrayList<>();
        Optional<ShortTermForecast> optionalShortTermForecast =
                mapper.checkDuplicate(new UltraShortForecastSearchDto(baseDate, baseTime, nx, ny));
        if(optionalShortTermForecast.isEmpty()) {
            JsonNode json = getJson(baseDate, baseTime, nx, ny);
            for (int i = 0; i < 700; i++) {
                String ultraShortId = mediumForecastCommonService.uuidGenerate();
                JsonNode _json = json.get(i);
                String category = _json.get("category").toString();
                String fcstDate = _json.get("fcstDate").toString();
                String fcstTime = _json.get("fcstTime").toString();
                String fcstValue = _json.get("fcstValue").toString();
                ShortTermForecast shortTermForecast = new ShortTermForecast(ultraShortId, baseDate,
                        baseTime, category, fcstDate, fcstTime, fcstValue, nx, ny);
                mapper.save(shortTermForecast);
                list.add(shortTermForecast);
            }
        } else {
            list.add(optionalShortTermForecast.get());
        }
        return list;
    }


    @Override
    public ShortTermForecast getOneData(int nx, int ny) {
        String[] dateTime = timeCalculate();
        String baseDate = dateTime[0];
        String baseTime = dateTime[1];

        Optional<ShortTermForecast> optionalShortTermForecast =
                mapper.checkDuplicate(new UltraShortForecastSearchDto(baseDate, baseTime, nx, ny));
        if(optionalShortTermForecast.isEmpty()){
            return new ShortTermForecast(null, baseDate, baseTime, null, null, null, null, nx, ny);
        } else {
            return optionalShortTermForecast.get();
        }
    }
}
