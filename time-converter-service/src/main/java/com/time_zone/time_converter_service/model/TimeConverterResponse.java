package com.time_zone.time_converter_service.model;

public class TimeConverterResponse {
    private String fromRegion;
    private String toRegion;
    private String inputTime;
    private String convertedTime;

    public TimeConverterResponse(){

    }

    public TimeConverterResponse(String fromRegion, String toRegion, String inputTime, String convertedTime) {
        this.fromRegion = fromRegion;
        this.toRegion = toRegion;
        this.inputTime = inputTime;
        this.convertedTime = convertedTime;
    }

    public String getFromRegion() {
        return fromRegion;
    }

    public void setFromRegion(String fromRegion) {
        this.fromRegion = fromRegion;
    }

    public String getToRegion() {
        return toRegion;
    }

    public void setToRegion(String toRegion) {
        this.toRegion = toRegion;
    }

    public String getInputTime() {
        return inputTime;
    }

    public void setInputTime(String inputTime) {
        this.inputTime = inputTime;
    }

    public String getConvertedTime() {
        return convertedTime;
    }

    public void setConvertedTime(String convertedTime) {
        this.convertedTime = convertedTime;
    }
}
