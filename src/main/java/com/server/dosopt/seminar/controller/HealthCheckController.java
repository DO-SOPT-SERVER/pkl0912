package com.server.dosopt.seminar.controller;

import com.server.dosopt.seminar.dto.HealthCheck;
import com.server.dosopt.seminar.dto.HealthCheckResponse;
import com.server.dosopt.seminar.sample.Person;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;



@RestController
@RequestMapping("/health")
public class HealthCheckController {
    @GetMapping("/v1")
    public Map<String, String> healthCheck(){
        Map<String, String> response = new HashMap<>();
        response.put("status", "OK");
        return response;
    }

    @GetMapping("/v2")
    public ResponseEntity<String> healthCeckv2(){
        return ResponseEntity.ok("OK");
    }

    @GetMapping("/v3")
    public String healthCheckv3(){
        Person person = new Person("park", "kyounglin");
        Person person2 = Person.builder()
                .lastname("park")
                .firstname("kyounglin")
                .build();
        return "ok";
    }

    @GetMapping("/v4")
    public ResponseEntity<Map<String, String>> healthCheckv4(){
        Map<String, String > response = new HashMap<>();
        response.put("status", "ok");
        return ResponseEntity.ok(response);

    }
    @GetMapping("/v5")
    public ResponseEntity<HealthCheckResponse> healthCheckv5(){
        return ResponseEntity.ok(HealthCheckResponse.ok());
    }



}
