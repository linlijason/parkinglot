package com.thoughtworks.parkinglot.domain.aggregate.parkingboy;

import com.thoughtworks.parkinglot.domain.entity.NoParkingSpotException;
import com.thoughtworks.parkinglot.domain.entity.ParkingSpot;
import com.thoughtworks.parkinglot.domain.entity.Ticket;

import java.util.ArrayList;
import java.util.List;

public class ParkingManager extends ParkingBoy {

    List<ParkingBoy> boys;

    public ParkingManager(List<ParkingLot> lots, List<ParkingBoy> boys) {
        super(lots);
        this.boys = boys;
    }

    public ParkingManager(List<ParkingLot> lots) {
        super(lots);
    }


    @Override
    public List<ParkingSpot> boyParks(List<String> cars) {
        int totalPlots=getAviableLots();

        if(totalPlots<cars.size()){
            throw new NoParkingSpotException();
        }
        List<ParkingSpot> result=new ArrayList<>();
        boolean hasDone=false;
        if(boys!=null){
            for (ParkingBoy boy : boys) {
                if(boy.getAviableLots()==0) continue;
                List<String> tmpCars=cars.subList(0,Math.min(cars.size(), boy.getAviableLots()));
                result.addAll(boy.boyParks(tmpCars));

                if(cars.size()>tmpCars.size()){
                    //
                    cars=cars.subList(tmpCars.size(),cars.size());
                }else{
                    hasDone=true;
                    break;
                }
            }
        }
        if(!hasDone){
            result.addAll(super.boyParks(cars));
        }
        return result;
    }

    @Override
    public int getAviableLots() {
        return (boys==null?0:boys.stream().map(t -> t.getAviableLots()).reduce(0, Integer::sum))+super.getAviableLots();
    }
}
