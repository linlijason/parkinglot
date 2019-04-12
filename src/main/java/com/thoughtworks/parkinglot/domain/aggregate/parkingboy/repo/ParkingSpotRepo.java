package com.thoughtworks.parkinglot.domain.aggregate.parkingboy.repo;

import com.thoughtworks.parkinglot.domain.entity.ParkingSpot;

public interface ParkingSpotRepo {
    void save(ParkingSpot spot);
}
