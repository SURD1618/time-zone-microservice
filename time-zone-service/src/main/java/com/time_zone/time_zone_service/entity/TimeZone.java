package com.time_zone.time_zone_service.entity;

import jakarta.persistence.*;

@Entity
public class TimeZone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)                 //auto-increment column
    @Column(name = "id")
    private Long id;

    private String region;
    private double utcOffset;

//    private int port;

    public TimeZone(){

    }

    public TimeZone(Long id, String region, double utcOffset) {
        this.id = id;
        this.region = region;
        this.utcOffset = utcOffset;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

//    public int getPort() {
//        return port;
//    }

//    public void setPort(int port) {
//        this.port = port;
//    }
}
