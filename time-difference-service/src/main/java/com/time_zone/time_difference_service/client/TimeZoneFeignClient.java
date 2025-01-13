package com.time_zone.time_difference_service.client;

import com.time_zone.time_difference_service.model.TimeZoneResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "time-zone-service") // Name must match the `spring.application.name` of time-zone-service
public interface TimeZoneFeignClient {

    @GetMapping("/time-zone/region/{region}")
    TimeZoneResponse getTimeZoneByRegion(@PathVariable("region") String region);
}
