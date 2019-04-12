package com.thoughtworks.parkinglot.infrastructure.repo.domainrepo;

import com.thoughtworks.parkinglot.domain.aggregate.parkingboy.ParkingLot;
import com.thoughtworks.parkinglot.domain.aggregate.parkingboy.repo.ParkingLotRepo;
import com.thoughtworks.parkinglot.domain.entity.ParkingSpot;
import com.thoughtworks.parkinglot.infrastructure.repo.dorepo.ParkingSpotDoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class DataBaseParkingLotRepo implements ParkingLotRepo {
    @Autowired
   private  ParkingSpotDoRepo parkingSpotDoRepo;

    @Override
    public List<ParkingLot> getLots() {

        ParkingLot lot=new ParkingLot(parkingSpotDoRepo.findAll().stream().
                filter(t-> StringUtils.isEmpty(t.getCar())).map(e->e.toDomainEntity()).collect(Collectors.toList()));
        return Arrays.asList(lot);
    }

    @Override
    public void park(String spotId, String car) {

    }

    @Override
    public ParkingSpot findById(String slotId) {
        return null;
    }

    @Override
    public void removeCar(ParkingSpot spot) {

    }
}
