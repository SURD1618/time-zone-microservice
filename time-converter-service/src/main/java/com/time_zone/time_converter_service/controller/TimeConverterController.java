package com.time_zone.time_converter_service.controller;

import com.time_zone.time_converter_service.model.TimeConverterResponse;
import com.time_zone.time_converter_service.model.TimeDifferenceResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class TimeConverterController {

    @GetMapping("/time-convert/from/{fromRegion}/to/{toRegion}/time/{time}")
    public TimeConverterResponse convertTime(@PathVariable String fromRegion, @PathVariable String toRegion, @PathVariable String time){

        double timeDifference = fetchTimeDifference(fromRegion, toRegion);

//        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("hh:mm a");
//        LocalTime inputTime = LocalTime.parse(time, inputFormatter);

        time = time.trim();

        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("hh:mm a");         //expected format of the input time

        LocalTime inputTime;
        try {
            inputTime = LocalTime.parse(time, inputFormatter);              // Converts input time into a LocalTime object
        } catch (DateTimeParseException e) {
            throw new RuntimeException("Invalid time format!!!");
        }

        LocalTime convertedTime = inputTime                                     //adjusting the input time by adding the time difference
                .plusHours((long) timeDifference)
                .plusMinutes((long) ((timeDifference % 1) * 60));

        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("hh:mm a");      //expected format of the output time
        String formattedTime = convertedTime.format(outputFormatter);               //converts LocalTime obj back into string

        return new TimeConverterResponse(fromRegion, toRegion, time, formattedTime);
    }

    private double fetchTimeDifference(String fromRegion, String toRegion) {

        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("region1", fromRegion);
        uriVariables.put("region2", toRegion);


        ResponseEntity<TimeDifferenceResponse> responseEntity = new RestTemplate().getForEntity(            //http response
                "http://localhost:8001/time-difference/between/region1/{region1}/and/region2/{region2}", TimeDifferenceResponse.class, uriVariables
        );

        //TimeDifferenceResponse response = new TimeDifferenceResponse("India", "China", 2.5);

        TimeDifferenceResponse response = responseEntity.getBody();

        return response != null ? response.getTimeDifference() : 0.0;
    }
}
