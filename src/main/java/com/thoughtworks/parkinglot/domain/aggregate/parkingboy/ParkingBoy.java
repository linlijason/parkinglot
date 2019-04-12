package com.thoughtworks.parkinglot.domain.aggregate.parkingboy;

import com.thoughtworks.parkinglot.domain.entity.NoParkingSpotException;
import com.thoughtworks.parkinglot.domain.entity.ParkingSpot;
import com.thoughtworks.parkinglot.domain.entity.TakeCarException;
import com.thoughtworks.parkinglot.domain.entity.Ticket;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParkingBoy {
    List<ParkingLot> lots;

    public ParkingBoy(List<ParkingLot> lots) {
        this.lots=lots;
    }

    public ParkingSpot boyPark(String car) {
        return boyParks(Arrays.asList(car)).get(0);
    }

    public List<ParkingSpot> boyParks(List<String> cars) {

        int totalSpot = lots.stream().map(t -> t.getAvaliableNum()).reduce(0, Integer::sum);
        if (totalSpot < cars.size()) {
            throw new NoParkingSpotException();
        }
        List<ParkingSpot> spots = new ArrayList<>();

        for (ParkingLot lot : lots.stream().filter(t-> t.getAvaliableNum()>0).collect(Collectors.toList())) {
            int avaliableSize=Math.min( lot.getAvaliableNum(),cars.size());
            List<String> tmpCars=cars.subList(0,avaliableSize);
            spots.addAll( lot.parkMultiCars(tmpCars));
            int remain=cars.size()-avaliableSize;
            if(remain==0)
                break;
            cars=cars.subList(avaliableSize,cars.size());
        }

        return spots;

    }

    public ParkingSpot takeCar(Ticket ticket) {
        for (ParkingLot lot : lots) {
            if(lot.getId().equals(ticket.getLotId())){
                return lot.takeOneCar(ticket.getId());
            }
        }
        throw new TakeCarException();
    }

    public int getAviableLots(){
        return lots.stream().filter(l->l.getAvaliableNum()>0).map(t->t.getAvaliableNum()).reduce(0,Integer::sum);
    }
}
