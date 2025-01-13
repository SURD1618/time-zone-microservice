package com.time_zone.time_zone_service.controller;

import com.time_zone.time_zone_service.entity.TimeZone;
import com.time_zone.time_zone_service.repository.TimeZoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class TimeZoneController {

    @Autowired
    private Environment environment;

    @Autowired
    private TimeZoneRepository timeZoneRepository;

    @GetMapping("/time-zone/region/{region}")
    public TimeZone getTimeByRegion(@PathVariable String region){

        TimeZone timeZoneRegion = timeZoneRepository.findByRegion(region);

//        timeZoneRegion.setPort(Integer.parseInt(environment.getProperty("local.server.port")));

        if (timeZoneRegion == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Region not found: " + region);
        }

        return timeZoneRegion;
    }
}
