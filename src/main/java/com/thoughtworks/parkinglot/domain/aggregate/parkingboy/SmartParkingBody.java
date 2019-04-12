package com.thoughtworks.parkinglot.domain.aggregate.parkingboy;

import com.thoughtworks.parkinglot.domain.entity.NoParkingSpotException;
import com.thoughtworks.parkinglot.domain.entity.ParkingSpot;
import com.thoughtworks.parkinglot.domain.entity.Ticket;

import java.util.ArrayList;
import java.util.List;

public class SmartParkingBody extends ParkingBoy {

    public SmartParkingBody(List<ParkingLot> lots) {
        super(lots);
    }

    @Override
    public List<ParkingSpot> boyParks(List<String> cars) {

        int totalSpot = lots.stream().map(t -> t.getAvaliableNum()).reduce(0, Integer::sum);
        if (totalSpot < cars.size()) {
            throw new NoParkingSpotException();
        }
        List<ParkingSpot> tickets = new ArrayList<>();
        cars.forEach(t->{
            lots.stream().filter(k->k.getAvaliableNum()>0).sorted((o1, o2) -> Integer.compare(o2.getAvaliableNum(),o1.getAvaliableNum())).findFirst().ifPresent(lot->{
                tickets.add(lot.parkOneCar(t));

            });
        });

        return tickets;
    }
}
