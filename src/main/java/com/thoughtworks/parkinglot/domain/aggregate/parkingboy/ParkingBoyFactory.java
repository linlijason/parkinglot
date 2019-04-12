package com.thoughtworks.parkinglot.domain.aggregate.parkingboy;

import java.util.List;

public class ParkingBoyFactory {
    public static ParkingBoy create(List<ParkingLot> lots){
        ParkingBoy boy=new ParkingBoy(lots);
        return boy;
    }
}
