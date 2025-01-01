package com.time_zone.time_zone_service.repository;

import com.time_zone.time_zone_service.entity.TimeZone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeZoneRepository extends JpaRepository<TimeZone, Long> {

    TimeZone findByRegion(String region);

}
