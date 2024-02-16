package com.ydmins.mybatisopenapi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApiKey {
    @Value("${DECODED_SERVICE_KEY}")
    private String decodedServiceKey;

    @Value("${ENCODED_SERVICE_KEY}")
    private String encodedServiceKey;

    public String getDecodedServiceKey() {
        return decodedServiceKey;
    }

    public String getEncodedServiceKey() {
        return encodedServiceKey;
    }
}
