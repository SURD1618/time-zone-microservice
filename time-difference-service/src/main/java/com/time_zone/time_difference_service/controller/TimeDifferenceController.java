package com.time_zone.time_difference_service.controller;

import com.time_zone.time_difference_service.model.TimeDifferenceResponse;
import com.time_zone.time_difference_service.model.TimeZoneResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TimeDifferenceController {

    //    @Value("${timeZoneService.url}")
//    private String timeZoneServiceUrl;

//    private final TimeDifferenceService timeDifferenceService;
//
//    public TimeDifferenceController(TimeDifferenceService timeDifferenceService) {
//        this.timeDifferenceService = timeDifferenceService;
//    }

    @GetMapping("/time-difference/between/region1/{region1}/and/region2/{region2}")
    public TimeDifferenceResponse getTimeDifference(@PathVariable String region1, @PathVariable String region2){

        double utcOffset1 = fetchUtcOffsetFromTimeZoneService(region1);             //region1 utc offset

        double utcOffset2 = fetchUtcOffsetFromTimeZoneService(region2);             //region2 utc offset

        double timeDifference = Math.abs(utcOffset1 - utcOffset2);

        return new TimeDifferenceResponse(region1, region2, timeDifference);
    }

    private double fetchUtcOffsetFromTimeZoneService(String region) {
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("region", region);

        ResponseEntity<TimeZoneResponse> responseEntity = new RestTemplate().getForEntity(      //call to the Time-Zone service to get the UTC offset
//                timeZoneServiceUrl + "/time-zone/region/{region}", TimeZoneResponse.class, uriVariables
                "http://localhost:8000/time-zone/region/{region}", TimeZoneResponse.class, uriVariables

        );

        TimeZoneResponse response = responseEntity.getBody();
        return response != null ? response.getUtcOffset() : 0.0;
    }

}

