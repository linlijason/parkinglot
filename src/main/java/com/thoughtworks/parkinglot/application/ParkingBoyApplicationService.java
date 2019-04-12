package com.thoughtworks.parkinglot.application;

import com.thoughtworks.parkinglot.domain.aggregate.parkingboy.ParkingBoy;
import com.thoughtworks.parkinglot.domain.aggregate.parkingboy.ParkingBoyFactory;
import com.thoughtworks.parkinglot.domain.aggregate.parkingboy.repo.ParkingLotRepo;
import com.thoughtworks.parkinglot.domain.aggregate.parkingboy.repo.ParkingSpotRepo;
import com.thoughtworks.parkinglot.domain.entity.ParkingSpot;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ParkingBoyApplicationService {

    @Autowired
    private ParkingLotRepo parkingLotRepo;

    @Autowired
    private ParkingSpotRepo spotRepo;

    public ParkingSpot park(String car) {
        ParkingBoy boy = ParkingBoyFactory.create(parkingLotRepo.getLots());
        ParkingSpot spot = boy.boyPark(car);

        if (spot != null) {
            spotRepo.save(spot);
        }

        return spot;
    }

}
