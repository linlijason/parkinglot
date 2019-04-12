package com.thoughtworks.parkinglot.domain.aggregate.parkingboy.repo;

import com.thoughtworks.parkinglot.domain.aggregate.parkingboy.ParkingLot;
import com.thoughtworks.parkinglot.domain.entity.ParkingSpot;

import java.util.List;

public interface ParkingLotRepo {

    List<ParkingLot> getLots();

    void park(String spotId,String car);

    ParkingSpot findById(String slotId);

    void removeCar(ParkingSpot spot);
}
