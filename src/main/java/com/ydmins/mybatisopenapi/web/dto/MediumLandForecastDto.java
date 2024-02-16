package com.ydmins.mybatisopenapi.web.dto;

import lombok.Builder;

@Builder
public class MediumLandForecastDto {

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

    public MediumLandForecastDto() {
    }

    public MediumLandForecastDto(int rnSt3Am, int rnSt3Pm, int rnSt4Am, int rnSt4Pm, int rnSt5Am, int rnSt5Pm,
                                 int rnSt6Am, int rnSt6Pm, int rnSt7Am, int rnSt7Pm, int rnSt8, int rnSt9, int rnSt10, String wf3Am, String wf3Pm, String wf4Am, String wf4Pm, String wf5Am, String wf5Pm, String wf6Am, String wf6Pm, String wf7Am, String wf7Pm, String wf8, String wf9, String wf10) {
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

    public int getRnSt3Am() {
        return rnSt3Am;
    }

    public int getRnSt3Pm() {
        return rnSt3Pm;
    }

    public int getRnSt4Am() {
        return rnSt4Am;
    }

    public int getRnSt4Pm() {
        return rnSt4Pm;
    }

    public int getRnSt5Am() {
        return rnSt5Am;
    }

    public int getRnSt5Pm() {
        return rnSt5Pm;
    }

    public int getRnSt6Am() {
        return rnSt6Am;
    }

    public int getRnSt6Pm() {
        return rnSt6Pm;
    }

    public int getRnSt7Am() {
        return rnSt7Am;
    }

    public int getRnSt7Pm() {
        return rnSt7Pm;
    }

    public int getRnSt8() {
        return rnSt8;
    }

    public int getRnSt9() {
        return rnSt9;
    }

    public int getRnSt10() {
        return rnSt10;
    }

    public String getWf3Am() {
        return wf3Am;
    }

    public String getWf3Pm() {
        return wf3Pm;
    }

    public String getWf4Am() {
        return wf4Am;
    }

    public String getWf4Pm() {
        return wf4Pm;
    }

    public String getWf5Am() {
        return wf5Am;
    }

    public String getWf5Pm() {
        return wf5Pm;
    }

    public String getWf6Am() {
        return wf6Am;
    }

    public String getWf6Pm() {
        return wf6Pm;
    }

    public String getWf7Am() {
        return wf7Am;
    }

    public String getWf7Pm() {
        return wf7Pm;
    }

    public String getWf8() {
        return wf8;
    }

    public String getWf9() {
        return wf9;
    }

    public String getWf10() {
        return wf10;
    }
}