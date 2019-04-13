package com.thoughtworks.parkinglot.infrastructure.web;

import com.thoughtworks.parkinglot.domain.entity.Ticket;
import com.thoughtworks.parkinglot.infrastructure.web.dto.CreateTicketDto;
import com.thoughtworks.parkinglot.infrastructure.web.dto.TicketServiceFailure;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "${ticket-service.name}", fallback = TicketServiceFailure.class)
public interface TicketService {

    @RequestMapping(value = "/tickets",method = RequestMethod.POST)
    Ticket create(@RequestBody CreateTicketDto dto);
}
