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

@RestController
@RequestMapping("tickets")
public class TicketController  {

    @Autowired
    private TicketService ticketService;

    @RequestMapping(value = "",method = RequestMethod.POST)
    public ResponseEntity<Ticket> create(@RequestBody CreateTicketDto dto){

        Ticket ticket = ticketService.create(dto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
                "/{id}").buildAndExpand(ticket.getId()).toUri();
        return ResponseEntity.created(location).body(ticket);

    }
}
