
package com.thoughtworks.parkinglot.infrastructure.web;

import com.thoughtworks.parkinglot.application.ParkingBoyApplicationService;
import com.thoughtworks.parkinglot.domain.entity.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("parking-spots")
public class ParkingSpotController {

    @Autowired
    ParkingBoyApplicationService  parkingBoyApplicationService;

    public ParkingSpotController(ParkingBoyApplicationService parkingBoyApplicationService) {
        this.parkingBoyApplicationService = parkingBoyApplicationService;
    }

    @RequestMapping("/request")
    public Ticket request(String car){
        return parkingBoyApplicationService.park(car);
    }
}
