package com.ydmins.mybatisopenapi.model;

import com.ydmins.mybatisopenapi.web.dto.MediumLandForecastDto;
import lombok.Data;

@Data
public class MediumLandForecast {

    private String mediumLandId;
    private String tmFc;
    private String regId;

    private int rnSt3Am;
    private int rnSt3Pm;
    private int rnSt4Am;
    private int rnSt4Pm;
    private int rnSt5Am;
    private int rnSt5Pm;
    private int rnSt6Am;
    private int rnSt6Pm;
    private int rnSt7Am;
    private int rnSt7Pm;
    private int rnSt8;
    private int rnSt9;
    private int rnSt10;

    private String wf3Am;
    private String wf3Pm;
    private String wf4Am;
    private String wf4Pm;
    private String wf5Am;
    private String wf5Pm;
    private String wf6Am;
    private String wf6Pm;
    private String wf7Am;
    private String wf7Pm;
    private String wf8;
    private String wf9;
    private String wf10;

    public MediumLandForecast(String mediumLandId, String tmFc, String regId, int rnSt3Am, int rnSt3Pm, int rnSt4Am, int rnSt4Pm, int rnSt5Am, int rnSt5Pm, int rnSt6Am, int rnSt6Pm, int rnSt7Am, int rnSt7Pm, int rnSt8, int rnSt9, int rnSt10, String wf3Am, String wf3Pm, String wf4Am, String wf4Pm, String wf5Am, String wf5Pm, String wf6Am, String wf6Pm, String wf7Am, String wf7Pm, String wf8, String wf9, String wf10) {
        this.mediumLandId = mediumLandId;
        this.tmFc = tmFc;
        this.regId = regId;
        this.rnSt3Am = rnSt3Am;
        this.rnSt3Pm = rnSt3Pm;
        this.rnSt4Am = rnSt4Am;
        this.rnSt4Pm = rnSt4Pm;
        this.rnSt5Am = rnSt5Am;
        this.rnSt5Pm = rnSt5Pm;
        this.rnSt6Am = rnSt6Am;
        this.rnSt6Pm = rnSt6Pm;
        this.rnSt7Am = rnSt7Am;
        this.rnSt7Pm = rnSt7Pm;
        this.rnSt8 = rnSt8;
        this.rnSt9 = rnSt9;
        this.rnSt10 = rnSt10;
        this.wf3Am = wf3Am;
        this.wf3Pm = wf3Pm;
        this.wf4Am = wf4Am;
        this.wf4Pm = wf4Pm;
        this.wf5Am = wf5Am;
        this.wf5Pm = wf5Pm;
        this.wf6Am = wf6Am;
        this.wf6Pm = wf6Pm;
        this.wf7Am = wf7Am;
        this.wf7Pm = wf7Pm;
        this.wf8 = wf8;
        this.wf9 = wf9;
        this.wf10 = wf10;
    }

    public MediumLandForecast(String mediumLandId, String tmFc, String regId) {
        this.mediumLandId = mediumLandId;
        this.tmFc = tmFc;
        this.regId = regId;
    }

    public MediumLandForecast(String mediumLandId, String tmFc, String regId, MediumLandForecastDto dto) {
        this.mediumLandId = mediumLandId;
        this.tmFc = tmFc;
        this.regId = regId;
        this.rnSt3Am = dto.getRnSt3Am();
        this.rnSt3Pm = dto.getRnSt3Pm();
        this.rnSt4Am = dto.getRnSt4Am();
        this.rnSt4Pm = dto.getRnSt4Pm();
        this.rnSt5Am = dto.getRnSt5Am();
        this.rnSt5Pm = dto.getRnSt5Pm();
        this.rnSt6Am = dto.getRnSt6Am();
        this.rnSt6Pm = dto.getRnSt6Pm();
        this.rnSt7Am = dto.getRnSt7Am();
        this.rnSt7Pm = dto.getRnSt7Pm();
        this.rnSt8 = dto.getRnSt8();
        this.rnSt9 = dto.getRnSt9();
        this.rnSt10 = dto.getRnSt10();

        this.wf3Am = dto.getWf3Am();
        this.wf3Pm = dto.getWf3Pm();
        this.wf4Am = dto.getWf4Am();
        this.wf4Pm = dto.getWf4Pm();
        this.wf5Am = dto.getWf5Am();
        this.wf5Pm = dto.getWf5Pm();
        this.wf6Am = dto.getWf6Am();
        this.wf6Pm = dto.getWf6Pm();
        this.wf7Am = dto.getWf7Am();
        this.wf7Pm = dto.getWf7Pm();
        this.wf8 = dto.getWf8();
        this.wf9 = dto.getWf9();
        this.wf10 = dto.getWf10();
    }

}
