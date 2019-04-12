package com.thoughtworks.parkinglot.domain.aggregate.ticket;

import com.thoughtworks.parkinglot.domain.entity.Ticket;

import java.util.UUID;

public class TicketFactory {

    public static Ticket create(String car,String lotId){
        Ticket t= new Ticket();
        t.setCar(car);
        t.setId(UUID.randomUUID().toString());
        t.setLotId(lotId);
        return t;
    }
}
