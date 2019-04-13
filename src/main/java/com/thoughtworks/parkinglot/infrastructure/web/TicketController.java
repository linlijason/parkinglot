package com.thoughtworks.parkinglot.infrastructure.web;

import com.thoughtworks.parkinglot.domain.entity.Ticket;
import com.thoughtworks.parkinglot.infrastructure.web.dto.CreateTicketDto;
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
public class TicketController {

    @RequestMapping(value = "",method = RequestMethod.POST)
    public ResponseEntity<Ticket> create(@RequestBody CreateTicketDto dto){
        Ticket t=new Ticket();
        t.setId(UUID.randomUUID().toString());
        t.setLotId(dto.getLotId());
        t.setCar(dto.getCar());
        t.setSpotNo(dto.getSpotId());
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
                "/{id}").buildAndExpand(t.getId()).toUri();
        return ResponseEntity.created(location).body(t);

    }
}
