package com.time_zone.time_converter_service.client;

import com.time_zone.time_converter_service.model.TimeDifferenceResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "time-difference-service")
public interface TimeDifferenceFeignClient {

    @GetMapping("/time-difference/between/region1/{region1}/and/region2/{region2}")
    TimeDifferenceResponse getTimeDifference(@PathVariable String region1, @PathVariable String region2);
}
