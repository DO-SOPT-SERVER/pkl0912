package com.server.dosopt.seminar.dto;

import lombok.Getter;

@Getter
public class HealthCheckResponse {
    private String status;

    private static final String STATUS = "OK";
    public HealthCheckResponse(String status) {
        this.status = status;
    }

    public static HealthCheckResponse ok(){
        return new HealthCheckResponse(STATUS);
    }
}
