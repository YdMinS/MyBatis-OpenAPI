package com.ydmins.mybatisopenapi.model;

import com.ydmins.mybatisopenapi.web.dto.MediumTemperatureForecastDto;
import lombok.Data;

@Data
public class MediumTemperatureForecast {

    private String mediumTempId;
    private String tmFc;
    private String regId;

    private int taMin3;
    private int taMin3Low;
    private int taMin3High;
    private int taMax3;
    private int taMax3Low;
    private int taMax3High;
    private int taMin4;
    private int taMin4Low;
    private int taMin4High;
    private int taMax4;
    private int taMax4Low;
    private int taMax4High;
    private int taMin5;
    private int taMin5Low;
    private int taMin5High;
    private int taMax5;
    private int taMax5Low;
    private int taMax5High;
    private int taMin6;
    private int taMin6Low;
    private int taMin6High;
    private int taMax6;
    private int taMax6Low;
    private int taMax6High;
    private int taMin7;
    private int taMin7Low;
    private int taMin7High;
    private int taMax7;
    private int taMax7Low;
    private int taMax7High;
    private int taMin8;
    private int taMin8Low;
    private int taMin8High;
    private int taMax8;
    private int taMax8Low;
    private int taMax8High;
    private int taMin9;
    private int taMin9Low;
    private int taMin9High;
    private int taMax9;
    private int taMax9Low;
    private int taMax9High;
    private int taMin10;
    private int taMin10Low;
    private int taMin10High;
    private int taMax10;
    private int taMax10Low;
    private int taMax10High;

    public MediumTemperatureForecast(String mediumTempId, String tmFc, String regId, int taMin3, int taMin3Low, int taMin3High, int taMax3, int taMax3Low, int taMax3High, int taMin4, int taMin4Low, int taMin4High, int taMax4, int taMax4Low, int taMax4High, int taMin5, int taMin5Low, int taMin5High, int taMax5, int taMax5Low, int taMax5High, int taMin6, int taMin6Low, int taMin6High, int taMax6, int taMax6Low, int taMax6High, int taMin7, int taMin7Low, int taMin7High, int taMax7, int taMax7Low, int taMax7High, int taMin8, int taMin8Low, int taMin8High, int taMax8, int taMax8Low, int taMax8High, int taMin9, int taMin9Low, int taMin9High, int taMax9, int taMax9Low, int taMax9High, int taMin10, int taMin10Low, int taMin10High, int taMax10, int taMax10Low, int taMax10High) {
        this.mediumTempId = mediumTempId;
        this.tmFc = tmFc;
        this.regId = regId;
        this.taMin3 = taMin3;
        this.taMin3Low = taMin3Low;
        this.taMin3High = taMin3High;
        this.taMax3 = taMax3;
        this.taMax3Low = taMax3Low;
        this.taMax3High = taMax3High;
        this.taMin4 = taMin4;
        this.taMin4Low = taMin4Low;
        this.taMin4High = taMin4High;
        this.taMax4 = taMax4;
        this.taMax4Low = taMax4Low;
        this.taMax4High = taMax4High;
        this.taMin5 = taMin5;
        this.taMin5Low = taMin5Low;
        this.taMin5High = taMin5High;
        this.taMax5 = taMax5;
        this.taMax5Low = taMax5Low;
        this.taMax5High = taMax5High;
        this.taMin6 = taMin6;
        this.taMin6Low = taMin6Low;
        this.taMin6High = taMin6High;
        this.taMax6 = taMax6;
        this.taMax6Low = taMax6Low;
        this.taMax6High = taMax6High;
        this.taMin7 = taMin7;
        this.taMin7Low = taMin7Low;
        this.taMin7High = taMin7High;
        this.taMax7 = taMax7;
        this.taMax7Low = taMax7Low;
        this.taMax7High = taMax7High;
        this.taMin8 = taMin8;
        this.taMin8Low = taMin8Low;
        this.taMin8High = taMin8High;
        this.taMax8 = taMax8;
        this.taMax8Low = taMax8Low;
        this.taMax8High = taMax8High;
        this.taMin9 = taMin9;
        this.taMin9Low = taMin9Low;
        this.taMin9High = taMin9High;
        this.taMax9 = taMax9;
        this.taMax9Low = taMax9Low;
        this.taMax9High = taMax9High;
        this.taMin10 = taMin10;
        this.taMin10Low = taMin10Low;
        this.taMin10High = taMin10High;
        this.taMax10 = taMax10;
        this.taMax10Low = taMax10Low;
        this.taMax10High = taMax10High;
    }

    public MediumTemperatureForecast(String mediumTempId, String tmFc, String regId) {
        this.mediumTempId = mediumTempId;
        this.tmFc = tmFc;
        this.regId = regId;
    }

    public MediumTemperatureForecast(String mediumTempId, String tmFc, String regId, MediumTemperatureForecastDto dto) {
        this.mediumTempId = mediumTempId;
        this.tmFc = tmFc;
        this.regId = regId;
        this.taMin3 = dto.getTaMin3();
        this.taMin3Low = dto.getTaMin3Low();
        this.taMin3High = dto.getTaMin3High();
        this.taMax3 = dto.getTaMax3();
        this.taMax3Low = dto.getTaMax3Low();
        this.taMax3High =dto.getTaMax3High();
        this.taMin4 = dto.getTaMin4();
        this.taMin4Low = dto.getTaMin4Low();
        this.taMin4High =dto.getTaMin4High();
        this.taMax4 = dto.getTaMax4();
        this.taMax4Low = dto.getTaMax4Low();
        this.taMax4High =dto.getTaMax4High();
        this.taMin5 = dto.getTaMin5();
        this.taMin5Low = dto.getTaMin5Low();
        this.taMin5High =dto.getTaMin5High();
        this.taMax5 = dto.getTaMax5();
        this.taMax5Low = dto.getTaMax5Low();
        this.taMax5High =dto.getTaMax5High();
        this.taMin6 = dto.getTaMin6();
        this.taMin6Low = dto.getTaMin6Low();
        this.taMin6High =dto.getTaMin6High();
        this.taMax6 = dto.getTaMax6();
        this.taMax6Low = dto.getTaMax6Low();
        this.taMax6High =dto.getTaMax6High();
        this.taMin7 = dto.getTaMin7();
        this.taMin7Low = dto.getTaMin7Low();
        this.taMin7High =dto.getTaMin7High();
        this.taMax7 = dto.getTaMax7();
        this.taMax7Low = dto.getTaMax7Low();
        this.taMax7High =dto.getTaMax7High();
        this.taMin8 = dto.getTaMin8();
        this.taMin8Low = dto.getTaMin8Low();
        this.taMin8High =dto.getTaMin3High();
        this.taMax8 = dto.getTaMax8();
        this.taMax8Low = dto.getTaMax8Low();
        this.taMax8High =dto.getTaMax8High();
        this.taMin9 = dto.getTaMin9();
        this.taMin9Low = dto.getTaMin9Low();
        this.taMin9High =dto.getTaMin9High();
        this.taMax9 = dto.getTaMax9();
        this.taMax9Low = dto.getTaMax9Low();
        this.taMax9High =dto.getTaMax9High();
        this.taMin10 = dto.getTaMin10();
        this.taMin10Low = dto.getTaMin10Low();
        this.taMin10High =dto.getTaMin10High();
        this.taMax10 = dto.getTaMax10();
        this.taMax10Low = dto.getTaMax10Low();
        this.taMax10High =dto.getTaMax10High();
    }

}
