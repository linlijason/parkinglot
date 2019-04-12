package com.thoughtworks.parkinglot.domain.aggregate.parkingboy;

import com.thoughtworks.parkinglot.domain.entity.NoParkingSpotException;
import com.thoughtworks.parkinglot.domain.entity.TakeCarException;
import com.thoughtworks.parkinglot.domain.entity.Ticket;
import com.thoughtworks.parkinglot.domain.entity.ParkingSpot;

import java.util.*;
import java.util.stream.Collectors;

public class ParkingLot {

    List<ParkingSpot> spots;//数据库

    List<Ticket> tickets = new ArrayList<>();//数据库
    private String id;

    public String getId() {
        return id;
    }


    public ParkingLot(int capacity) {

        id=UUID.randomUUID().toString();
        spots = new ArrayList<>(capacity);

        for (int i = 0; i < capacity; i++) {
            ParkingSpot spot = new ParkingSpot();
            spot.setNo("软件园-" + i);
            spots.add(spot);
        }
    }
    public ParkingLot( List<ParkingSpot> spots){
        this.spots=spots;
        this.id=spots.get(0).getLotId();
    }



    public ParkingSpot parkOneCar(String car) {
        List<ParkingSpot> ts=parkMultiCars(Arrays.asList(car));
        return ts.get(0);
    }

    public List<ParkingSpot> parkMultiCars(List<String> cars) {
        List<ParkingSpot> spots = checkSplot(cars);
        for (int i = 0; i < spots.size(); i++) {
            spots.get(i).setParkedCar(cars.get(i));
        }
        return spots;
    }

    public int getAvaliableNum(){
        return getAvaliableParkingSpots(spots.size()).size();
    }

    public ParkingSpot[] takeMultiCars(List<String> ticketIds) {
        ParkingSpot[] cars=new ParkingSpot[ticketIds.size()];
        for (int i = 0; i < ticketIds.size(); i++) {
            cars[i]=takeOneCar(ticketIds.get(i));
        }
        return cars;
    }

    public ParkingSpot takeOneCar(String ticket) {

        List<ParkingSpot> listPs= findParkSpotByTicket(Arrays.asList(ticket));

        if(listPs.size()==0) {
            throw new TakeCarException();
        }
        tickets.removeIf(t -> t.getId().equals(ticket));
        return listPs.get(0);
    }

    private List<ParkingSpot> findParkSpotByTicket(List<String> ticketIds) {

        List<ParkingSpot> resultSpots=new ArrayList<>();
        tickets.stream().filter(t -> ticketIds.contains(t.getId())).forEach(t->{
            spots.stream().filter(x-> x.getNo().equals(t.getSpotNo())).
                    findFirst().ifPresent(p->resultSpots.add(p));
        });
        return resultSpots;
    }

    private List<ParkingSpot> getAvaliableParkingSpots(int limit) {
        return spots.stream().filter(t -> t.getParkedCar() == null || t.getParkedCar().length()==0).limit(limit).collect(Collectors.toList());
    }

    private List<ParkingSpot> checkSplot(List<String> cars) {
        List<ParkingSpot> spots=getAvaliableParkingSpots(cars.size());
        if(spots.size()!=cars.size())
            throw new NoParkingSpotException();
        return spots;
    }
}
