package com.thoughtworks.parkinglot.infrastructure;

import com.thoughtworks.parkinglot.application.ParkingBoyApplicationService;
import com.thoughtworks.parkinglot.domain.entity.Ticket;

public class App {
    public static void main(String[] args) {
        ParkingBoyApplicationService service=new ParkingBoyApplicationService();
      //  System.out.println(service.park("ss").getId());
        //Ticket t=service.park("川A001");
       // System.out.println(service.pick(t));
    }

}
