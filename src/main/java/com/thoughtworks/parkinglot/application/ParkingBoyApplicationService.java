package com.thoughtworks.parkinglot.application;

import com.thoughtworks.parkinglot.domain.aggregate.parkingboy.ParkingBoy;
import com.thoughtworks.parkinglot.domain.aggregate.parkingboy.ParkingBoyFactory;
import com.thoughtworks.parkinglot.domain.aggregate.parkingboy.repo.ParkingLotRepo;
import com.thoughtworks.parkinglot.domain.aggregate.parkingboy.repo.ParkingSpotRepo;
import com.thoughtworks.parkinglot.domain.entity.ParkingSpot;
import com.thoughtworks.parkinglot.domain.entity.Ticket;
import com.thoughtworks.parkinglot.infrastructure.web.TicketService;
import com.thoughtworks.parkinglot.infrastructure.web.dto.CreateTicketDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ParkingBoyApplicationService {

    @Autowired
    private ParkingLotRepo parkingLotRepo;

    @Autowired
    private TicketService ticketService;

    @Autowired
    private ParkingSpotRepo spotRepo;

    public Ticket park(String car) {
        ParkingBoy boy = ParkingBoyFactory.create(parkingLotRepo.getLots());
        ParkingSpot spot = boy.boyPark(car);

        if (spot != null) {
            spotRepo.save(spot);
        }

        CreateTicketDto dto = new CreateTicketDto();
        dto.setCar(car);
        dto.setSpotId(spot.getNo());
        dto.setLotId(spot.getLotId());
        return ticketService.create(dto);
    }

}
