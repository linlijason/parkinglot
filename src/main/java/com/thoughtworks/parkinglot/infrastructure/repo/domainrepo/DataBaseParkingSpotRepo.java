package com.thoughtworks.parkinglot.infrastructure.repo.domainrepo;

import com.thoughtworks.parkinglot.domain.aggregate.parkingboy.repo.ParkingSpotRepo;
import com.thoughtworks.parkinglot.domain.entity.ParkingSpot;
import com.thoughtworks.parkinglot.infrastructure.repo.dataobject.ParkingSpotDO;
import com.thoughtworks.parkinglot.infrastructure.repo.dorepo.ParkingSpotDoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DataBaseParkingSpotRepo implements ParkingSpotRepo {

    @Autowired
    private ParkingSpotDoRepo parkingSpotDoRepo;

    @Override
    public void save(ParkingSpot spot) {
        ParkingSpotDO psDo=parkingSpotDoRepo.getOne(Integer.valueOf(spot.getNo()));
        psDo.setCar(spot.getParkedCar());
        parkingSpotDoRepo.save(psDo);
    }
}
