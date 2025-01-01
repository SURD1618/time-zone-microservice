package com.time_zone.time_difference_service.model;

public class TimeDifferenceResponse {
    private String region1;
    private String region2;
    private double timeDifference;

    public TimeDifferenceResponse(String region1, String region2, double timeDifference) {
        this.region1 = region1;
        this.region2 = region2;
        this.timeDifference = timeDifference;
    }

    public String getRegion1() {
        return region1;
    }

    public void setRegion1(String region1) {
        this.region1 = region1;
    }

    public String getRegion2() {
        return region2;
    }

    public void setRegion2(String region2) {
        this.region2 = region2;
    }

    public double getTimeDifference() {
        return timeDifference;
    }

    public void setTimeDifference(double timeDifference) {
        this.timeDifference = timeDifference;
    }
}

