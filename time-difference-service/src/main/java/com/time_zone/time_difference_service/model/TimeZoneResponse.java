package com.time_zone.time_difference_service.model;

public class TimeZoneResponse {
    private String region;
    private double utcOffset;

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public double getUtcOffset() {
        return utcOffset;
    }

    public void setUtcOffset(double utcOffset) {
        this.utcOffset = utcOffset;
    }
}