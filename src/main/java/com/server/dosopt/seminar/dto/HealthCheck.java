package com.server.dosopt.seminar.dto;


import lombok.Getter;

@Getter
public class HealthCheck {

    private Integer code;
    private String status;
    private Boolean success;

    public HealthCheck(Integer code, String status, Boolean success){
        this.code = code;
        this.status = status;
        this.success = success;
    }


}
