
package com.thoughtworks.parkinglot.infrastructure.web;

import com.thoughtworks.parkinglot.application.ParkingBoyApplicationService;
import com.thoughtworks.parkinglot.domain.entity.ParkingSpot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("parking-spots")
public class ParkingSpotController {

    @Autowired
    ParkingBoyApplicationService  parkingBoyApplicationService;

    @RequestMapping("/request")
    public ParkingSpot request(String car){
        return parkingBoyApplicationService.park(car);
    }
}
