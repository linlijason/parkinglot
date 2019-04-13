package com.thoughtworks.parkinglot.infrastructure.web;

import com.thoughtworks.parkinglot.domain.entity.Ticket;
import com.thoughtworks.parkinglot.infrastructure.web.dto.CreateTicketDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("tickets")
public class TicketController  {

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Ticket> create(@RequestBody CreateTicketDto dto){

        Ticket ticket = new Ticket();
        ticket.setId(UUID.randomUUID().toString());
        ticket.setCar(dto.getCar());
        ticket.setLotId(dto.getLotId());
        ticket.setSpotNo(dto.getLotId());
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(ticket.getId()).toUri();
        return ResponseEntity.created(location).body(ticket);

    }
}
