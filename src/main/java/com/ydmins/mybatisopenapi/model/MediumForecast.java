package com.ydmins.mybatisopenapi.model;

import lombok.Data;

@Data
public class MediumForecast {
    private String mediumTermId;
    private String tmFc;
    private int stnId;
    private String wfSv;

    public MediumForecast(String mediumTermId, String tmFc, int stnId, String wfSv) {
        this.mediumTermId = mediumTermId;
        this.tmFc = tmFc;
        this.stnId = stnId;
        this.wfSv = wfSv;
    }
}
